import org.junit.Test;
import string.PalindromicSubString;

/**
 * Created by wy on 2018/7/11.
 */
public class StringTest {

    @Test
    public void testPalindromicSubString(){
        String str = "aaba";
        PalindromicSubString solution = new PalindromicSubString();
        int result = solution.countSubstrings(str);
        System.out.println(result);
    }
}
