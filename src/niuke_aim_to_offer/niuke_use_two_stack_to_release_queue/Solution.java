package niuke_aim_to_offer.niuke_use_two_stack_to_release_queue;

import java.util.Stack;
/**
 * 用两个栈实现一个队列
 * */
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.push(1);
        solution.push(2);
        solution.push(3);
        solution.push(4);
        solution.push(5);

        while (!solution.stack1.empty()||!solution.stack2.empty()){
            System.out.println(solution.pop());
        }
    }
}