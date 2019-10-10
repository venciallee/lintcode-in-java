package com.bytetree.lintcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. Copy List with Random Pointer
 * <p>
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * <p>
 * Return a deep copy of the list.
 * <p>
 * <a href="https://www.lintcode.com/problem/copy-list-with-random-pointer/description">105. Copy List with Random Pointer</a>
 * <p>
 * Created by vencial on 2019-10-10.
 */
public class CopyListwithRandomPointer {

    private Map<RandomListNode, RandomListNode> map = new HashMap<>();

    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if (head == null) return null;
        if (map.containsKey(head)) return map.get(head);
        RandomListNode node = new RandomListNode(head.label);
        map.put(head, node);
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);

        return node;
    }
}

class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
}
