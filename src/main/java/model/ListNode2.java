package model;

import lombok.AllArgsConstructor;
import lombok.Data;



/**
 * Copyright (C), 2019-2019
 * FileName: ListNode
 * Author:   s·D·bs
 * Date:     2019-12-24 17:58
 * Description: 定义节点类
 * Motto: 0.45%
 * <author>          <time>          <version>
 * s·D·js         2019-12-24 17:58          0.0.0
 */
@Data
@AllArgsConstructor
public class ListNode2<K,V> {
    public V val;
    public K key;
    public ListNode2<K,V> next;

    public ListNode2(K key,V val) {
        this.key = key;
        this.val = val;
    }
}


