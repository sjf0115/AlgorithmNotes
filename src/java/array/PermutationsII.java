package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. 全排列 II
 * https://leetcode-cn.com/problems/permutations-ii/description/
 * @author sjf0115
 * @Date Created in 上午9:43 18-8-28
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        helper(result, new ArrayList<>(), nums, new boolean[nums.length+1]);
        return result;
    }

    /**
     * 假设原数组为 1' 1 2 会出现四种情况：
     * (1) 1' 1 2 (2) 1 1 2 (3) 1' 1' 2 (4) 1 1' 2
     * @param result
     * @param tmpList
     * @param nums
     * @param used
     */
    private void helper(List<List<Integer>> result, List<Integer> tmpList, int[] nums, boolean[] used){
        int size = nums.length;
        if(tmpList.size() == size){
            result.add(new ArrayList<>(tmpList));
            return;
        }
        for(int i = 0;i < size;i++){
            // 跳过重复使用的　重复元素保持原数组中的相对顺序
            if(used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i-1])){
                continue;
            }
            used[i] = true;
            tmpList.add(nums[i]);
            helper(result, tmpList, nums, used);
            used[i] = false;
            tmpList.remove(tmpList.size() - 1);
        }
    }

    public static void main(String[] args) {
        PermutationsII permutations = new PermutationsII();
        int[] nums = {1, 1, 3};
        List<List<Integer>> result = permutations.permuteUnique(nums);
        for(List<Integer> item : result){
            System.out.println(item.toString());
        }
    }
}
