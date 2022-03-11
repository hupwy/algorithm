package org.domi.linear;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author: <a href="mailto:hupeng@neuedu.com">hupeng</a>
 * @Date: 2022-03-11 13:02
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 *  示例 1：
 * * 输入：s = "()"
 * 输出：true
 *
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 *
 * 思路：用堆栈计算
 * 1，如果是左括号将左括号入栈。
 * 2，如果是右括号则匹配栈顶元素，不能匹配左括号返回fasle。
 * 3，判断堆栈是否为空，为空则true，否则false
 */
public class ValidParentheses {

    private static boolean isValid(String s) {

        Map<Character, Character> hash_map = new HashMap<>();
        hash_map.put(')', '(');
        hash_map.put(']', '[');
        hash_map.put('}', '{');

        Stack<Character> stack = new Stack();
        for (char c : s.toCharArray()) {
            if (hash_map.get(c) == null) {
                stack.push(c);
            } else if (stack.empty() || !hash_map.get(c).equals(stack.pop())) {
                return false;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("{{()}}"));
    }
}
