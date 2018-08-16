package list;

import java.util.HashMap;

/**
 * @author sjf0115
 * @Date Created in 上午10:27 18-8-16
 */
public class LRUCache {

    // 双向链表
    class ListNode {
        int key;
        int value;
        ListNode next;
        ListNode pre;
        public ListNode (int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private HashMap<Integer, ListNode> map = new HashMap<>();
    private ListNode head;
    private ListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    /**
     * 取值
     * @param key
     * @return
     */
    public int get(int key) {
        if (map.containsKey(key)){
            ListNode node = map.get(key);
            remove(node);
            setHead(node);
            return node.value;
        }
        else {
            return -1;
        }
    }

    /**
     * 写值
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        if(map.containsKey(key)){
            // 删除后放入第一个位置
            ListNode node = map.get(key);
            node.value = value;
            remove(node);
            setHead(node);
        }
        else {
            // 直接放入第一个位置
            ListNode node = new ListNode(key, value);
            // 不足以放入新数据 删除尾节点 新数据插入头节点
            if(map.size() >= capacity){
                map.remove(tail.value);
                remove(tail);
                setHead(node);
            }
            else {
                setHead(node);
            }
            map.put(key, node);
        }
    }

    /**
     * 在头部插入节点
     * @param node
     */
    private void setHead (ListNode node){
        node.next = head;
        node.pre = null;

        if(head != null){
            head.pre = node;
        }
        head = node;

        if(tail == null){
            tail = node;
        }
    }

    /**
     * 删除节点
     * @param node
     */
    private void remove(ListNode node){
        // 有三种情况 (1) node 为头结点 (2) node 为尾节点 (3) node 为中间节点
        if(node.pre != null){
            node.pre.next = node.next;
        }
        else {
            head = node.next;
        }

        if(node.next != null){
            node.next.pre = node.pre;
        }
        else {
            tail = node.pre;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);                        // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);                        // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));       // 返回  4
    }
}
