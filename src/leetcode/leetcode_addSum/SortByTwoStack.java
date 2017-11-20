package leetcode.leetcode_addSum;

import java.util.Stack;

public class SortByTwoStack {


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(7);

        Stack<Integer> result = new Stack<>();
        revertStack(stack);
        System.out.println("-----------");
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }

        sortUseStack(stack, result);
        while (!result.empty()) {
            System.out.println(result.pop());
        }


    }

    /**
     * 利用栈排序栈
     */
    private static void sortUseStack(Stack<Integer> stack, Stack<Integer> result) {

        if (stack.empty()) return;
        int max = getMaxInStack(stack);
        sortUseStack(stack, result);
        result.push(max);
    }

    private static int getMaxInStack(Stack<Integer> stack) {
        int pop = stack.pop();
        if (stack.empty())
            return pop;
        int max = getMaxInStack(stack);
        stack.push(Math.min(pop, max));
        return Math.max(pop, max);
    }

    /**
     * 反转栈
     */
    private static void revertStack(Stack<Integer> stack) {
        if (stack.empty())
            return;
        int bottom = getAndRemoveBottom(stack);
        revertStack(stack);
        stack.push(bottom);


    }

    private static int getAndRemoveBottom(Stack<Integer> stack) {
        int pop = stack.pop();
        if (stack.empty())
            return pop;
        int bottom = getAndRemoveBottom(stack);
        stack.push(pop);
        return bottom;
    }
}


