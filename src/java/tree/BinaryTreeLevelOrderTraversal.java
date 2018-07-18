package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层次遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/description/
 * Created by wy on 2018/7/18.
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        // 当前层节点个数
        int curCount = 1;
        // 下一层节点个数
        int nextCount = 0;
        List<Integer> levelList = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            levelList.add(node.val);
            curCount --;
            if(node.left != null){
                queue.add(node.left);
                nextCount ++;
            }
            if(node.right != null){
                queue.add(node.right);
                nextCount ++;
            }
            // 当前层遍历完毕
            if(curCount == 0){
                curCount = nextCount;
                nextCount = 0;
                List<Integer> tmpList = new ArrayList<>(levelList);
                result.add(tmpList);
                levelList.clear();
            }
        }
        return result;
    }
}
