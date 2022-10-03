package year2022.day0926.leetcode_225;

import java.util.ArrayList;
import java.util.List;

class MyStack {
    private List<Integer> stack;

    public MyStack() {
        stack = new ArrayList<>();
    }

    public void push(int x) {
        stack.add(x);
    }

    public int pop() {
        int num = 1;
        if (stack.size() > 0) {
            num = stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);
        }
        return num;
    }

    public int top() {
        if (stack.size() > 0) {
            return stack.get(stack.size() - 1);
        }
        return -1;
    }

    public boolean empty() {
        return stack.size() == 0;
    }
}

public class leetcode_225_jklee {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }
}
