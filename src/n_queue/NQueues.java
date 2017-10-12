package n_queue;

import java.util.Arrays;

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
