package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. 子集 II
 * https://leetcode-cn.com/problems/subsets-ii/description/
 * @author sjf0115
 * @Date Created in 下午12:21 18-8-29
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        helper(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> tmpList, int[] nums, int index){
        result.add(new ArrayList<>(tmpList));
        for(int i = index; i < nums.length;i++){
            // 跳过重复
            if(i > index && nums[i] == nums[i-1]){
                continue;
            }
            tmpList.add(nums[i]);
            helper(result, tmpList, nums, i + 1);
            tmpList.remove(tmpList.size() - 1);
        }
    }

    public static void main(String[] args) {
        SubsetsII solution = new SubsetsII();
        int[] nums = {1, 2, 2};
        List<List<Integer>> result = solution.subsetsWithDup(nums);
        System.out.println(result);
    }
}
