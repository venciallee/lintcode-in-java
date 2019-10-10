package com.bytetree.lintcode.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * 104. Merge K Sorted Lists
 * <p>
 * Merge k sorted linked lists and return it as one sorted list.
 * <p>
 * Analyze and describe its complexity.
 * <p>
 * Example
 * Example 1:
 * Input:   [2->4->null,null,-1->null]
 * Output:  -1->2->4->null
 * <p>
 * Example 2:
 * Input: [2->6->null,5->null,7->null]
 * Output:  2->5->6->7->null
 * <p>
 * <a href="https://www.lintcode.com/problem/merge-k-sorted-lists/description">104. Merge K Sorted Lists</a>
 * <p>
 * Created by vencial on 2019-10-10.
 */
public class MergeKSortedLists {

    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        // write your code here
        int size = lists.size();
        if (size == 0) {
            return null;
        } else if (size == 1) {
            return lists.get(0);
        } else if (size == 2) {
            return merge2Lists(lists.get(0), lists.get(1));
        }

        int mid = size / 2;
        List<ListNode> leftList = new ArrayList<>();
        List<ListNode> rightList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (i < mid) {
                leftList.add(lists.get(i));
            } else {
                rightList.add(lists.get(i));
            }
        }

        return merge2Lists(mergeKLists(leftList), mergeKLists(rightList));

    }

    private ListNode merge2Lists(ListNode l1, ListNode l2) {

        ListNode dumppy = new ListNode(0);
        ListNode next = dumppy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                next.next = l1;
                l1 = l1.next;
            } else {
                next.next = l2;
                l2 = l2.next;
            }
            next = next.next;
        }

        next.next = null;
        if (l1 != null) {
            next.next = l1;
        }
        if (l2 != null) {
            next.next = l2;
        }
        return dumppy.next;
    }
}
