package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/description/
 * Created by wy on 2018/7/1.
 */
public class BinaryTreeInorderTraversal {
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper2(root, result);
        return result;
    }

    /**
     * 递归
     * @param node
     * @param result
     */
    private void helper(TreeNode node, List<Integer> result){
        if(node == null){
            return;
        }
        if(node.left != null){
            helper(node.left, result);
        }
        result.add(node.val);
        if(node.right != null){
            helper(node.right, result);
        }
    }

    /**
     * 非递归
     * @param root
     * @param result
     */
    private void helper2(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        // 第一次遍历时stack为空
        while(!stack.isEmpty() || node!= null){
            // 遍历左子树
            if(node != null){
                stack.add(node);
                node = node.left;
            }
            // 遍历右子树
            else {
                TreeNode treeNode = stack.pop();
                result.add(treeNode.val);
                node = treeNode.right;
            }
        }
    }
}
