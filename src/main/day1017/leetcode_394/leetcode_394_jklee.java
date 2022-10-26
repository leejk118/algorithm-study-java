package main.day1017.leetcode_394;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class leetcode_394_jklee {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        List<String> list;
        StringBuilder sb, numStr;

        for (char ch : s.toCharArray()) {
            if (ch == ']') {
                list = new ArrayList<>();
                sb = new StringBuilder();
                numStr = new StringBuilder();
                while (!stack.empty()) {
                    String str = stack.pop();
                    if (str.equals("[")) break;
                    list.add(str);
                }
                Collections.reverse(list);
                for (String str : list) {
                    sb.append(str);
                }
                while (!stack.empty()) {
                    String str = stack.peek();
                    if (str.charAt(0) >= '0' && str.charAt(0) <= '9') {
                        numStr.append(str);
                        stack.pop();
                    } else {
                        break;
                    }
                }
                int number = Integer.parseInt(numStr.reverse().toString());
                String targetStr = sb.toString();
                for (int i = 1; i < number; ++i) {
                    sb.append(targetStr);
                }
                stack.push(sb.toString());

            } else {
                stack.push("" + ch);
            }
        }
        sb = new StringBuilder();
        list = new ArrayList<>();
        while (!stack.empty()) {
            list.add(stack.pop());
        }
        Collections.reverse(list);
        for (String str : list) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] testcase = {"3[a]2[bc]", "3[a2[c]]", "2[abc]3[cd]ef", "100[leetcode]"};
        for (String tc : testcase) {
            System.out.println(new leetcode_394_jklee().decodeString(tc));
        }
    }
}
