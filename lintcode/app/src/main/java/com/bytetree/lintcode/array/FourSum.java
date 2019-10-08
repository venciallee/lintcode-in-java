package com.bytetree.lintcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 58. 4Sum
 * <p>
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
 * <p>
 * Find all unique quadruplets in the array which gives the sum of target.
 * <p>
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 * <p>
 * Example
 * Example 1:
 * <p>
 * Input:[2,7,11,15],3
 * Output:[]
 * <p>
 * Example 2:
 * <p>
 * Input:[1,0,-1,0,-2,2],0
 * Output:
 * [[-1, 0, 0, 1]
 * ,[-2, -1, 1, 2]
 * ,[-2, 0, 0, 2]]
 * <p>
 * <a href="https://www.lintcode.com/problem/4sum/description">58. 4Sum</a>
 * <p>
 * Created by vencial on 2019-10-08.
 */
public class FourSum {

    /**
     * @param numbers: Give an array
     * @param target: An integer
     * @return: Find all unique quadruplets in the array which gives the sum of zero
     */
    public List<List<Integer>> fourSum(int[] numbers, int target) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<>();
        if(numbers == null || numbers.length <= 3) return ans;

        Arrays.sort(numbers);
        int length = numbers.length;
        for (int i = 0; i < numbers.length - 3; i++) {
            if (i != 0 && numbers[i] == numbers[i - 1]) continue;
            for (int j = i + 1; j < numbers.length - 2; j++) {
                if (j != i + 1 && numbers[j] == numbers[j - 1]) continue;
                int l = j + 1;
                int r = length - 1;
                while (l < r) {
                    int sum = numbers[i] + numbers[j] + numbers[l] + numbers[r];
                    if (sum < target) {
                        l++;
                    } else if (sum > target) {
                        r--;
                    } else {
                        List<Integer> subAns = new ArrayList<>();
                        subAns.add(numbers[i]);
                        subAns.add(numbers[j]);
                        subAns.add(numbers[l]);
                        subAns.add(numbers[r]);
                        ans.add(subAns);
                        l++;
                        r--;
                        while (l < r && numbers[l] == numbers[l - 1]) {
                            l++;
                        }
                        while (l < r && numbers[r] == numbers[r + 1]) {
                            r--;
                        }
                    }
                }

            }
        }
        return ans;
    }
}
