package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * https://leetcode-cn.com/problems/permutations/description/
 * @author sjf0115
 * @Date Created in 下午1:07 18-4-3
 */
public class Permutations {

    private List<List<Integer>> result;

    /**
     * 全排列
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {

        result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }
        List<Integer> tmpList = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        DFS(nums, visited, tmpList);
        return result;
    }

    /**
     * 深度搜索  每一轮搜索选择一个数加入列表中，同时我们还要维护一个全局的布尔数组，来标记哪些元素已经被加入列表了，这样在下一轮搜索中要跳过这些元素。
     * @param nums
     * @param visited
     * @param tmpList
     */
    private void DFS(int[] nums, boolean[] visited, List<Integer> tmpList){

        if(nums.length == tmpList.size()){
            result.add(new ArrayList<>(tmpList));
            return;
        }
        for(int i = 0;i < nums.length;i++){
            if(!visited[i]){
                visited[i] = true;
                tmpList.add(nums[i]);
                DFS(nums, visited, tmpList);
                visited[i] = false;
                tmpList.remove(tmpList.size() - 1);
            }
        }

    }

    public static void main(String[] args) {

        Permutations permutations = new Permutations();
        int[] nums = {2, 1};
        List<List<Integer>> result = permutations.permute(nums);
        for(List<Integer> item : result){
            System.out.println(item.toString());
        }

    }
}
