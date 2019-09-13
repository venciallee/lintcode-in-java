package com.bytetree.lintcode.linkedlist;

/**
 * 35. Reverse Linked List
 * <p>
 * Reverse a linked list.
 * <p>
 * Example
 * Example 1:
 * <p>
 * Input: 1->2->3->null
 * Output: 3->2->1->null
 * Example 2:
 * <p>
 * Input: 1->2->3->4->null
 * Output: 4->3->2->1->null
 * Challenge
 * Reverse it in-place and in one-pass
 * <p>
 * <a href="https://www.lintcode.com/problem/reverse-linked-list/description">35. Reverse Linked List</a>
 * <p>
 * Created by vencial on 2019-09-11.
 */
public class ReverseLinkedList {

    /**
     * @param head: n
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        if (head == null) return null;
        ListNode tail = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = tail;
            tail = head;
            head = next;
        }
        return tail;
    }
}
