package list;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wy on 2018/7/1.
 */
public class LinkedListTest {

    private ListNode root;
    private ListNode l1;
    private ListNode l2;
    @Before
    public void init() {
        root = createList(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        l1 = createList(new ArrayList<Integer>(Arrays.asList(5)));
        l2 = createList(new ArrayList<Integer>(Arrays.asList(5)));
    }

    private ListNode createList(List<Integer> list){
        ListNode dummy = new ListNode(0);
        ListNode curNode = dummy;
        for(Integer num : list){
            ListNode node = new ListNode(num);
            curNode.next = node;
            curNode = node;
        }
        return dummy.next;
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
    public void testReverseList() {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode head = reverseLinkedList.reverseList(root);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    @Test
    public void testAddTwoNumbers() {
        AddTwoNumbers2 solution = new AddTwoNumbers2();
        ListNode head = solution.addTwoNumbers(l1, l2);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}