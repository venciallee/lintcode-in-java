package com.bytetree.lintcode.string;

import java.util.HashMap;

/**
 * 639. Word Abbreviation
 * <p>
 * Given an array of n distinct non-empty strings, you need to generate minimal possible abbreviations for every word following rules below.
 * <p>
 * Begin with the first character and then the number of characters abbreviated, which followed by the last character.
 * If there are any conflict, that is more than one words share the same abbreviation, a longer prefix is used instead of only the first character until making the map from word to abbreviation become unique. In other words, a final abbreviation cannot map to more than one original words.
 * If the abbreviation doesn't make the word shorter, then keep it as original.
 * <p>
 * Example
 * Example 1:
 * <p>
 * Input:
 * ["like","god","internal","me","internet","interval","intension","face","intrusion"]
 * Output:
 * ["l2e","god","internal","me","i6t","interval","inte4n","f2e","intr4n"]
 * Example 2:
 * <p>
 * Input:
 * ["where","there","is","beautiful","way"]
 * Output:
 * ["w3e","t3e","is","b7l","way"]
 * <p>
 * <a href="https://www.lintcode.com/problem/word-abbreviation/description">639. Word Abbreviation</a>
 * <p>
 * Created by vencial on 2019-09-16.
 */
public class WordAbbreviation {

    /**
     * @param dict: an array of n distinct non-empty strings
     * @return: an array of minimal possible abbreviations for every word
     */
    public String[] wordsAbbreviation(String[] dict) {
        // write your code here

        if (dict == null  || dict.length == 0) return dict;

        int length = dict.length;
        HashMap<String, Integer> map = new HashMap<>();
        int round = 1;
        String[] ans = new String[length];
        for(int i = 0; i < dict.length; i++) {
            String word = dict[i];
            ans[i] = getAbbr(word, round);
            map.put(ans[i], map.getOrDefault(ans[i], 0) + 1);
        }

        while (true) {
            boolean unique = true;
            round++;
            for(int i = 0; i < dict.length; i++) {
                String origin = dict[i];
                String word = ans[i];
                if (map.get(word) > 1) {
                    ans[i] = getAbbr(origin, round);
                    map.put(ans[i], map.getOrDefault(ans[i], 0) + 1);
                    unique = false;
                }
            }
            if (unique) {
                break;
            }
        }

        return ans;
    }

    private String getAbbr(String origin, int split) {
        if (split + 2 >= origin.length()) return origin;

        int length = origin.length();
        String abbr = origin.substring(0, split) + (length - split - 1) + origin.charAt(length - 1);
        return abbr;
    }
}
