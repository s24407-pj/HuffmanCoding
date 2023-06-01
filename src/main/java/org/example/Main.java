package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input text that consist of a-z
        System.out.print("Enter text to compress and press ENTER to confirm: ");
        String text = scanner.nextLine().toLowerCase().replaceAll("[^a-z]", "");

        // Count each letter in text
        Map<Character, Integer> letterCount = new HashMap<>();
        for (char ch : text.toCharArray()) {
            letterCount.put(ch, letterCount.getOrDefault(ch, 0) + 1);
        }

        // Create MinHeap
        PriorityQueue<Map.Entry<Character, Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        minHeap.addAll(letterCount.entrySet());


        // Display variables
        System.out.println("minheap " + minHeap);
        System.out.println("text " + text);
        System.out.println("letterCount " + letterCount);
        System.out.println(minHeap.getClass());
    }
}