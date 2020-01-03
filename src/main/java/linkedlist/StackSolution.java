package linkedlist;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Stack
 *
 * @Author s·D·bs
 */
public class StackSolution {


    /**
     * @return
     * @Author s·D·bs
     * @Description // 判断字符串 '[(())]' 是否合理
     * 时间复杂度为O(n) 空间复杂度为O(n)
     * @Date 2020年01月03日14:45:41
     * @Param
     */
    public static boolean isVaild(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new LinkedHashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {//是左括号的时候
                stack.add(c);
            } else if (stack.empty() || !map.get(c).equals(stack.pop())) {
                return false;
            }
        }
        return stack.empty();
    }

    /**
     * @return
     * @Author s·D·bs
     * @Description // 判断字符串 '[(())]' 是否合理
     * 时间复杂度O(n^2) 空间复杂度O(n)
     * @Date 2020年01月03日14:45:38
     * @Param
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
