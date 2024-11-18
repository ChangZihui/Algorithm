package No_1_200.No71简化路径;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        String path = "/home//foo/";
        System.out.println(simplifyPath(path));
    }

    public static String simplifyPath(String path) {
        String[] split = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String s : split) {
            if ("".equals(s)) {
                continue;
            } else if (".".equals(s)) {
                continue;
            } else if ("..".equals(s)) {
                if (stack.isEmpty()) {
                    continue;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
        }
        String res = "";
        while (!stack.isEmpty() && stack.peek() != null) {
            if ("".equals(res)) res = stack.pop();
            else res = stack.pop() + "/" + res;
        }
        res = "/" + res;
        return res;
    }
}
