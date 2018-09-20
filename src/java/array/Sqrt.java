package array;

/**
 * 69. x 的平方根
 * https://leetcode-cn.com/problems/sqrtx/description/
 * Created by wy on 2018/7/4.
 */
public class Sqrt {
    public int mySqrt(int x) {
        int left = 1, right = x, mid;
        while(left <= right){
            // 避免溢出
            mid= left + (right - left) / 2;
            // x < mid * mid (mid * mid 会溢出)
            if(x / mid < mid){
                right = mid - 1;
            }
            // x > mid * mid
            else if(x / mid > mid) {
                left = mid + 1;
            }
            else {
                return mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        Sqrt solution = new Sqrt();
        int result = solution.mySqrt(8);
        System.out.println(result);
    }
}

