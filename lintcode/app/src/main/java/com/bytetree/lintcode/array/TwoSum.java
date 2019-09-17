package com.bytetree.lintcode.array;

import java.util.HashMap;

/**
 * 56. Two Sum
 * <p>
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are zero-based.
 * <p>
 * You may assume that each input would have exactly one solution
 * <p>
 * Example
 * Example1:
 * numbers=[2, 7, 11, 15], target=9
 * return [0, 1]
 * Example2:
 * numbers=[15, 2, 7, 11], target=9
 * return [1, 2]
 * Challenge
 * Either of the following solutions are acceptable:
 * <p>
 * O(n) Space, O(nlogn) Time
 * O(n) Space, O(n) Time
 * <p>
 * <a href="https://www.lintcode.com/problem/two-sum/description">56. Two Sum</a>
 * <p>
 * Created by vencial on 2019-09-16.
 */
public class TwoSum {

    /**
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1, index2] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int diff = target - numbers[i];
            if (map.containsKey(diff)) {
                int ans[] = {map.get(diff), i};
                return ans;
            } else {
                map.put(numbers[i], i);
            }
        }
        return new int[0];
    }
}
