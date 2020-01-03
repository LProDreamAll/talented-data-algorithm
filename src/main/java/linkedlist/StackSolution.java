package linkedlist;

import java.util.*;

/**
 * Stack
 */
public class StackSolution {

    /**
     * 判断字符串 '[(())]' 是否合理
     * 时间复杂度O(n) 空间复杂度O(n)
     *
     * @param s
     * @return
     */
    public static boolean isVaild(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new LinkedHashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {//不是右括号的时候
                stack.add(c);
            } else if (stack.isEmpty() || !map.get(c).equals(stack.pop())) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断字符串 '[(())]' 是否合理
     * 时间复杂度O(n^2) 空间复杂度O(n)
     *
     * @param s
     * @return
     */
    public boolean isVaild1(String s) {
        int len;
        do {
            len = s.length();
            s = s.replace("()", "").replace("[]", "").replace("{}", "");
        } while (len != s.length());
        return s.length() == 0;
    }
}
