package heap;

import java.util.*;

/**
 * 347. 前K个高频元素
 * https://leetcode-cn.com/problems/top-k-frequent-elements/description/
 * @author sjf0115
 * @Date Created in 下午12:22 18-8-23
 */
public class TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(k, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int num : nums){
            if(countMap.containsKey(num)){
                countMap.put(num, countMap.get(num) + 1);
            }
            else {
                countMap.put(num, 1);
            }
        }
        for(Map.Entry entry : countMap.entrySet()){
            System.out.println(entry.getKey());
            queue.add(entry);
            if(queue.size() > k){
                queue.poll();
            }
        }
        List<Integer> result = new ArrayList();
        for(int i = 0;i < k;i++){
            Map.Entry<Integer, Integer> element = queue.poll();
            result.add(0, element.getKey());
        }
        return result;
    }

}
