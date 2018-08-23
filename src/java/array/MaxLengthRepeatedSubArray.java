package array;

/**
 * 718. 最长重复子数组
 * 题目：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/submissions/1
 * 思路：https://leetcode.com/articles/maximum-length-of-repeated-subarray/
 * Created by wy on 2018/7/5.
 */
public class MaxLengthRepeatedSubArray {
    public int findLength(int[] A, int[] B) {
        int max = 0;
        int[][] dp = new int[A.length + 1][B.length + 1];
        for (int i = A.length - 1; i >= 0; --i) {
            for (int j = B.length - 1; j >= 0; --j) {
                if (A[i] == B[j]) {
                    dp[i][j] = dp[i+1][j+1] + 1;
                    if (max < dp[i][j]) {
                        max = dp[i][j];
                    }
                }
            }
        }
        return max;
    }
}
