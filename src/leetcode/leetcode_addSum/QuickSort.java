package leetcode.leetcode_addSum;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        //int[] array = new int[]{1,2,3,4,5,6,7};
        int[] array = new int[]{3,4,5,6,7,8,9,1,2,3,4,5,6,7,2,32};
        quickSort(array);
        System.out.println(Arrays.toString(array));
        System.out.println(2^3);
    }

    private static void quickSort(int[] ints) {

        int middle = getMiddle(ints,0,ints.length - 1);
            _quickSort(ints,0,middle);
            _quickSort(ints,middle,ints.length-1);
        }

    private static int getMiddle(int[] array, int left, int right) {
        if(array.length <= 0){
            return -1;
        }
        int key = array[left];
        while (left < right){
            while ( left < right && array[right] >= key){
                right--;
            }
            array[left] = array[right];
            while ( left < right && array[left] <= key){
                left++;
            }
            array[right] = array[left];
        }
        array[left] = key;

        return left;
    }

    private static void  _quickSort(int[] array,int left,int right) {
        if(left < right){
            int middle = getMiddle(array,left,right);
            _quickSort(array,left,middle-1);
            _quickSort(array,middle + 1,right);
        }
    }

}
