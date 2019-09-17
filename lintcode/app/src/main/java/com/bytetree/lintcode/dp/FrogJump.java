package com.bytetree.lintcode.dp;

/**
 * 622. Frog Jump
 * <p>
 * A frog is crossing a river. The river is divided into x units and at each unit there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.
 * <p>
 * Given a list of stones' positions (in units) in sorted ascending order, determine if the frog is able to cross the river by landing on the last stone. Initially, the frog is on the first stone and assume the first jump must be 1 unit.
 * <p>
 * If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 units. Note that the frog can only jump in the forward direction.
 * <p>
 * Example
 * Example 1:
 * <p>
 * Given stones = [0,1,3,5,6,8,12,17]
 * Input:
 * [0,1,3,5,6,8,12,17]
 * Output:
 * true
 * <p>
 * Explanation:
 * There are a total of 8 stones.
 * The first stone at the 0th unit, second stone at the 1st unit,third stone at the 3rd unit, and so on...The last stone at the 17th unit.
 * Return true. The frog can jump to the last stone by jumping 1 unit to the 2nd stone, then 2 units to the 3rd stone, then 2 units to the 4th stone, then 3 units to the 6th stone, 4 units to the 7th stone, and 5 units to the 8th stone.
 * Example 2:
 * <p>
 * Given stones = `[0,1,2,3,4,8,9,11]`
 * Input:
 * [0,1,2,3,4,8,9,11]
 * Output:
 * false
 * <p>
 * Explanation:
 * Return false. There is no way to jump to the last stone as the gap between the 5th and 6th stone is too large.
 * <p>
 * <a href="https://www.lintcode.com/problem/frog-jump/description">622. Frog Jump</a>
 * <p>
 * Created by vencial on 2019-09-15.
 */
public class FrogJump {

    private boolean ans = false;
    public boolean canCross(int[] stones) {
        // write your code here
        if (stones == null || stones.length == 0) return false;
        for (int i = 0; i < stones.length; i++) {
            if (i > 3 && stones[i] > stones[i - 1] * 2) {return false;} // The two stones are too far away.
        }
        dfs(stones, 0, 1, 1);
        return ans;
    }

    private void dfs (int[] stones, int index, int start, int end) {
        if (index == stones.length - 1)  {
            ans = true;
            return;
        }

        if (ans) {
            return;
        }

        for (int i = index + 1; i < stones.length; i++) {
            int diff = stones[i] - stones[index];
            if (diff > end) {
                break;
            }
            if (diff < start) {
                continue;
            }
            dfs(stones, i, diff - 1, diff + 1);
        }

    }
}
