package com.bytetree.lintcode.linkedlist;

/**
 * 165. Merge Two Sorted Lists
 * <p>
 * Merge two sorted (ascending) linked lists and return it as a new sorted list. The new sorted list should be made by splicing together the nodes of the two lists and sorted in ascending order.
 * <p>
 * Example
 * Example 1:
 * Input: list1 = null, list2 = 0->3->3->null
 * Output: 0->3->3->null
 * <p>
 * <p>
 * Example 2:
 * Input:  list1 =  1->3->8->11->15->null, list2 = 2->null
 * Output: 1->2->3->8->11->15->null
 * <p>
 * <a href="https://www.lintcode.com/problem/merge-two-sorted-lists/description">165. Merge Two Sorted Lists</a>
 * <p>
 * Created by vencial on 2019-10-10.
 */
public class MergeTwoSortedLists {

    /**
     * @param l1: ListNode l1 is the head of the linked list
     * @param l2: ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
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
