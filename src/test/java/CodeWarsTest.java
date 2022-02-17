import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class CodeWarsTest {
    @Test
    public void test1() {
        long[] r = new long[] {55, 89, 1};
        assertArrayEquals(r, Main.productFib(4895));
    }
    @Test
    public void test2() {
        long[] r = new long[] {89, 144, 0};
        assertArrayEquals(r, Main.productFib(5895));
    }
}
