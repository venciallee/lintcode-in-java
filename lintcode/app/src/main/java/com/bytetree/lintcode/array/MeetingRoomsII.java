package com.bytetree.lintcode.array;

import java.util.List;
import java.util.TreeMap;

/**
 * 919. Meeting Rooms II
 * <p>
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
 * <p>
 * Example
 * Example1
 * <p>
 * Input: intervals = [(0,30),(5,10),(15,20)]
 * Output: 2
 * Explanation:
 * We need two meeting rooms
 * room1: (0,30)
 * room2: (5,10),(15,20)
 * Example2
 * <p>
 * Input: intervals = [(2,7)]
 * Output: 1
 * Explanation:
 * Only need one meeting room
 * <a href="https://www.lintcode.com/problem/meeting-rooms-ii/description">Meeting Rooms II</a>
 * <p>
 * Created by vencial on 2019-09-13.
 */
public class MeetingRoomsII {

    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (Interval interval : intervals) {
            map.put(interval.start, map.getOrDefault(interval.start, 0) + 1);
            map.put(interval.end, map.getOrDefault(interval.end, 0) - 1);
        }
        int res = 0, mid = 0;
        for (int value : map.values()) {
            res = Math.max(res, mid += value);
        }

        return res;
    }

    // Definition of Interval:
    public class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
