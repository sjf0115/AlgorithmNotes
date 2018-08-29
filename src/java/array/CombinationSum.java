package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. Combination Sum
 * https://leetcode.com/problems/combination-sum/description/
 * @author sjf0115
 * @Date Created in 下午1:00 18-8-29
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        helper(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> tmpList, int[] nums, int remain, int start){
        if(remain < 0){
            return;
        }
        if(remain == 0){
            result.add(new ArrayList<>(tmpList));
            return;
        }
        for(int i = start; i < nums.length; i++){
            tmpList.add(nums[i]);
            // not i + 1 because we can reuse same elements
            helper(result, tmpList, nums, remain - nums[i], i);
            tmpList.remove(tmpList.size() - 1);
        }
    }

    public static void main(String[] args) {

    }












}
