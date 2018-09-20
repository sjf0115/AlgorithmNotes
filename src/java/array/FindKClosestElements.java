package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 658. 找到 K 个最接近的元素
 * https://leetcode-cn.com/problems/find-k-closest-elements/description/
 * https://leetcode.com/articles/find-k-closest-elements/
 * @author sjf0115
 * @Date Created in 上午10:18 18-9-20
 */
public class FindKClosestElements {

    /**
     * 二分查找 如果数组中存在target则返回所在下标，否则返回插入位置下标
     * @param array
     * @param target
     * @return
     */
    private int binarySearch(int[] array, int target) {
        int size = array.length;
        if(array == null || size == 0){
            return 0;
        }
        if(target < array[0]){
            return 0;
        }
        if(target > array[size-1]){
            return size;
        }
        int left = 0;
        int right = size - 1;
        while(left <= right){
            int mid = left + ((right - left) / 2);
            if(array[mid] == target){
                return mid;
            }
            else if(array[mid] > target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int size = arr.length;
        if (x <= arr[0]) {
            for(int i = 0;i < k;i++){
                result.add(arr[i]);
            }
            return result;
        }
        if (x >= arr[size-1]) {
            for(int i = size - k;i < size;i++){
                result.add(arr[i]);
            }
            return result;
        }
        // 二分查找 插入位置
        int index = binarySearch(arr, x);
        System.out.println("index:" + index);
        // 最接近的K个元素
        int left = Math.max(0, index - k);
        int right = Math.min(arr.length - 1, index + k);
        while((right - left + 1 > k) && right >= left){
            if(x - arr[left] <= arr[right] - x){
                right --;
            }
            else if(x - arr[left] > arr[right] - x){
                left ++;
            }
        }
        for(int i = left;i <= right;i++){
            result.add(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {0,0,1,2,3,3,4,7,7,8};
        FindKClosestElements solution = new FindKClosestElements();
        List<Integer> result = solution.findClosestElements(array, 3, 5);
        System.out.println(result.toString());
    }
}
