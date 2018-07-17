package array;

/**
 * 215. 数组中的第K个最大元素
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/description/
 * @author sjf0115
 * @Date Created in 下午3:36 18-3-28
 */
public class KthLargestElement {

    /**
     * 分割点
     * @param nums
     * @param start
     * @param end
     * @return
     */
    private int partition(int[] nums, int start, int end){

        if (nums == null || start > end){
            return 0;
        }

        int x = nums[end];
        int i = start - 1;
        int tmp;
        for(int j = start;j < end;j++){
            // 如果哨兵大于当前处理元素进行交换
            if(nums[j] < x){
                i++;
                tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
            }
        }
        // 哨兵归位
        tmp = nums[i+1];
        nums[i+1] = nums[end];
        nums[end] = tmp;
        return i + 1;

    }

    public int findKthLargest(int[] nums, int k) {

        int len = nums.length;
        int start = 0;
        int end = len - 1;
        int index = partition(nums, start, end);
        System.out.println("index:" + index);
        while(k != (index+1)){
            if(k <= index){
                index = partition(nums, start, index - 1);
            }
            else {
                index = partition(nums, index + 1, end);
            }
            System.out.println("index:" + index);
        }
        return nums[index];

    }

    public static void main(String[] args) {
        KthLargestElement kthLargestElement = new KthLargestElement();
        int[] nums = {3, 1, 4, 5};
        int kthLargest = kthLargestElement.findKthLargest(nums, 3);
        System.out.println(kthLargest);
    }

}
