import heap.TopKFrequentElements;
import org.junit.Test;

import java.util.List;

/**
 * @author sjf0115
 * @Date Created in 下午12:38 18-8-23
 */
public class HeapTest {
    @Test
    public void testTopKFrequentElements(){
        int[] nums = {1,1,1,2,2,3};
        //int[] nums = {1};
        int k = 2;
        TopKFrequentElements solution = new TopKFrequentElements();
        List<Integer> result = solution.topKFrequent(nums, k);
        System.out.println(result);
    }
}
