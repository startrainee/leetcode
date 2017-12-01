package niuke_aim_to_offer.niuke_base_of_n_multiplication;
/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().Power(1.2,2));
        System.out.println(new Solution().Power(0.2,-2));
        System.out.println(new Solution().Power(2,-3));
    }
    public double Power(double base, int exponent) {
        if (base == 0)
            return 0;
        if(exponent == 0)
            return 1;
        if(exponent < 0) {
            base = 1.0 / base;
            exponent = 0 - exponent;
        }
        double result = base;
        while (--exponent > 0){
            result = base * result;
        }
        return result;
    }
}
