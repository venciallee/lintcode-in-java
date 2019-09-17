package com.bytetree.lintcode.array;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 959. K Spaced Array Sorting
 * <p>
 * An array is ordered from small to large every k digits, ie arr[i] <= arr[i + k] <= arr[i + 2 * k] <= .... Sort the array from small to large. We expect you to write an algorithm whose time complexity is ** O(n * logk)**.
 * <p>
 * 0 <= arr[i] <= 2^31 - 1
 * 1 <= |arr| <= 10^5
 * 1 <= k <= 10^5
 * <p>
 * Example
 * Example 1:
 * <p>
 * Input: arr = [1,2,3], k = 1,
 * Output: [1,2,3].
 * Explanation:
 * The sorted array is [1,2,3].
 * Example 2:
 * <p>
 * Input: arr = [4,0,5,3,10], k = 2,
 * Output: [0,3,4,5,10].
 * Explanation:
 * The sorted array is [0,3,4,5,10].
 * <p>
 * <a href="https://www.lintcode.com/problem/k-spaced-array-sorting/description">959. K Spaced Array Sorting</a>
 * <p>
 * Created by vencial on 2019-09-16.
 */
public class KSpacedArraySorting {

    /**
     * @param arr: The K spaced array
     * @param k: The param k
     * @return: Return the sorted array
     */
    public int[] getSortedArray(int[] arr, int k) {
        // Write your code here
        Queue<Pair> queue = new PriorityQueue<>(k, elementComparator);
        for (int i = 0; i < k; i++) {
            queue.offer(new Pair(arr[i], i));
        }
        int ans[] = new int[arr.length];
        int index = 0;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            ans[index++] = pair.value;
            if ((pair.index + k) < arr.length) {
                queue.offer(new Pair(arr[pair.index + k], pair.index + k));
            }
        }
        return ans;
    }

    class Pair {
        int value;
        int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    Comparator<Pair> elementComparator = new Comparator<Pair>() {
        public int compare(Pair p1, Pair p2) {
            if (p1.value != p2.value) {
                return p1.value - p2.value;
            } else {
                return p1.index - p2.index;
            }
        }
    };
}
