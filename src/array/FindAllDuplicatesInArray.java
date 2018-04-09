package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 442. 数组中重复的数据
 * https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/description/
 * @author sjf0115
 * @Date Created in 上午9:43 18-4-9
 */
public class FindAllDuplicatesInArray {


    /**
     * 正负号标记法
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }

        for(int i = 0;i < nums.length;i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0){
                result.add(Math.abs(nums[i]));
            }
            nums[index] *= -1;
        }
        return result;

    }

    public static void main(String[] args) {

        FindAllDuplicatesInArray findAllDuplicatesInArray = new FindAllDuplicatesInArray();
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> duplicates = findAllDuplicatesInArray.findDuplicates(nums);
        System.out.println(duplicates);

    }

}
