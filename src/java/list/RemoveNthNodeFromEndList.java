package list;

/**
 * 19. 删除链表的倒数第N个节点
 * 题目：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/description/
 * 思路：https://leetcode.com/articles/remove-nth-node-from-end-of-list/
 * Created by wy on 2018/7/1.
 */
public class RemoveNthNodeFromEndList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // second前行n步
        int index = 0;
        while(index <= n){
            second = second.next;
            index++;
        }
        // first second一起前行 second移至末尾
        while(second != null){
            first = first.next;
            second = second.next;
        }
        // 删除first.next
        first.next = first.next.next;
        return dummy.next;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 计算链表长度
        ListNode node = head;
        int size = 0;
        while(node != null){
            size++;
            node = node.next;
        }
        // 删除第size-n+1个元素
        node = dummy;
        int index = 0;
        while (index < size-n){
            node = node.next;
            index++;
        }
        // 删除node.next
        node.next = node.next.next;
        return dummy.next;
    }
}
