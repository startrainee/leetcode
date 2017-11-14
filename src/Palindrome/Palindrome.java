package Palindrome;


/**
 * 判断是否为回文字符串
 * */
public class Palindrome {

    public static void main(String[] args) {
        int[] test = new int[]{123,456,7123456,44467,-112233445,-12321,1234554321};
        for (int i : test) {
            System.out.print("v1-");
            System.out.println(isPalindrome(i));
            System.out.print("v2-");
            System.out.println(isPalindrome_v2(i));
        }
    }
    public static boolean isPalindrome(int x) {
        char[] num = String.valueOf(x).toCharArray();
        int i = 0;
        while(num[i] == num[num.length- 1 - i]){
            i++;
            if(i > num.length/2) return true;
        }
        return false;
    }

    public static boolean isPalindrome_v2(int x) {
        char[] num = String.valueOf(x).toCharArray();
        return isPalindrome_v2(num,0,num.length - 1);
    }

    public static boolean isPalindrome_v2(char[] x,int start,int end) {
        return start >= end || x[start] == x[end] && isPalindrome_v2(x, start + 1, end - 1);
    }
}
