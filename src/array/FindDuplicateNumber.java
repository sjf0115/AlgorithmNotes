package array;

/**
 *　287. 寻找重复数
 * https://leetcode-cn.com/problems/find-the-duplicate-number/description/
 * 二分法，因为数出现在[1，n]。所以统计[1-n/2]的数，如果出现小于等于n/2的数个数超过n/2,[1-n/2]数中有重复的数，继续通过二分减少搜索范围，这里的时间复杂度为nlogn
 * @author sjf0115
 * @Date Created in 上午9:52 18-4-4
 */
public class FindDuplicateNumber {

    public int findDuplicate(int[] nums) {

        if(nums == null || nums.length == 0){
            return -1;
        }
        int len = nums.length;
        int start = 0, end = len - 1;
        // 二分查找
        while(start < end){
            int mid = (start + end) / 2;
            int count = 0;
            for(int i = 0;i < len;i++){
                if(nums[i] <= mid){
                    count++;
                }
            }
            // [mid+1, end]
            if(count <= mid){
                start = mid + 1;
            }
            // [start, mid]
            else {
                end = mid;
            }
        }
        return start;

    }

    public static void main(String[] args) {
        FindDuplicateNumber findDuplicateNumber = new FindDuplicateNumber();
        int[] nums = {1, 2, 2, 3};
        int result = findDuplicateNumber.findDuplicate(nums);
        System.out.println(result);
    }
}




















