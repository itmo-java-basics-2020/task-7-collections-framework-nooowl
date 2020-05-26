package ru.ifmo.collections;

import java.util.PriorityQueue;

/**
 * Design a class to find the kth largest element in a stream. k is from 1 to numbers.length.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Constructor accepts an integer k and an integer array numbers, which contains initial elements from the stream.
 * For each call to the method KthLargest.add(), return the element representing the kth largest element in the stream.
 */
@SuppressWarnings("ConstantConditions")
public class KthLargest {
    private final PriorityQueue<Integer> queue = new PriorityQueue<>();
    private int currentElement = 0;

    public KthLargest(int k, int[] numbers) {
        for (int number : numbers) {
            queue.add(number);
        }
        cutQueue(k);
    }

    public int add(int val) {
        if (val > currentElement) {
            queue.add(val);
            queue.poll();
        }
        currentElement = queue.peek();
        return currentElement;
    }

    private void cutQueue(int k) {
        while (queue.size() > k) {
            queue.poll();
        }
        currentElement = queue.peek();
    }
}