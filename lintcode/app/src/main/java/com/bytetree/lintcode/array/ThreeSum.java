package com.bytetree.lintcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 57. 3Sum
 * <p>
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * <p>
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example
 * Example 1:
 * <p>
 * Input:[2,7,11,15]
 * Output:[]
 * Example 2:
 * <p>
 * Input:[-1,0,1,2,-1,-4]
 * Output:	[[-1, 0, 1],[-1, -1, 2]]
 * <p>
 * <a href="https://www.lintcode.com/problem/3sum/description">57. 3Sum</a>
 * <p>
 * Created by vencial on 2019-10-08.
 */
public class ThreeSum {

    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here

        List<List<Integer>> ans = new ArrayList<>();
        if (numbers == null || numbers.length <= 2) return ans;
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 2; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            twoSum(numbers, -numbers[i], i + 1, ans);
        }

        return ans;
    }

    private void twoSum(int[] numbers, int target, int start, List<List<Integer>> ans) {
        for (int l = start, r = numbers.length - 1; l < r; r--) {
            while (l < r && numbers[l] + numbers[r] < target) {
                l++;
            }
            if (l < r && numbers[l] + numbers[r] == target) {
                List<Integer> subAns = new ArrayList<>();
                subAns.add(-target);
                subAns.add(numbers[l]);
                subAns.add(numbers[r]);
                ans.add(subAns);
                while (l < r && numbers[r] == numbers[r - 1]) {
                    r--;
                }
            }
        }
    }

}
