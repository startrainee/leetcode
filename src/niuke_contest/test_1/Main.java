package niuke_contest.test_1;

import java.util.Scanner;

public class Main {
    static String Alice = "Alice";
    static String Bob = "Bob";
    static String Tie = "Tie";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.valueOf(scanner.nextLine());

        while (count-- > 0) {
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            String[] array1 = str1.split(" ");
            String[] array2 = str2.split(" ");
            int[] numAlice = new int[array1.length];
            int[] numBob = new int[array2.length];
            for (int i = 0; i < array1.length; i++) {
                numAlice[i] = Integer.valueOf(array1[i]);
                numBob[i] = Integer.valueOf(array2[i]);
            }
            System.out.println(getResult(numAlice, numBob));
        }
    }

     public static String getResult(int[] numAlice, int[] numBob) {
        int isAliceWin = 0;
        int isBobWin = 0;

        for (int i : numAlice) {
            for (int j : numBob) {
                if (i > j)
                    isAliceWin++;
                if (i < j)
                    isBobWin++;
            }
        }
        if (isAliceWin > isBobWin)
            return Alice;
        if (isAliceWin < isBobWin)
            return Bob;
        return Tie;
    }

}
