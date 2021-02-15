package linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), 2019-2020
 * FileName: LRUBasedArray
 * Author:   s·D·bs
 * Date:     2020/2/19 6:18 下午
 * 缓存满了清除策略：1：先进先出FIFO 2:最少使用策略LFU 3：最近最少使用策略LRU
 * 1:存值 容器中没有：满了没有->移除尾部，再添加，没有满
 * Description: 数组实现LRU缓存
 * 1. 空间复杂度为O(n)
 * 2. 时间复杂度为O(n)
 * 3. 不支持null的缓存
 * Motto: 0.45%
 * https://mubu.com/doc73jCBcpQQ9k
 * <author>          <time>          <version>
 * s·D·js         2020/2/19 6:18 下午          0.0.0
 */

public class LRUBasedArray<T> {

    private static final int DEFAULT_CAPACITY = (1 << 3);

    private int capacity;

    private int count;

    private T[] value;

    private Map<T, Integer> holder;

    public LRUBasedArray() {
        this(DEFAULT_CAPACITY);
    }

    public LRUBasedArray(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.value = (T[]) new Object[capacity];
        this.holder = new HashMap<>(capacity);
    }

    //存数据
    public void offer(T obj) {
        Integer key = holder.get(obj);
        if (key == null) {
            if (isFull()) {
                removeAndCache(obj);
            } else {
                //和update的区别在于 count++
                cache(  obj, count);
            }
        } else {
            update(obj, key);
        }
    }

    //存在
    private void update(T obj, int key) {
        allRight(key);
        value[0] = obj;
        holder.put(obj, 0);
    }

    //不存在+1 直接存无需移动
    private void cache(T obj, Integer end) {
        update(obj, end);
        count++;
    }

    private void allRight(Integer end) {
        for (int i = end - 1; i >= 0; i--) {
            value[i + 1] = value[i];
            holder.put(value[i], i + 1);
        }
    }

    private void removeAndCache(T obj) {
        T t = value[--count];
        holder.remove(t);
        cache(obj, count);
    }

    private boolean isFull() {
        return capacity == count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(value[i]);
            sb.append(" ");
        }
        return sb.toString();
    }
}

    
  