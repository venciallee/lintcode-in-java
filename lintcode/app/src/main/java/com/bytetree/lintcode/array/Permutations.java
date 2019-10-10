package com.bytetree.lintcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 15. Permutations
 * <p>
 * Given a list of numbers, return all possible permutations.
 * <p>
 * You can assume that there is no duplicate numbers in the list.
 * <p>
 * Example
 * Example 1:
 * <p>
 * Input: [1]
 * Output:
 * [
 * [1]
 * ]
 * Example 2:
 * <p>
 * Input: [1,2,3]
 * Output:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * Created by vencial on 2019-10-10.
 */
public class Permutations {

    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<>();
        backtrace(nums, ans, new ArrayList());
        return ans;
    }

    private void backtrace(int[] nums, List<List<Integer>> ans, List<Integer> tmp) {
        if (tmp.size() == nums.length) {
            ans.add(new ArrayList<>(tmp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (tmp.contains(num)) continue;
                tmp.add(num);
                backtrace(nums, ans, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
