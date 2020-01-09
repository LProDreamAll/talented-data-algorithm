package linkedlist;

import model.ListNode2;



/**
 * @author 刘果
 * @date Created in 9:28 2020/1/9
 */
public class LinkedLRUCacheSolution<K, V> {

    private ListNode2<K, V> head, tail;
    //缓存最大容量
    private int maxSize;

    private int size = 0;

    public int getMaxSize() {
        return maxSize;
    }

    public int getSize() {
        return size;
    }

    public LinkedLRUCacheSolution(int maxSize) {
        this.maxSize = maxSize;
    }

    /**
     * 时间复杂度O(n) 最好 O(1)  最坏O(n) 平均复杂度 O(n)
     *
     * @param key
     */
    public V get(K key) {
        ListNode2<K, V> pre = null;
        ListNode2<K, V> h = head;
        //遍历链表，如果获取到则返回;并将缓存移到表头
        while (h != null) {
            if (!h.getKey().equals(key)) {
                pre = h;
                h = h.next;
            } else {
                if (pre == null) {
                    //第一个节点就找到结果的情况
                    return h.getVal();
                }
                pre.next = h.next;
                //如果移动的节点恰好是尾节点，需要修改tail指向
                if(h == tail){
                    tail = pre;
                }
                h.next = head;
                head = h;
                return h.val;
            }
        }
        //缓存不存在
        return null;

    }

    public void put(K k, V v) {
        //先判断是否已经存在缓存
        V f = get(k);
        ListNode2<K, V> h = head;
        if (f == null) {
            ListNode2<K, V> temp = new ListNode2(k, v);
            if (size == maxSize) {
                while (h.next != tail) {
                    h = h.next;
                }
                tail = h;
                h.next = null;
                temp.next = head;
                head = temp;
            } else {

                temp.next = head;
                head= temp;
                if(tail == null) {
                    tail = temp;
                }

                size++;
            }
        } else {
            while (!h.getKey().equals(k) && h.next != null) {
                h = h.next;
            }
            h.val = v;
        }
    }

}
