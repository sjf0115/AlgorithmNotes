package array;

/**
 * 35. 搜索插入位置
 * https://leetcode-cn.com/problems/search-insert-position/description/
 * @author sjf0115
 * @Date Created in 下午7:33 18-9-12
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int size = nums.length;
        if(nums == null || size == 0){
            return 0;
        }
        if(target < nums[0]){
            return 0;
        }
        if(target > nums[size-1]){
            return size;
        }
        int left = 0;
        int right = size - 1;
        while(left <= right){
            int mid = left + ((right - left) / 2);
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] > target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 7;
        SearchInsertPosition solution = new SearchInsertPosition();
        int result = solution.searchInsert(nums, target);
        System.out.println(result);
    }
}
