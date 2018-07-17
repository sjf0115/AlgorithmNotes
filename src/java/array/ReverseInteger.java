package array;

/**
 * 7. 颠倒整数
 * https://leetcode-cn.com/problems/reverse-integer/description/
 * @author sjf0115
 * @Date Created in 上午9:49 18-3-22
 */
public class ReverseInteger {

    public int reverse2(int x) {

        if(x == 0){
            return x;
        }
        long n = x;
        boolean isNegative = false;
        if (x < 0){
            isNegative = true;
            n = -1 * (long)x;
        }
        long result = 0;
        while(n != 0){
            result = result * 10 + n % 10;
            n = n / 10;
        }
        if(isNegative){
            result = -1 * result;
            if(result <= Integer.MIN_VALUE){
                return 0;
            }
            return (int)result;
        }
        else {
            if(result >= Integer.MAX_VALUE){
                return 0;
            }
            return (int)result;
        }

    }

    public int reverse(int x) {

        long result = 0;
        int tmp = Math.abs(x);
        while(tmp > 0){
            result = result * 10 + tmp % 10;
            if(result > Integer.MAX_VALUE){
                return 0;
            }
            tmp = tmp / 10;
        }
        return (int)(x > 0 ? result : -result);

    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(-2147483648));
    }
}
