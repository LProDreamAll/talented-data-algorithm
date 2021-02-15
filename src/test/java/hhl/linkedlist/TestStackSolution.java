package hhl.linkedlist;

import linkedlist.StackSolution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



/**
 * Stack
 */
@DisplayName("一个栈、队列测试类")
class TestStackSolution {


    @Test
    @DisplayName("改用显式的方式判断字符串 '[(())]' 是否合理")
    void test_isVaild() {
        String[] strings ={"[(())]","[(())]}"};
        Assertions.assertAll("strings",
                () -> Assertions.assertTrue(StackSolution.isVaild(strings[0])),
                () -> Assertions.assertFalse(StackSolution.isVaild(strings[1]))
        );
    }

}
