package array;

import org.junit.Test;

/**
 * Created by wy on 2018/7/3.
 */
public class ArrayTest {

    @Test
    public void testMaxProduct() {
        //int[] nums = {2,3,-2,4};
        int[] nums = {-2,0,-1};
        MaxProductSubArray solution = new MaxProductSubArray();
        int result = solution.maxProduct(nums);
        System.out.println(result);
    }

    @Test
    public void testMaxAddSubArray() {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        MaxAddSubArray solution = new MaxAddSubArray();
        int result = solution.maxSubArray(nums);
        System.out.println(result);
    }

    @Test
    public void testSqrt() {
        Sqrt solution = new Sqrt();
        int result = solution.mySqrt(4);
        System.out.println(result);
    }
}