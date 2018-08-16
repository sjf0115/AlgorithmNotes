package array;

/**
 * 53. 最大子序和
 * https://leetcode-cn.com/problems/maximum-subarray/description/
 * Created by wy on 2018/7/4.
 */
public class MaxAddSubArray {
    public int maxSubArray(int[] nums) {
        int size = nums.length;
        int max = nums[0];
        int curMax = nums[0];
        for(int index = 1;index < size;index++){
            // 一旦当前最大和小于0就重置为0,一个负数只能使最大和变小
            if(curMax < 0){
                curMax = 0;
            }
            curMax += nums[index];
            max = Math.max(max, curMax);
        }
        return max;
    }
}
