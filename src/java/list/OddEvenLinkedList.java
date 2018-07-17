package list;

/**
 * 328. 奇偶链表
 * 题目：https://leetcode-cn.com/problems/odd-even-linked-list/description/
 * 思路：https://leetcode.com/articles/odd-even-linked-list/
 * Created by wy on 2018/7/1.
 */
public class OddEvenLinkedList {
    /**
     * 拆分奇数偶数链表进而合并
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even = evenHead;
        while(even != null && even.next != null){
            // 奇数链表
            odd.next = even.next;
            odd = odd.next;
            // 偶数链表
            even.next = odd.next;
            even = even.next;
        }
        // 合并奇偶链表
        odd.next = evenHead;
        return head;
    }
}
