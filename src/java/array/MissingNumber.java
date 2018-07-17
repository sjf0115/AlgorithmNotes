package array;

/**
 * 268. 缺失数字
 * 思路：任何一个数字异或他自己都等于0
 * https://leetcode-cn.com/problems/missing-number/description/
 * @author sjf0115
 * @Date Created in 上午9:50 18-4-8
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int miss = n;
        for(int i = 0;i < n;i++){
            miss ^= nums[i] ^ i;
        }
        return miss;
    }

    public static void main(String[] args) {

        MissingNumber missingNumber = new MissingNumber();
        int[] nums = {9,6,4,2,3,5,7,0,1};
        int result = missingNumber.missingNumber(nums);
        System.out.println(result);

    }

}
