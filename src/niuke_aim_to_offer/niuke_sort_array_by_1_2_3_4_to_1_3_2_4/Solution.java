package niuke_aim_to_offer.niuke_sort_array_by_1_2_3_4_to_1_3_2_4;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7};
        new Solution().reOrderArray(array);
        System.out.println(Arrays.toString(array));
    }
    public void reOrderArray(int [] array) {
        int[] newArray = Arrays.copyOf(array,array.length);
        int index = 0;
        int re_index = array.length - 1;
        int size = array.length - 1;
        for(int i = 0;i<newArray.length;i++){
            if(newArray[i]%2==1){
                array[index] = newArray[i];
                index++;
            }
            if (newArray[size - i]%2==0) {
                array[re_index] = newArray[size-i];
                re_index--;
            }

        }

    }
}
