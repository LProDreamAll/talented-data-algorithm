package linkedlist;

import model.SNode;

/**
 * Copyright (C), 2019-2020
 * FileName: LRUBaseLinkedList
 * Author:   s·D·bs
 * Date:     2020/2/19 6:18 下午
 * Description: 链表实现
 * Motto: 0.45%
 * <author>          <time>          <version>
 * s·D·js         2020/2/19 6:18 下午          0.0.0
 */

public class LRUBaseLinkedList<T> {

    /**
     * 默认链表容量
     */
    private final static Integer DEFAULT_CAPACITY = 10;

    /**
     * 头结点
     */
    private SNode<T> headNode;

    /**
     * 链表长度
     */
    private Integer length;

    /**
     * 链表容量
     */
    private Integer capacity;

    public LRUBaseLinkedList(Integer capacity) {
        this.headNode = new SNode<>();
        this.length = 0;
        this.capacity = capacity;
    }

    public LRUBaseLinkedList() {
        this.headNode = new SNode<>();
        this.length = 0;
        this.capacity = DEFAULT_CAPACITY;
    }

    public void add(T data) {
        SNode preNode = findPreNode(data);
        if (preNode == null) {
            if (length >= capacity) {
                deleteEnd();
            }
            insertHeadData(data);
        } else {
            deleteTemp(preNode);
            insertHeadData(data);
        }
    }

    //删除当前节点
    private void deleteTemp(SNode preNode) {
        SNode next = preNode.getNext().getNext();
        preNode.setNext(next);
        length--;
    }

    private void insertHeadData(T data) {
        SNode next = headNode.getNext();
        headNode.setNext(new SNode(data, next));
        length++;
    }

    //删除尾结点
    private void deleteEnd() {
        if (headNode.getNext() == null) {
            return;
        }
        //找到倒数第二节点直接赋值
        SNode<T> node = this.headNode;
        while (node.getNext().getNext() != null) {
            node = node.getNext();
        }
        node.setNext(null);
        length--;
    }

    //发现前一个节点
    private SNode findPreNode(T data) {
        SNode<T> node = this.headNode;
        while (node.getNext() != null) {
            if (node.getNext().getElement().equals(data)) {
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        SNode<T> node = this.headNode;
        while (node.getNext() != null) {
            sb.append(node.getNext().getElement());
            sb.append(" ");
            node = node.getNext();
        }
        return sb.toString();
    }

}

    
  