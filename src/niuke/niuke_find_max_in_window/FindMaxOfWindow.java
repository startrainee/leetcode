package niuke.niuke_find_max_in_window;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * [1,2,3,4,5,6,7]
 *
 * 窗口大小为3，[,,,]
 *  窗口在数组上从左往右移动一次一个格子
 *  求每次移动窗口中的最小值，保存并依次输出
 * */
public class FindMaxOfWindow {


    /**
     * 复杂度O(N*w)
     * */
    public static int[] FindMaxOfWindow(int[] array ,int windowSize){
            int[] result = new int[array.length - windowSize + 1];
            int leftOfWindow = 0;
            int rightOfWindow = windowSize - 1;
        for( int index = 0;index < result.length;index++){

            int maxOfFirst = findMaxIndexOfWindow(array,leftOfWindow,rightOfWindow);
            result[index] = maxOfFirst;
            leftOfWindow++;
            rightOfWindow++;
            }
            return result;

    }

    public static void main(String[] args) {
        //int[] array = new int[]{4,3,5,4,3,3,6,7};
        int[] array = new int[]{10,9,8,7,6,5,4,3};
        int windowSize = 3;
        System.out.println(Arrays.toString(FindMaxOfWindow(array,windowSize)));
        System.out.println(Arrays.toString(FindMaxOfWindow2(array,windowSize)));
    }

    /**
     * 复杂度O(N*w) 数组长度为N，窗口长度为w
     * */
    private static int findMaxIndexOfWindow(int[] array, int leftOfWindow, int rightOfWindow) {

        if(leftOfWindow == rightOfWindow){
            return rightOfWindow;
        }
        int max = Integer.MIN_VALUE;
        for(int i = leftOfWindow; i<= rightOfWindow;i++){
            if (max <= array[i])
                max = array[i];
        }
        return max;
    }

    /**
     * 复杂度O(N)
     * */
    public static int[] FindMaxOfWindow2(int[] array ,int windowSize){
        int[] result = new int[array.length - windowSize + 1];
        int rightOfWindow = windowSize - 1;
        ArrayDeque<Integer> qmax = new ArrayDeque<>();
        int index = 0;
        while (index < array.length){
            if(!qmax.isEmpty() && qmax.peekFirst() == index - windowSize){
                qmax.pollFirst();
            }
            while (true){
                if(qmax.isEmpty()){
                    qmax.addLast(index);
                    break;
                }else if (array[index] >= array[qmax.peekLast()]){
                    qmax.pollLast();
                }else {
                    qmax.addLast(index);
                    break;
                }
            }
            if(index == rightOfWindow){
                result[rightOfWindow - windowSize + 1] = array[qmax.peekFirst()];
                rightOfWindow++;
            }
            index++;
        }
        return result;
    }
}
