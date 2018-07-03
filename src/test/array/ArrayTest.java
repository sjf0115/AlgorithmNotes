package array;

import org.junit.Test;

/**
 * Created by wy on 2018/7/3.
 */
public class ArrayTest {

    @Test
    public void testMaxProduct() throws Exception {
        //int[] nums = {2,3,-2,4};
        int[] nums = {-2,0,-1};
        MaxProductSubArray solution = new MaxProductSubArray();
        int result = solution.maxProduct(nums);
        System.out.println(result);
    }
}