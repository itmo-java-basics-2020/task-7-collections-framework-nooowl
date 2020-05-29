package ru.ifmo.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Design a class which contains integers and returns first unique integer (in order of addition).
 * FirstUniqueTest can be used as an example.
 */
public class FirstUnique {
    private final List<Integer> array = new ArrayList<>();
    private final Set<Integer> allNumbers = new HashSet<>();
    private final Set<Integer> uniqueNumbers = new HashSet<>();
    private int firstUniqueNumber = 0;

    public FirstUnique(int[] numbers) {
        for (int number : numbers) {
            add(number);
        }
        findFirstUniqueNumber();
    }

    public int showFirstUnique() {
        findFirstUniqueNumber();
        return firstUniqueNumber == array.size() ? -1 : array.get(firstUniqueNumber);
    }

    public void add(int value) {
        array.add(value);
        if (allNumbers.contains(value)) {
            uniqueNumbers.remove(value);
        } else {
            allNumbers.add(value);
            uniqueNumbers.add(value);
        }
    }

    private void findFirstUniqueNumber() {
        for (; firstUniqueNumber < array.size(); firstUniqueNumber++) {
            if (uniqueNumbers.contains(array.get(firstUniqueNumber))) {
                return;
            }
        }
        firstUniqueNumber = array.size();
    }
}
