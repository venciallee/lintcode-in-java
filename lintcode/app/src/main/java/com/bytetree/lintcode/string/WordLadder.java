package com.bytetree.lintcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 120. Word Ladder
 * <p>
 * Given two words (start and end), and a dictionary, find the shortest transformation sequence from start to end, output the length of the sequence.
 * Transformation rule such that:
 * <p>
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary. (Start and end words do not need to appear in the dictionary )
 * <p>
 * Example
 * Example 1:
 * <p>
 * Input：start = "a"，end = "c"，dict =["a","b","c"]
 * Output：2
 * Explanation：
 * "a"->"c"
 * Example 2:
 * <p>
 * Input：start ="hit"，end = "cog"，dict =["hot","dot","dog","lot","log"]
 * Output：5
 * Explanation：
 * "hit"->"hot"->"dot"->"dog"->"cog"
 * <p>
 * <a href="https://www.lintcode.com/problem/word-ladder/description">120. Word Ladder</a>
 * <p>
 * Created by vencial on 2019-09-12.
 */
public class WordLadder {

    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        int len = 1;
        int strLen = start.length();
        HashSet<String> visited = new HashSet<>();

        beginSet.add(start);
        endSet.add(end);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }

            Set<String> tmp = new HashSet<>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();

                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);

                        if (endSet.contains(target)) {
                            return len + 1;
                        }

                        if (!visited.contains(target) && dict.contains(target)) {
                            tmp.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }
            beginSet = tmp;
            len++;
        }

        return 0;
    }
}
