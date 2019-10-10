package com.bytetree.lintcode.design.ood;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * 560. Friendship Service
 * <p>
 * Support follow & unfollow, getFollowers, getFollowings.
 * <p>
 * Example
 * follow(1, 3)
 * getFollowers(1) // return [3]
 * getFollowings(3) // return [1]
 * follow(2, 3)
 * getFollowings(3) // return [1,2]
 * unfollow(1, 3)
 * getFollowings(3) // return [2]
 * <p>
 * <a href="https://www.lintcode.com/problem/friendship-service/description">560. Friendship Service</a>
 * <p>
 * Created by vencial on 2019-10-10.
 */
public class FriendshipService {

    private Map<Integer, Set<Integer>> mFollower, mFollowing;

    public FriendshipService() {
        // do intialization if necessary
        mFollower = new HashMap<>();
        mFollowing = new HashMap<>();
    }

    /*
     * @param user_id: An integer
     * @return: all followers and sort by user_id
     */
    public List<Integer> getFollowers(int user_id) {
        // write your code here
        if (!mFollower.containsKey(user_id)) {
            return new ArrayList<>();
        }
        return new ArrayList<>(mFollower.get(user_id));
    }

    /*
     * @param user_id: An integer
     * @return: all followings and sort by user_id
     */
    public List<Integer> getFollowings(int user_id) {
        // write your code here
        if (!mFollowing.containsKey(user_id)) {
            return new ArrayList<>();
        }
        return new ArrayList<>(mFollowing.get(user_id));
    }

    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void follow(int to_user_id, int from_user_id) {
        // write your code here
        if (!mFollower.containsKey(to_user_id)) {
            mFollower.put(to_user_id, new TreeSet<Integer>());
        }
        mFollower.get(to_user_id).add(from_user_id);
        if (!mFollowing.containsKey(from_user_id)) {
            mFollowing.put(from_user_id, new TreeSet<Integer>());
        }
        mFollowing.get(from_user_id).add(to_user_id);
    }

    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void unfollow(int to_user_id, int from_user_id) {
        // write your code here
        if (mFollower.containsKey(to_user_id)) {
            mFollower.get(to_user_id).remove(from_user_id);
        }
        if (mFollowing.containsKey(from_user_id)) {
            mFollowing.get(from_user_id).remove(to_user_id);
        }
    }
}
