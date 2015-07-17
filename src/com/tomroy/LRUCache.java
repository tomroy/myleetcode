package com.tomroy;

import java.util.*;

/**
 * Created by tom_th_lin on 2015/6/1. <br>
 * https://leetcode.com/problems/lru-cache/ <br>
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
 * <br>get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * <br>set(key, value) - Set or insert the value if the key is not already present.
 * <br>When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *<br><br>
 * a good design thinking of LRU cache<br>
 * http://songlee24.github.io/2015/05/10/design-LRU-Cache/
 */

public class LRUCache {

    HashMap<Integer, ListNode> map;
    ListNode head;
    ListNode tail;
    int capacity;
    int count;

    public class ListNode {

        Integer key;
        Integer value;
        ListNode next;
        ListNode prev;

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Integer getKey() {
            return key;
        }

        public void setKey(Integer key) {
            this.key = key;
        }

        ListNode() {
            key = null;
            value = null;
            next = null;
            prev = null;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.head = new ListNode();
        this.tail = new ListNode();
        this.map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        ListNode node = map.get(key);
        if(node != null) {      //找到
            detachNode(node);
            insertToFront(node);
            return node.getValue();
        } else {                //找不到
            return -1;
        }
    }

    public void set(int key, int value) {
        ListNode node = map.get(key);
        if(node != null) {     //找到
            node.setValue(value);
            detachNode(node);
            insertToFront(node);
        } else {                //找不到
            if(count == capacity)
                removeLRUNode();
            ListNode nodeNew = new ListNode();
            nodeNew.setKey(key);
            nodeNew.setValue(value);
            insertToFront(nodeNew);
            map.put(key,nodeNew);
            ++count;
        }
    }

    private void detachNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertToFront(ListNode node) {
        node.prev = head;
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
    }

    private void removeLRUNode() {
        ListNode LRUnode = tail.prev;
        detachNode(LRUnode);
        map.remove(LRUnode.getKey());
        --count;
    }
    public void printAll() {
        for(Map.Entry<Integer, ListNode> e : map.entrySet()) {
            System.out.println("("+e.getKey()+ "," +e.getValue().getValue() + ")");
        }
    }


    public static void main(String[] args) {
        LRUCache cache = new LRUCache(5);
        cache.set(0,0);
        cache.set(1,111);
        cache.set(2,222);
        System.out.println(cache.get(0));
        System.out.println(cache.get(1));
        cache.set(3, 333);
        System.out.println(cache.get(11));
        System.out.println(cache.get(9));
        cache.set(4, 444);
        cache.set(5, 555);
        cache.set(6, 666);
        System.out.println(cache.get(1));
        cache.set(7, 777);
        cache.printAll();
    }
}