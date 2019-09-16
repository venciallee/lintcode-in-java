package com.bytetree.lintcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 956. Data Segmentation
 * <p>
 * Given a string str, we need to extract the symbols and words of the string in order.
 * <p>
 * The length of str does not exceed 10000.
 * The given str contains only lowercase letters, symbols, and spaces.
 * <p>
 * Example
 * Example 1:
 * <p>
 * input: str = "(hi (i am)bye)"
 * outut:["(","hi","(","i","am",")","bye",")"].
 * Explanation:Separate symbols and words.
 * Example 2:
 * <p>
 * input: str =  "#ok    yes"
 * outut:["#","ok","yes"]
 * Explanation:Separate symbols and words.
 * Example 3:
 * <p>
 * input: str =  "##s"
 * outut:["#","#","s"]
 * Explanation:Separate symbols and words.
 * <p>
 * <a href="https://www.lintcode.com/problem/data-segmentation/description">956. Data Segmentation</a>
 * <p>
 * Created by vencial on 2019-09-16.
 */
public class DataSegmentation {

    /**
     * @param str: The input string
     * @return: The answer
     */
    public String[] dataSegmentation(String str) {
        // Write your code here

        List<String> seg = new ArrayList<>();
        int start = 0;
        int end = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++, end++) {
            char item = str.charAt(i);
            if (item == ' ') {
                if (sb.length() > 0) {
                    seg.add(sb.toString());
                }
                sb = new StringBuilder();
                continue;
            } else if (item >= 'a' && item <= 'z') {
                sb.append(item);
            } else {
                if (sb.length() > 0) {
                    seg.add(sb.toString());
                }
                sb = new StringBuilder();

                seg.add(String.valueOf(item));
            }

        }
        if (sb.length() != 0) {
            seg.add(sb.toString());
        }
        return seg.toArray(new String[seg.size()]);
    }
}
