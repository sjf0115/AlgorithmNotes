package array;

/**
 * 152. 乘积最大子序列
 * https://leetcode-cn.com/problems/maximum-product-subarray/description/
 * Created by wy on 2018/7/3.
 */
public class MaxProductSubArray {
    /**
     * 以当前值结尾的最大值在 当前值 以上一个值结尾的最小值*当前值 以上一个值结尾的最大值*当前值 三个值中产生
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int size = nums.length;
        int max = nums[0];
        int maxPre = nums[0];
        int minPre = nums[0];
        for(int index = 1;index < size;index++){
            int a = maxPre * nums[index];
            int b = minPre * nums[index];
            // 记录以当前值为结尾的最大值
            maxPre = Math.max(Math.max(a, b), nums[index]);
            // 记录以当前值为结尾的最小值
            minPre = Math.min(Math.min(a, b), nums[index]);
            // 更新最大乘积
            max = Math.max(max, maxPre);
        }
        return max;
    }
}
