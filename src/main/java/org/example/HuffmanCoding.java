package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanCoding {

    public static void encodeText(Node node, String prefix, HashMap<Character, String> encodedValues) {
        // If the node is null, return
        if (node == null) {
            return;
        }

        // If the node is a leaf, store its character and prefix in the encodedValues map
        if (node.isLeaf()) {
            encodedValues.put(node.getCharacter(), prefix);
        } else {
            // If the node is not a leaf node, recursively call encodeText for its left and right children
            // Append "0" to the prefix when traversing the left child, and "1" when traversing the right child
            encodeText(node.left, prefix + "0", encodedValues);
            encodeText(node.right, prefix + "1", encodedValues);
        }
    }


    // Decode provided encoded text by using Huffman tree, then return it
    public static String decode(Node root, String encodedText) {
        StringBuilder decoded = new StringBuilder();
        Node currentNode = root;
        for (char bit : encodedText.toCharArray()) {
            if (bit == '0') {
                currentNode = currentNode.left;
            } else if (bit == '1') {
                currentNode = currentNode.right;
            }
            if (currentNode.isLeaf()) {
                decoded.append(currentNode.getCharacter());
                currentNode = root;
            }
        }
        return decoded.toString();
    }



    //Create Huffman tree and return root node
    public static Node createTree(String text) {
        // Count each letter in text
        Map<Character, Integer> charCount = new HashMap<>();
        for (char ch : text.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }

        // Creating queue that will store nodes in order
        NodeComparator nodeComparator = new NodeComparator();
        PriorityQueue<Node> nodes = new PriorityQueue<>(charCount.size(), nodeComparator);
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            Node node = new Node(entry.getKey(), entry.getValue());
            nodes.add(node);
        }

        // Build the Huffman tree
        while (nodes.size() > 1) {
            // Get the two nodes with the lowest frequencies
            Node leftChild = nodes.poll();
            Node rightChild = nodes.poll();

            // Create a parent node with the combined frequency
            Node parent = new Node(leftChild.getFrequency() + rightChild.getFrequency());
            parent.left = leftChild;
            parent.right = rightChild;

            // Add the parent node back to the priority queue
            nodes.add(parent);
        }

        // Return the root node of the Huffman tree
        return nodes.poll();
    }
}
