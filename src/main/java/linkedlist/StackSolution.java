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
    public boolean isVaild(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new LinkedHashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(c);
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

    /**
     * 判断字符串 '[(())]' 是否合理
     * 时间复杂度O(n) 空间复杂度O(1)
     * 找到中间点，从中间往两边扩散匹配
     *
     * @param s
     * @return
     */
    public boolean isValid2(String s) {
        Map<Character, Character> map = new LinkedHashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        if (Objects.nonNull(s) && s.length() % 2 > 0) {
            return false;
        }
        int middle = s.length() / 2;
        for (int i = middle - 1, j = middle; i >= 0;
             i--, j++) {
            Character close = s.charAt(j);
            Character begin = s.charAt(i);
            if (!close.equals(map.get(begin))) {
                return false;
            }
        }
        return true;
    }
}
