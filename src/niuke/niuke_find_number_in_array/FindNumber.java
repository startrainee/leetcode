package niuke.niuke_find_number_in_array;



/**
 * 在杨氏矩阵里找到数
 * */
public class FindNumber {

    public static void main(String[] args) {

        int[][] array = new int[][]{
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };

        int targetNum = 5;
        System.out.println(findNumber(array, targetNum));
    }

    private static boolean findNumber(int[][] array, int targetNum) {

        for (int[] anArray : array) {
            for (int anAnArray : anArray) {
                if (anAnArray > targetNum) {
                    break;
                } else if (anAnArray == targetNum) {
                    return true;
                }
            }
        }
        return false;
    }
}

