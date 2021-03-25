package com.mylearning.problems.v1.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

  public static void main(String[] args) {
    LRUCache l = new LRUCache(1);
    l.put(2, 1);
   // l.put(2, 2);
    System.out.println(l.get(2));
    l.put(3, 2);
    System.out.println(l.get(2));
    //l.put(4, 4);
    //System.out.println(l.get(1));
    System.out.println(l.get(3));
    //System.out.println(l.get(4));
  }

  Node head;
  Node tail;
  int capacity;
  int count = 0;
  Map<Integer, Node> map = new HashMap<>();

  public LRUCache(int capacity) {
    this.capacity = capacity;
  }

  public int get(int key) {
    if (!map.containsKey(key)) return -1;
    Node node = map.get(key);
    int result = node.val;
    remove(node);
    add(node);
    return result;
  }

  public void put(int key, int data) {
    if (map.containsKey(key)) {
      Node node = map.get(key);
      node.val = data;
      remove(node);
      add(node);
    } else {
      Node node = new Node(key, data);
      map.put(key, node);
      if (map.size() > capacity) {
        if (tail.prev != null) {
          map.remove(tail.prev.next.key);
          remove(tail.prev.next);
        } else {
          map.remove(tail.key);
          remove(tail);
        }
      }
      add(node);
    }
  }

  private void add(Node node) {
    if (head == null) tail = node;
    else {
      node.next = head;
      head.prev = node;
      if (node.prev != null) node.prev = null;
    }
    head = node;
  }

  private void remove(Node node) {
    if (node.prev != null) node.prev.next = node.next;
    else head = node.next;
    if (node.next != null) node.next.prev = node.prev;
    else tail = node.prev;
  }
}
