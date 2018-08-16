package tree;

import org.junit.Test;

import java.util.List;

/**
 * Created by wy on 2018/7/1.
 */
public class BinaryTreeTest {

    private TreeNode root = new TreeNode(1);

    @org.junit.Before
    public void init() {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
    }

    @Test
    public void testInorderTraversal() throws Exception {
        BinaryTreeInorderTraversal inorderTraversal = new BinaryTreeInorderTraversal();
        List<Integer> result = inorderTraversal.inorderTraversal(root);
        System.out.println(result);
    }

    @Test
    public void testSumOfLeftLeaves() {
        SumLeftLeaves solution = new SumLeftLeaves();
        int result = solution.sumOfLeftLeaves(root);
        System.out.println(result);
    }

    @Test
    public void testBinaryTreeLevelOrderTraversal(){
        BinaryTreeLevelOrderTraversal solution = new BinaryTreeLevelOrderTraversal();
        List<List<Integer>> result = solution.levelOrder(root);
        System.out.println(result);
    }
}