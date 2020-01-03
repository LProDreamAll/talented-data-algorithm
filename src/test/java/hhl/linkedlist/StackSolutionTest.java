package hhl.linkedlist;

import linkedlist.StackSolution;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Stack
 */
public class StackSolutionTest {

    @Test
    public void test_isVaild() {
        String s = "[(())]";
        assertTrue(StackSolution.isVaild(s));
        s += "}";
        assertFalse(StackSolution.isVaild(s));
    }

}
