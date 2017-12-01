package niuke_aim_to_offer.niuke_find_number_of_1_in_binary_of_int;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * */
public class FindNumOfBinaryInt {

    public static void main(String[] args) {
        System.out.println(getNumOfBinaryInt(39));
        System.out.println(getNumOfBinaryInt(38));
        //1111 -> 1 2 4 8 16 32
        //1 1 1 0 0  1

        //
    }

    private static int getNumOfBinaryInt(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }
}
