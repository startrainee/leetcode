package niuke.niuke_find_min_of_array;

import java.util.Stack;
/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，
 * 我们称之为数组的旋转。 输入一个非递减排序的
 * 数组的一个旋转，输出旋转数组的最小元素。 例
 * 如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，
 * 该数组的最小值为1。 NOTE：给出的所有元素都
 * 大于0，若数组大小为0，请返回0。
 * */
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
