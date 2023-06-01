package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanCoding {
    // Returns map with chars and assigned encoded values
    public static HashMap<Character, String> encodeText(String text) {
        final Node rootNode = createTree(text);

        return null;
    }
    // Decode provided encoded text by using Huffman tree, then return it
    public static String decode(Node root, String encodedText){
        StringBuilder decoded = new StringBuilder();
        Node currentNode = root;
        // Iterate for every char in encoded text, then append found char in tree
        for(char ch : encodedText.toCharArray()){
            // If 0 go left, if 1 go right in tree
            if(ch == '0'){
                // If current node is leaf get char and change current node to root,
                // if it's not change current node to child node
                if(currentNode.left.isLeaf()){
                    decoded.append(currentNode.left.getCharacter());
                    currentNode = root;
                }else{
                    currentNode = currentNode.left;
                }
            }else{
                if(currentNode.right.isLeaf()){
                    decoded.append(currentNode.right.getCharacter());
                    currentNode = root;
                }else{
                    currentNode = currentNode.right;
                }
            }
        }
        return decoded.toString();
    }


    //Create Huffman tree and return root node
    private static Node createTree(String text) {
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

        // Node that will be the last in queue
        Node rootNode = null;

        // Loop until only root node will in queue
        while (nodes.size() > 1) {
            // Get the minimal nodes,then delete them
            Node firstNode = nodes.poll();
            Node secondNode = nodes.poll();

            // Node parent with sum of frequencies
            assert secondNode != null;
            Node parent = new Node(firstNode.getFrequency() + secondNode.getFrequency());

            // If both frequencies are equal and first node is not a leaf, swap first node with second node
            if (firstNode.getFrequency() == secondNode.getFrequency() && !firstNode.isLeaf()) {
                Node temp = firstNode;
                firstNode = secondNode;
                secondNode = temp;
            }
            // Set parent as root node and assign left and right node, then insert parent as node into the queue
            rootNode = parent;
            parent.left = firstNode;
            parent.right = secondNode;
            nodes.add(parent);
        }
        return rootNode;
    }
}
