package array;

/**
 * 300. 最长上升子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/description/
 * Created by wy on 2018/7/10.
 */
public class LongestIncreasingSubSequence {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        int[] dp = new int[len];
        dp[0] = 1;
        for(int i = 0;i < len;i++){
            // 以nums[i]为终点的最长上升子序列
            int curMax = 1;
            for(int j = 0;j < i;j++){
                if(nums[i] > nums[j]){
                    curMax = Math.max(curMax, dp[j] + 1);
                }
            }
            dp[i] = curMax;
        }
        // 最长上升子序列
        int max = 0;
        for(int i = 0;i < len;i++){
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 思路二： 我们先建立一个数组 ends，把首元素放进去，然后比较之后的元素，
     如果遍历到的新元素比ends数组中的首元素小的话，替换首元素为此新元素，
     如果遍历到的新元素比ends数组中的末尾元素还大的话，将此新元素添加到ends数组末尾(注意不覆盖原末尾元素)。
     如果遍历到的新元素比ends数组首元素大，比尾元素小时，此时用二分查找法找到第一个不小于此新元素的位置，覆盖掉位置的原来的数字，
     */
}
