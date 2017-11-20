package niuke.niuke_fibonacci_array;

import java.util.Arrays;

/**
 * 斐波那契数列
 * f(0) = 1;
 * f(1) = 1;
 * f(n) = f(n-1) + f(n-2);
 *
 * 衍生问题
 *  跳台阶：可以一步走1或者2个台阶，求到n个台阶的走法有多少种方法。
 *      --分析：
 *          n台阶可以由 f(n-1) 走 1 个台阶 或者 f(n-2) 之后走2 个台阶 两种方式得到。
 *          故，f(n) = f(n-1) + f(n-2),这符合Fibonacci 数列规则(设f(0) = 1,并且配合f(1) = 1,f(2) = 2)。
 *      --
 *  变态跳台阶：可以一步走1,2,3,...,n 个台阶，求到n个台阶的走法有多少种方法。
 *      --分析：
 *         f(0) = 0,f(1) = 1;
 *         f(n) = f(1) + f(2) + ... + f(n-1) + 1;
 *         当n >=2 ,f(n-1) = f(1) + f(2) + ... + f(n-2) + 1;
 *         故，当n >=2 ,f(n) = 2 f(n -1);
 *         综上，当n >=1 时， 可得到，f(n) = 2*f(n-1);
 *      --
 * */

public class FibonacciArray {

    private static int ARRAY_MAX_SIZE = 39;        //设置阈值
    private int[] fibonacci_array = new int[ARRAY_MAX_SIZE];

    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        System.out.println("Time: " + t1);
        System.out.println(getFibonacci(39));
        long t2 = System.currentTimeMillis();
        System.out.println("Time " + (t2 - t1));
        System.out.println(new FibonacciArray().getFibonacci2(39));
        long t3 = System.currentTimeMillis();
        System.out.println("Time " + (t3 - t2));
    }

    public int getFibonacci2(int n) {
        if(n < 0 ){
            return -1;
        }
        if(n >= ARRAY_MAX_SIZE){
            growArray(ARRAY_MAX_SIZE);
        }

        if(fibonacci_array[n] == 0){
            fibonacci_array[n] = _getFibonacci2(n);
        }

        return fibonacci_array[n];

    }

    private int _getFibonacci2(int n) {
        if(n==0 || n==1){
            fibonacci_array[n] = 1;
            return fibonacci_array[n];
        }
        if(fibonacci_array[n-1] == 0){
            fibonacci_array[n-1] = _getFibonacci2(n-1);
        }
        if(fibonacci_array[n-2] == 0){
            fibonacci_array[n-2] = _getFibonacci2(n-2);
        }
        fibonacci_array[n] = fibonacci_array[n-1] + fibonacci_array[n-2];
        return fibonacci_array[n];
    }

    private void growArray(int arrayMaxSize) {
        fibonacci_array = Arrays.copyOf(fibonacci_array,fibonacci_array.length + arrayMaxSize);

    }

    /**
     * 递归调用，但是要注意递归深度，当 n 过大时，会降低性能
     * */
    public static int getFibonacci(int n) {
        if(n == 0 || n == 1)
        return 1;
        return getFibonacci(n - 1) + getFibonacci(n-2);
    }
}
