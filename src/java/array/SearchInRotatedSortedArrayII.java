package array;

/**
 * 81. 搜索旋转排序数组 II
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/description/
 * @author sjf0115
 * @Date Created in 上午10:28 18-8-30
 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int size = nums.length;
        int begin = 0, end = size - 1;
        while (begin <= end){
            int mid = (begin + end) / 2;
            // 找到目标
            if (nums[mid] == target){
                return true;
            }
            // 中间元素等于首元素
            if(nums[mid] == nums[begin]){
                begin ++;
            }
            // 中间元素大于首元素 [begin, mid] 有序 [mid, end] 无序
            else if (nums[mid] > nums[begin]){
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
        return false;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArrayII solution = new SearchInRotatedSortedArrayII();
        int[] nums = {2,5,6,0,0,1,2};
        boolean search = solution.search(nums, 3);
        System.out.println(search);
    }
}
