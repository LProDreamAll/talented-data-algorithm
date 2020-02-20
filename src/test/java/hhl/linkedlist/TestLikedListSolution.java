package hhl.linkedlist;

import linkedlist.LRUBasedArray;
import lombok.extern.slf4j.Slf4j;
import model.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static hhl.util.Utils.doMakeListNode;
import static linkedlist.LikedListSolution.*;
import static model.Util.println;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Copyright (C), 2019-2019
 * FileName: LikedListSolutionTest
 * Author:   s·D·bs
 * Date:     2019-12-24 18:04
 * Description: LikedListSolution 解决问题的测试
 * Motto: 0.45%
 * <author>          <time>          <version>
 * s·D·js         2019-12-24 18:04          0.0.0
 */
@Slf4j
@DisplayName("一个链表测试类")
class TestLikedListSolution {

    private static ListNode listNode;
    private static ListNode listNodeOld;

    @BeforeEach
    @DisplayName("初始化listNode、listNodeOld")
    void creatLinkedList() {
        listNode = doMakeListNode(5);
        println(" listNode : " + listNode);
        listNodeOld = reverseList(doMakeListNode(5));
    }

    @Test
    @DisplayName("测试链表翻转")
    void reverseListTest() {
        ListNode listNode = reverseList(TestLikedListSolution.listNode);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode5.next = listNode4;
        listNode4.next = listNode3;
        listNode3.next = listNode2;
        listNode2.next = listNode1;
        listNode1.next = null;

        println("now listNode: " + listNode + "now1 listNode: " + listNode5);
        assertEquals(listNode, listNode5);

    }

    @Test
    @DisplayName("测试两两交换其中相邻的节点，并返回交换后的链表")
    void test_SwapPairs() {

        ListNode listNode1 = swapPairs(listNode);
        ListNode listNode2 = swapPairs(listNodeOld);
        assertEquals(listNode1.toString(), "ListNode(val=2, next=ListNode(val=1, next=ListNode(val=4, next=ListNode(val=3, next=ListNode(val=5, next=null)))))");
        assertEquals(listNode2.toString(), "ListNode(val=4, next=ListNode(val=5, next=ListNode(val=2, next=ListNode(val=3, next=ListNode(val=1, next=null)))))");
        log.info("new listNode1:{}", listNode1);
        log.info(" new listNode2:{}", listNode2);

    }


    @Test
    @DisplayName("测试给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表")
    void test_reverseKGroup() {
        ListNode reverseKGroupListNode2 = reversekGroup(doMakeListNode(5), 2);
        ListNode reverseKGroupListNode3 = reversekGroup(doMakeListNode(5), 3);
        assertEquals(reverseKGroupListNode2.toString(), "ListNode(val=2, next=ListNode(val=1, next=ListNode(val=4, next=ListNode(val=3, next=ListNode(val=5, next=null)))))");
        assertEquals(reverseKGroupListNode3.toString(), "ListNode(val=3, next=ListNode(val=2, next=ListNode(val=1, next=ListNode(val=4, next=ListNode(val=5, next=null)))))");
        log.info("reverseKGroupListNode2:{}", reverseKGroupListNode2);
        log.info("reverseKGroupListNode3:{}", reverseKGroupListNode3);

    }

    @Test
    @DisplayName("测试数组实现LRU缓存 无参构造")
    void testDefaultConstructor() {
        System.out.println("======无参测试========");
        LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>();
        lru.offer(1);
        lru.offer(2);
        lru.offer(3);
        lru.offer(4);
        lru.offer(5);
        assertEquals("5 4 3 2 1 ",lru.toString());
        lru.offer(6);
        lru.offer(7);
        lru.offer(8);
        lru.offer(9);
        assertEquals("9 8 7 6 5 4 3 2 ",lru.toString());


    }

    @Test
    @DisplayName("测试数组实现LRU缓存 有参构造")
    void testSpecifiedConstructorConstructor() {
        System.out.println("======有参测试========");
        LRUBasedArray<Integer> lru = new LRUBasedArray<>((1 << 2));
        lru.offer(1);
        assertEquals("1 ",lru.toString());
        lru.offer(2);
        assertEquals("2 1 ",lru.toString());
        lru.offer(3);
        assertEquals("3 2 1 ",lru.toString());
        lru.offer(4);
        assertEquals("4 3 2 1 ",lru.toString());
        lru.offer(2);
        assertEquals("2 4 3 1 ",lru.toString());
        lru.offer(4);
        assertEquals("4 2 3 1 ",lru.toString());
        lru.offer(7);
        assertEquals("7 4 2 3 ",lru.toString());
        lru.offer(1);
        assertEquals("1 7 4 2 ",lru.toString());
        lru.offer(2);
        assertEquals("2 1 7 4 ",lru.toString());

    }

}

    
  