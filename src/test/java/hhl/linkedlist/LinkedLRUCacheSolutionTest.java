package hhl.linkedlist;

import linkedlist.LinkedLRUCacheSolution;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;



/**
 * @author 刘果
 * @date Created in 10:27 2020/1/9
 */
public class LinkedLRUCacheSolutionTest {

    @Test
    public void putAndGet() {
        LinkedLRUCacheSolution<String, String> cacheSolution = new LinkedLRUCacheSolution<>(10);
        cacheSolution.put("key1", "val1");
        cacheSolution.put("key2", "val2");
        cacheSolution.put("key3", "val3");
        cacheSolution.put("key4", "val4");
        cacheSolution.put("key5", "val5");
        cacheSolution.put("key6", "val6");
        cacheSolution.put("key7", "val7");
        cacheSolution.put("key8", "val8");
        cacheSolution.put("key9", "val9");
        cacheSolution.put("key10", "val10");

        Assert.assertEquals(cacheSolution.getSize(), 10);
        Assert.assertEquals("val1",cacheSolution.get("key1"));

        cacheSolution.put("key11","val11");

        Assert.assertNull(cacheSolution.get("key2"));
        cacheSolution.put("key12","val12");
        Assert.assertNull(cacheSolution.get("key3"));

        Assert.assertEquals("val4",cacheSolution.get("key4"));
        cacheSolution.put("key13","val13");

        Assert.assertNull(cacheSolution.get("key5"));


    }
}
