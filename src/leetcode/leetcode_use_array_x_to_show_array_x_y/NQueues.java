package leetcode.leetcode_use_array_x_to_show_array_x_y;



/**
 * 一维数组代替二位数组
 * */
public class NQueues {

    private int[][] array;

    public NQueues(int n) {
        array = new int[n][n];
        int count = n * n;
        while (count-- > 0) {
            array[count / n][count % n] = 1;
        }
        print(array);
    }

    private void print(int[][] array){
        for (int[] anArray : array) {
            for (int anAnArray : anArray) {
                System.out.print(anAnArray + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new NQueues(8);
    }

}
