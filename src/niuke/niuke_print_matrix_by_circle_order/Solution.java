package niuke.niuke_print_matrix_by_circle_order;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,23,4,5,6}



        };
        System.out.println(Arrays.toString(new Solution().printMatrix(matrix).toArray()));
    }

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        int sizeX = matrix[0].length;
        int sizeY = matrix.length;
        if (matrix.length == 0) {
            return result;
        }
        int[] tLeft = new int[]{0, 0};
        int[] tRight = new int[]{0, sizeX - 1};
        int[] bLeft = new int[]{sizeY - 1, 0};
        int[] bRight = new int[]{sizeY - 1, sizeX - 1};
        int times = sizeY / 2;

        if (sizeY == 1) {
            getPointValue(result, matrix, tLeft, bRight);
            result.add(matrix[bRight[0]][bRight[1]]);
            return result;
        }

        while (times-- > 0) {
            getPointValue(result, matrix, tLeft, tRight);
            getPointValue(result, matrix, tRight, bRight);
            getPointValue(result, matrix, bRight, bLeft);
            getPointValue(result, matrix, bLeft, tLeft);
            tLeft[0]++;
            tLeft[1]++;
            tRight[0]++;
            tRight[1]--;
            bLeft[0]--;
            bLeft[1]++;
            bRight[0]--;
            bRight[1]--;
            if(tLeft[0]>bRight[0]||tLeft[1]>tRight[1]){
                break;
            }
            if (tLeft[0] == bRight[0]) {
                getPointValue(result, matrix, tLeft, bRight);
                    result.add(matrix[bRight[0]][bRight[1]]);
            }
        }
        return result;
    }

    public void getPointValue(ArrayList<Integer> arrayList, int[][] matrix, int[] from, int[] end) {

        if (Arrays.equals(from, end)) {
            return;
        }

        if (from[0] < 0 || from[0] >= matrix.length || end[0] < 0 || end[0] >= matrix.length) {
            return;
        }
        if (from[1] < 0 || from[1] >= matrix[0].length || end[1] < 0 || end[1] >= matrix[0].length) {
            return;
        }


        if (from[0] == end[0]) {
            if (from[1] <= end[1]) {
                for (int i = from[1]; i < end[1]; i++) {
                    arrayList.add(matrix[from[0]][i]);
                }
            }
            for (int i = from[1]; i > end[1]; i--) {
                arrayList.add(matrix[from[0]][i]);
            }

        }
        if (from[1] == end[1]) {
            if (from[0] <= end[0]) {
                for (int i = from[0]; i < end[0]; i++) {
                    arrayList.add(matrix[i][from[1]]);
                }
            }
            for (int i = from[0]; i > end[0]; i--) {
                arrayList.add(matrix[i][from[1]]);
            }
        }
    }

}