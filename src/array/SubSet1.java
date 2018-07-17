package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * https://leetcode-cn.com/problems/subsets/description/
 * @author sjf0115
 * @Date Created in 下午12:37 18-6-28
 */
public class SubSet1 {
    private List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<List<Integer>>();
        List<Integer> subSet = new ArrayList<>();
        DFS(subSet, 0, nums);
        return result;
    }

    private void DFS(List<Integer> subSet, int start, int[] nums){
        int size = nums.length;
        if(start > size) {
            List<Integer> tmpSubSet = new ArrayList<>(subSet);
            System.out.println(tmpSubSet.toString());
            result.add(tmpSubSet);
            return;
        }
        for(int index = start; index < size; index++){
            subSet.add(nums[index]);
            DFS(subSet, start + 1, nums);
            subSet.remove(subSet.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        SubSet1 subSet1 = new SubSet1();
        List<List<Integer>> result = subSet1.subsets(nums);
        for(List<Integer> subSet : result){
            System.out.println("result: " + subSet.toString());
        }
    }

    // https://www.programcreek.com/2013/01/leetcode-subsets-java/
}
