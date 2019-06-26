import org.junit.Assert;
import org.junit.Test;

/**
 * the class is create by @Author:oweson
 *
 * @Date：2018/10/27 0027 21:10
 */
public class TestAssert {
    /**
     * 规范的断言方法
     */
    @Test
    public void demo1() {
        int a = 1 + 1;
        Assert.assertTrue("a真的大于0吗", a > 0);
        Assert.assertTrue("哈哈哈", a != 0);
    }

    public static void main(String[] args) {

    }
}
