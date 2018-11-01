<html>
<#include "../common/header.ftl">

<body>
<div id="wrapper" class="toggled">

<#--边栏sidebar-->
    <#include "../common/nav.ftl">

<#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" method="post" action="/sell/seller/product/save">
                        <div class="form-group">
                            <label>名称</label>
                            <!--处理对象防止为空加括号（）-->
                            <input name="productName" class="form-control" type="text"
                                   value="${(productInfo.productName)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>价格</label>
                            <input name="productPrice" type="text" class="form-control"
                                   value="${(productInfo.productPrice)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>库存</label>
                            <input name="productStock" type="number" class="form-control"
                                   value="${(productInfo.productStock)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>描述</label>
                            <input name="productDescription" type="text" class="form-control"
                                   value="${(productInfo.productDescription)!''}">
                        </div>
                        <div class="form-group">
                            <label>图片</label>
                            <!--设置合适的图片大小-->
                            <img height="100" width="100" src="${(productInfo.productIcon)!''}" alt="">
                            <input name="productIcon" type="text" class="form-control"
                                   value="${(productInfo.productIcon)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>类目</label>
                            <select name="categoryType" class="form-control">
                                <#list categoryList as category>
                                    <!--value 对应数据库的值，name只是显示看看而已，value对应，1，2，3入库-->
                                    <option value="${(category.categoryType)}"
                                            <#if (productInfo.categoryType)?? && productInfo.categoryType==category.categoryType>
                                            <!--这里的判断为了加上seected关键字；
                                            默认选择以前的类目-->
                                                selected
                                            </#if>>
                                    ${category.categoryName}
                                    </option>
                                </#list>

                            </select>
                        </div>
                        <!--隐藏的字段productId不需要显示，但是更新需要知道更新的是哪个-->
                        <input hidden type="text" name="productId" value="${(productInfo.productId)!''}">

                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>