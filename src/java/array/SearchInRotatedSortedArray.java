package array;

/**
 * 33. 搜索旋转排序数组
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/description/
 * @author sjf0115
 * @Date Created in 上午9:42 18-8-30
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int size = nums.length;
        int begin = 0, end = size - 1;
        while (begin <= end){
            int mid = (begin + end) / 2;
            // 找到目标
            if (nums[mid] == target){
                return mid;
            }
            // 中间元素大于等于首元素 [begin, mid] 有序 [mid, end] 无序
            if (nums[mid] >= nums[begin]){
                // 在[begin, mid-1]区间
                if (target < nums[mid] && target >= nums[begin]){
                    end = mid - 1;
                }
                // 在[mid+1, end]区间
                else {
                    begin = mid + 1;
                }
            }
            // 中间元素小于首元素 [begin, mid] 无序 [mid, end] 有序
            else {
                // 在[mid+1, end]区间
                if (target > nums[mid] && target <= nums[end]){
                    begin = mid + 1;
                }
                // 在[begin, mid-1]区间
                else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray();
        int[] nums = {4,5,6,7,0,1,2};
        int result = solution.search(nums, 0);
        System.out.println(result);
    }
}
