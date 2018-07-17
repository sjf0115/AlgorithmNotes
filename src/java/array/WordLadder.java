package array;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * 127. 单词接龙
 * https://leetcode-cn.com/problems/word-ladder/description/
 * Created by wy on 2018/3/29.
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        return 0;
    }

    private int BFS(String beginWord, String endWord, List<String> wordList){

        if(Objects.equals(beginWord, endWord)){
            return 0;
        }
        Set<String> visited = new HashSet<>();
        return 0;
    }

}
