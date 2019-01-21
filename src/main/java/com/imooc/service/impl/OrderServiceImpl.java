package com.imooc.service.impl;

import com.imooc.converter.OrderMaster2OrderDtoConverter;
import com.imooc.dataobject.OrderDetail;
import com.imooc.dataobject.OrderMaster;
import com.imooc.dataobject.ProductInfo;
import com.imooc.dto.CartDTO;
import com.imooc.dto.OrderDTO;
import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.PayStatusEnum;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.repository.OrderDetailRepository;
import com.imooc.repository.OrderMasterRepository;
import com.imooc.repository.ProductInfoRepository;
import com.imooc.service.OrderService;
import com.imooc.service.ProductService;
import com.imooc.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2018/10/2 0002 12:12
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMasterRepository orderMasterRepository;
    @Autowired
    private ProductInfoRepository productInfoRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private ProductService productService;

    @Override
    /** 1 创建订单；
     * 添加事务保证一致性；*/
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {
        /**整个订单的oid,
         * 创建的时候就已经生成了*/
        String orderId = KeyUtil.genUniqueKey();
        /**0 初始化总价*/
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
        List<CartDTO> cartDTOS = new ArrayList<>();
        /** 1 查询商品数量，总价*/
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            /** 遍历订单里面的商品详情集合,
             * 订单详情里面有商品的id;
             * 根据商品的id,一次查询一条商品的数据*/
            ProductInfo productInfo = productInfoRepository.findOne(orderDetail.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            /** 2 计算总价,商品详情里面有对应的商品的数据；
             * 用productInfo，detail传入的只有很少的值，有的为null*/
            orderAmount = productInfo.getProductPrice().multiply(new BigDecimal(orderDetail.
                    getProductQuantity())).add(orderAmount
            );
            /** 3 订单详情入库*/

            /**拷贝属性到orderDetail，这个时候的订单详情的id是不存在的
             * 所有详情的id要咋后面设置，前面的化会进行覆盖*/
            BeanUtils.copyProperties(productInfo, orderDetail);
            /**设置订单详情的id*/
            orderDetail.setDetailId(KeyUtil.genUniqueKey());
            /**一个订单的id对应多个订单项,订单项不仅仅订单项的id还要--------订单的id,
             * 因为这个订单项是属于哪个订单的；
             * 属性拷贝会用null进行覆盖，
             * 所以要放到后面，最后进行设置*/
            /**为订单项设置订单id*/
            orderDetail.setOrderId(orderId);
            /**订单项入库*/
            orderDetailRepository.save(orderDetail);
           /*方案一： CartDTO cartDTO  =new CartDTO(orderDetail.getProductId(),orderDetail.getProductQuantity());
            cartDTOS.add(cartDTO);*/


        }
        /** 4 写入订单到数据库*/
        OrderMaster orderMaster = new OrderMaster();
        /**要放在前面？？？？后面？？？没有区别*/
        /**orderDTO里面没有订单号，所有设置*/
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterRepository.save(orderMaster);
        /**5 减库存
         * 集合指向结果，扣除库存放在外面*/
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream().map(e ->
                new CartDTO(e.getProductId(), e.getProductQuantity())
        ).collect(Collectors.toList());
        //todo ???怎么减掉的库存
       /* orderDTO.getOrderDetailList().stream()
                .map(e->new CartDTO(e.getProductId(),e.getProductQuantity())).collect(Collectors.toList());*/
        productService.decreaseStock(cartDTOList);
        return orderDTO;
    }

    /**
     * 2 根据订单的id查询订单，返回多个订单项的详情
     */
    @Override
    public OrderDTO findOne(String orderId) {
        /**查出订单*/
        OrderMaster orderMaster = orderMasterRepository.findOne(orderId);
        if (orderMaster == null) {
            /**判断订单是否存在*/
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        /**订单项:根据订单的id查询订单详情的集合，一个订单的id对应一个或者多个订单详情的id*/
        List<OrderDetail> byOrderId = orderDetailRepository.findByOrderId(orderId);
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        /**设置订单项的集合到订单vo*/
        orderDTO.setOrderDetailList(byOrderId);
        /**返回orderDTO里面包很多的订单详情*/
        return orderDTO;
    }

    @Override
    /**3 查询订单列表，列表里面不显示订单详情*/
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        /**用户的订单列表*/
        Page<OrderMaster> orderMasterPage = orderMasterRepository.findByBuyerOpenid(buyerOpenid, pageable);
        /**不需要判断，找到就返回，找不到返回空*/
        /**??????????????*/
        List<OrderDTO> orderDTOList = OrderMaster2OrderDtoConverter.convert(orderMasterPage.getContent());
        /**数据，分页，总的数据*/
        return new PageImpl<>(orderDTOList, pageable, orderMasterPage.getTotalElements());
    }

    @Override
    /** 4 订单取消，返回库存，退还金额*/
    public OrderDTO cancel(OrderDTO orderDTO) {
        /**必须是新下的订单才可以取消，完结的订单不可以取消的*/
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster);
        /**进行取反*/
        if (!orderDTO.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())) {
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }
/** 2 修改订单的状态，*/
        orderDTO.setOrderStatus(OrderStatusEnum.CANCEL.getCode());
        BeanUtils.copyProperties(orderMaster, orderDTO);

        OrderMaster orderMasterResult = orderMasterRepository.save(orderMaster);
        if (orderMasterResult == null) {
            throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);
        }
        /**3 返还库存，为了代码的健壮性要判断订单里面是否有商品*/
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            //
            throw new SellException(ResultEnum.ORDER_DETAIL_EMPTY);
        }
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream()
                .map(e -> new CartDTO(e.getProductId(), e.getProductQuantity()))
                .collect(Collectors.toList());
        productService.increaseStock(cartDTOList);
        return orderDTO;
    }

    /**
     * 5 完成订单
     */
    @Override
    @Transactional
    public OrderDTO finish(OrderDTO orderDTO) {
        /**1 判断订单的状态，新下单的时候可以完结*/
        if (!orderDTO.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())) {
            log.error("【完结订单】订单状态不正确, orderId={}, orderStatus={}", orderDTO.getOrderId(), orderDTO.getOrderStatus());
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }
        orderDTO.setOrderStatus(OrderStatusEnum.FINISHED.getCode());
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster);
        /**订单入库，状态改变*/
        OrderMaster updateResult = orderMasterRepository.save(orderMaster);
        if (updateResult == null) {
            log.error("【完结订单】更新失败, orderMaster={}", orderMaster);
            throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);
        }
        return orderDTO;
    }

    /**
     * 6 支付，必须是新的订单，否则抛出异常
     */
    @Override
    @Transactional
    public OrderDTO paid(OrderDTO orderDTO) {
        /** 1 判断订单状态*/
        if (!orderDTO.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())) {
            log.error("【订单支付完成】订单状态不正确, orderId={}, orderStatus={}", orderDTO.getOrderId(), orderDTO.getOrderStatus());
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }

        //判断支付状态
        if (!orderDTO.getPayStatus().equals(PayStatusEnum.WAIT.getCode())) {
            log.error("【订单支付完成】订单支付状态不正确, orderDTO={}", orderDTO);
            throw new SellException(ResultEnum.ORDER_PAY_STATUS_ERROR);
        }

        //修改支付状态
        orderDTO.setPayStatus(PayStatusEnum.SUCCESS.getCode());
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster);
        OrderMaster updateResult = orderMasterRepository.save(orderMaster);
        if (updateResult == null) {
            log.error("【订单支付完成】更新失败, orderMaster={}", orderMaster);
            throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);
        }

        return orderDTO;
    }

    /**
     * 7 卖家端查看订单列表
     */
    @Override
    public Page<OrderDTO> findList(Pageable pageable) {
        Page<OrderMaster> orderMasterPage = orderMasterRepository.findAll(pageable);
        /**得到得到的主表信息，包含很多的订单详情*/
        List<OrderMaster> orderMasterList = orderMasterPage.getContent();
        List<OrderDTO> orderDTOList = OrderMaster2OrderDtoConverter.convert(orderMasterPage.getContent());
        return new PageImpl<>(orderDTOList, pageable, orderMasterPage.getTotalElements());
//        OrderDTO orderDTO   =new OrderDTO();
        /* *//**组装订单的vo*//*
        for (OrderMaster orderMaster : orderMasterList) {
            orderDTO.setOrderId(orderMaster.getOrderId());


        }*/

    }
}
