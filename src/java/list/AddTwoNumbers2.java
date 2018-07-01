package list;

import java.util.Stack;

/**
 * 445. 两数相加 II
 * https://leetcode-cn.com/problems/add-two-numbers-ii/description/
 * Created by wy on 2018/7/1.
 */
public class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> result = new Stack<>();
        ListNode curNode1 = l1;
        ListNode curNode2 = l2;
        while(curNode1 != null){
            s1.add(curNode1.val);
            curNode1 = curNode1.next;
        }
        while(curNode2 != null){
            s2.add(curNode2.val);
            curNode2 = curNode2.next;
        }
        int c = 0;
        while(!s1.isEmpty() || !s2.isEmpty() || c!= 0){
            int num1 = !s1.isEmpty() ? s1.pop() : 0;
            int num2 = !s2.isEmpty() ? s2.pop() : 0;
            int sum = num1 + num2 + c;
            c = sum / 10;
            result.add(sum % 10);
        }
        ListNode dummy = new ListNode(0);
        ListNode curNode = dummy;
        while (!result.isEmpty()){
            ListNode node = new ListNode(result.pop());
            curNode.next = node;
            curNode = node;
        }
        return dummy.next;
    }
}
