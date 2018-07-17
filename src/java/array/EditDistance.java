package array;

import java.util.Objects;

/**
 * 72. 编辑距离
 * @author sjf0115
 * @Date Created in 下午7:04 18-3-22
 */
public class EditDistance {

    public int minDistance2(String word1, String word2) {

        int len1 = word1.length();
        int len2 = word2.length();
        if(len1 == 0){
            return len2;
        }
        if(len2 == 0){
            return len1;
        }

        if(Objects.equals(word1.charAt(0), word2.charAt(0))){
            return minDistance(word1.substring(1), word2.substring(1));
        }

        int distance1 = minDistance(word1.substring(1), word2);
        int distance2 = minDistance(word1, word2.substring(1));
        int distance3 = minDistance(word1.substring(1), word2.substring(1));

        return 1 + Math.min(distance1, Math.min(distance2, distance3));

    }

    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();
        // Edit[i][j]为word1[0..i-1]和word2[0..j-1]的最小编辑数
        int Edit[][] = new int[m+1][n+1];
        // 初始化
        for(int i = 0;i <= m;++i){
            Edit[i][0] = i;
        }//for
        for(int i = 0;i <= n;++i){
            Edit[0][i] = i;
        }//for
        for(int i = 1;i <= m;++i){
            for(int j = 1;j <= n;++j){
                // 当前字符相同
                if(Objects.equals(word1.charAt(i-1), word2.charAt(j-1))){
                    Edit[i][j] = Edit[i-1][j-1];
                }//if
                else{
                    Edit[i][j] = 1 + Math.min(Edit[i-1][j-1], Math.min(Edit[i-1][j],Edit[i][j-1]));
                }//else
            }//for
        }//for
        return Edit[m][n];

    }

    public static void main(String[] args) {

        EditDistance editDistance = new EditDistance();
        System.out.println(editDistance.minDistance("xabcdae", "xfdfa"));

    }

}
