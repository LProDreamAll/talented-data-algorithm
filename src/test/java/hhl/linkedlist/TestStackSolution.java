package hhl.linkedlist;

import linkedlist.StackSolution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Stack
 */
@DisplayName("一个栈、队列测试类")
class TestStackSolution {


    @Test
    @DisplayName("判断字符串 '[(())]' 是否合理")
    void test_isVaild() {
        String s = "[(())]";
        assertTrue(StackSolution.isVaild(s));
        s += "}";
        assertFalse(StackSolution.isVaild(s));
    }

}
