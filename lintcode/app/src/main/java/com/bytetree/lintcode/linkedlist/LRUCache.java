package com.bytetree.lintcode.linkedlist;

import java.util.HashMap;

/**
 * 134. LRU Cache
 * <p>
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
 * <p>
 * get(key) Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * Finally, you need to return the data from each get.
 * <p>
 * Example
 * Example1
 * <p>
 * Input:
 * LRUCache(2)
 * set(2, 1)
 * set(1, 1)
 * get(2)
 * set(4, 1)
 * get(1)
 * get(2)
 * Output: [1,-1,1]
 * Explanation：
 * cache cap is 2，set(2,1)，set(1, 1)，get(2) and return 1，set(4,1) and delete (1,1)，because （1,1）is the least use，get(1) and return -1，get(2) and return 1.
 * Example 2:
 * <p>
 * Input：
 * LRUCache(1)
 * set(2, 1)
 * get(2)
 * set(3, 2)
 * get(2)
 * get(3)
 * Output：[1,-1,2]
 * Explanation：
 * cache cap is 1，set(2,1)，get(2) and return 1，set(3,2) and delete (2,1)，get(2) and return -1，get(3) and return 2.
 * <p>
 * <a href="https://www.lintcode.com/problem/lru-cache/description">134. LRU Cache</a>
 * <p>
 * Created by vencial on 2019-09-12.
 */
public class LRUCache {

    private HashMap<Integer, Node> mCache;
    private int capacity;
    private int count;
    private Node head;
    private Node tail;
    /*
     * @param capacity: An integer
     */public LRUCache(int capacity) {
        // do intialization if necessary
        mCache = new HashMap<>(capacity);
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
        count = 0;
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        if (mCache.get(key) != null) {
            Node node = mCache.get(key);
            deleteNode(node);
            addNode(node);
            return node.value;
        }

        return -1;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        if (mCache.get(key) != null) {
            Node node = mCache.get(key);
            node.value = value;
            deleteNode(node);
            addNode(node);
        } else {
            Node node = new Node(key, value);
            mCache.put(key, node);
            System.out.println(count + "," + capacity);
            if (count >= capacity) {
                mCache.remove(tail.prev.key);
                deleteNode(tail.prev);
                addNode(node);
            } else {
                addNode(node);
                count++;
            }
        }
    }

    private void addNode(Node node) {
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    private void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
