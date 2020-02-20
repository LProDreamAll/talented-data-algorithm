package model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Copyright (C), 2019-2020
 * FileName: SNode
 * Author:   s·D·bs
 * Date:     2020/2/20 3:46 下午
 * Description:
 * Motto: 0.45%
 * <author>          <time>          <version>
 * s·D·js         2020/2/20 3:46 下午          0.0.0
 */
@Data
@AllArgsConstructor
public class SNode<T> {
    private T element;

    private SNode next;

    public SNode(T element) {
        this.element = element;
    }
    public SNode() {
        this.next = null;
    }

}

    
  