package towSum;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello World!");
        int[] ints = new int[]{1,2,3,4,5,6,7,8,9};
        System.out.println(Arrays.toString(twoSum(ints,9)));

    }


    private static int[] twoSum(int[] nums, int target) {
        for(int i = 0;i<nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                if(target == nums[i] + nums[j]){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }
}
