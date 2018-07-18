package array;

import java.util.Stack;

/**
 * 739. 每日温度
 * https://leetcode-cn.com/problems/daily-temperatures/description/
 * @author sjf0115
 * @Date Created in 下午5:31 18-7-17
 */
public class DailyTemperatures {

    /**
     * O(N^2)
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures2(int[] temperatures) {
        int size = temperatures.length;
        int[] next = new int[size];
        for(int i = 0;i < size;i++){
            int nextPos = 0;
            for(int j = i + 1;j < size;j++){
                if(temperatures[j] > temperatures[i]){
                    nextPos = j;
                    break;
                }
            }
            next[i] = nextPos > 0 ? nextPos - i : nextPos;
        }
        return next;
    }

    /**
     * 使用栈 O(N)
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int size = temperatures.length;
        int[] next = new int[size];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i < size;i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                next[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            next[stack.pop()] = 0;
        }
        return next;
    }
}



























