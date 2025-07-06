package practice;

import java.util.Stack;

public class P19ValidParentheses {
    /*
    No.20 valid-parentheses
    ([]) 为true  (] 为false
    字符串中只包括 ()[]{}
    显然用栈就能ac
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char leftChar = stack.pop();
                if ((leftChar == '(' && c == ')') || (leftChar == '[' && c == ']') || (leftChar == '{' && c == '}')) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "([])";
        boolean res = new P19ValidParentheses().isValid(s);
        System.out.println(res);
    }
}
