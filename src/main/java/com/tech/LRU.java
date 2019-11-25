package com.tech;

import java.util.HashMap;
import java.util.Map;

public class LRU<K, V> {

    private Integer capacity;
    private Node<K, V> first;
    private Node<K, V> last;
    private Map<K, Node<K, V>> caches = new HashMap<>();

    public LRU(int capacity) {
        this.capacity = capacity;
    }

    public Node get(K k) {
        final Node<K, V> node = caches.get(k);
        if (node != null) {
            moveToFirst(node);
        }
        return node;
    }

    public boolean put(K k, V v) {
        if (this.caches.size() >= this.capacity) {
            this.removeLast();
        }
        Node<K, V> node = caches.get(k);
        if (node == null) {
            node = new Node<>();
            node.key = k;
        }
        node.value = v;
        caches.put(k, node);
        if (first == null) {
            first = node;
        }
        if (last == null) {
            last = node;
        }

        moveToFirst(node);
        return true;
    }

    public boolean remove(K k) {
        final Node node = caches.get(k);
        if (node == null) {
            return false;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node == first) {
            first = first.next;
        }
        if (node == last) {
            last = last.prev;
        }
        caches.remove(k);
        return true;
    }

    private void moveToFirst(Node<K, V> node) {
        if (node == first) {
            return;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (node.prev != null) {
            node.prev.next = node.prev;
        }
        if (node == last) {
            last = last.prev;
        }

        node.next = first;
        first.prev = node;
        first = node;
        first.prev = null;
    }

    private void removeLast() {
        this.remove(last.key);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node node = first;
        while (node != null) {
            sb.append(String.format("%s:%s ", node.key, node.value));
            node = node.next;
        }
        return sb.toString();
    }


    private static class Node<K, V> {

        private Node<K, V> prev;
        private Node<K, V> next;
        private K key;
        private V value;

    }
}
