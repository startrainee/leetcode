package niuke.niuke_find_min_of_array;

import java.util.Stack;

public class Solution {
    public static int minNumberInRotateArray(int [] array) {
        if(array.length <= 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for(int i = array.length -1;i>= 0;i--){
            if(stack.empty()){
                stack.push(array[i]);
                continue;
            }
            if (array[i]<stack.peek()){
                stack.push(array[i]);
            }else {
                return stack.peek();
            }
        }
        return stack.peek();
    }
    public static int minNumberInRotateArray2(int [] array) {
        if(array.length <= 0){
            return 0;
        }
        int min = array[0];
        for (int i : array){
            min = Math.min(min,i);
        }
        return min;
    }

    public static void main(String[] args) {
        int[] array = new int[]{12,123,223,322,644,7,8,9};
        System.out.println(Solution.minNumberInRotateArray(array));
    }
}
