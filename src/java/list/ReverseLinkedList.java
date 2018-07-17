package list;

/**
 * 206. 反转链表
 * 题目：https://leetcode-cn.com/problems/reverse-linked-list/description/
 *      https://leetcode.com/problems/reverse-linked-list/description/
 * 思路：https://leetcode.com/articles/reverse-linked-list/
 * Created by wy on 2018/7/1.
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode curNode = head;
        ListNode nextNode = head;
        while(curNode != null){
            // 记录下一个节点
            nextNode = curNode.next;
            // 新节点插入dummy后
            curNode.next = dummy.next;
            dummy.next = curNode;
            // 更新当前节点
            curNode = nextNode;
        }
        return dummy.next;
    }
}
