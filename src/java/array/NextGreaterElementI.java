package array;

import java.util.HashMap;
import java.util.Stack;
import java.util.Map;

/**
 * 496. 下一个更大元素 I
 * https://leetcode-cn.com/problems/next-greater-element-i/description/
 * @author sjf0115
 * @Date Created in 下午6:53 18-7-18
 */
public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int size = nums2.length;
        Map<Integer, Integer> num2next = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i < size;i++){
            while(!stack.isEmpty() && nums2[i] > nums2[stack.peek()]){
                num2next.put(nums2[stack.peek()], nums2[i]);
                stack.pop();
            }
            stack.push(i);
        }

        int size1 = nums1.length;
        int[] num1Next = new int[size1];
        for(int i = 0;i < nums1.length;i++){
            num1Next[i] = num2next.getOrDefault(nums1[i], -1);
        }
        return num1Next;
    }
}
