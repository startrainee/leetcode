package niuke_aim_to_offer.niuke_tow_number;

import java.util.Arrays;

/**
 * 判断数组内是否有两数和为指定值
 * */

public class TwoSum {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello World!");
        int[] ints = new int[]{1,2,3,4,5,6,7,8,9};
        System.out.println(Arrays.toString(twoSum(ints,7)));
        System.out.println(Arrays.toString(twoSum(ints,9)));

    }


    private static int[] twoSum(int[] ints, int target) {
        for(int i = 0;i<ints.length;i++){
            for(int j = i+1;j<ints.length;j++){
                if(target == ints[i] + ints[j]){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }
}
