package ru.ifmo.collections;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Represents LRU cache with fixed maximum capacity.
 * <p>
 * get() should return null if there is no value for a given key.
 * elements() should return number of elements in cache.
 * <p>
 * This class should not have any other public methods.
 * <p>
 * Implementing this cache in (almost) the same manner as it was implemented during the lecture will result in extra points.
 */
public class LruCache<K, V> {
    private final int capacity;
    private final Map<K, V> data = new HashMap<>();
    final LinkedList<K> usedQueue = new LinkedList<>();

    public LruCache(int capacity) {
        this.capacity = capacity;
    }

    public V get(K key) {
        updateLastUsedElement(key);
        return data.get(key);
    }

    public void put(K key, V value) {
        if (elements() == capacity) {
            data.remove(usedQueue.getFirst());
            usedQueue.removeFirst();
        }
        updateLastUsedElement(key);
        data.put(key, value);
    }

    public int elements() {
        return data.size();
    }

    private void updateLastUsedElement(K key) {
        usedQueue.remove(key);
        usedQueue.add(key);
    }
}