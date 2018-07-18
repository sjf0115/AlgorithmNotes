package string;

/**
 * 647. 回文子串
 * https://leetcode-cn.com/problems/palindromic-substrings/description/
 * Created by wy on 2018/7/11.
 */
public class PalindromicSubString {
    public int countSubstrings(String s) {
        int len = s.length();
        if(s == null){
            return 0;
        }
        int count = 0;
        // 遍历长度
        for(int i = 1; i <= len;i++){
            // 判断以j下标开始长度为i的子串是否是回文串
            for(int j = 0;j <= len - i;j++){
                String str = s.substring(j, j + i);
                if(isPalindromic(str)){
                    count++;
                }
            }
        }
        return count;
    }

    // 判断是否是回文串
    private boolean isPalindromic(String str){
        if(str == null){
            return false;
        }
        int len = str.length();
        for(int left = 0, right = len - 1;left < right;left++,right--){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
        }
        return true;
    }
}
