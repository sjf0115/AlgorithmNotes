package list;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by wy on 2018/7/1.
 */
public class LinkedListTest {

    private ListNode root = new ListNode(1);
    @Before
    public void init() {
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        root.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
    }
    @Test
    public void testOddEvenList() {
        OddEvenLinkedList oddEvenLinkedList = new OddEvenLinkedList();
        ListNode head = oddEvenLinkedList.oddEvenList(root);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    @Test
    public void testRemoveNthFromEnd() {
        RemoveNthNodeFromEndList removeNthNodeFromEndList = new RemoveNthNodeFromEndList();
        ListNode head = removeNthNodeFromEndList.removeNthFromEnd2(root, 1);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    @Test
    public void testReverseList (){
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode head = reverseLinkedList.reverseList(root);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}