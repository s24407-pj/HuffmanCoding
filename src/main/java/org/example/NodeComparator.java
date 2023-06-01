package org.example;

import java.util.Comparator;

public class NodeComparator implements Comparator<Node> {
    @Override
    public int compare(Node firstNode, Node secondNode) {

        // If leafs have different values, return the difference in their frequencies
        // If the difference is positive, prioritize the first node
        // If the difference is negative, prioritize the second node
        if (firstNode.getFrequency() != secondNode.getFrequency())
            return firstNode.getFrequency() - secondNode.getFrequency();
            // If leafs have the same value and secondNode is not a leaf, prioritize second node
        else if (firstNode.isLeaf() && !secondNode.isLeaf())
            return 1;
            // If leafs have the same value and first node is not a leaf, prioritize first node
        else if (secondNode.isLeaf() && !firstNode.isLeaf())
            return -1;
            // If both are leafs, return the difference in their character values(alphabet order)
        else if (firstNode.isLeaf() && secondNode.isLeaf())
            return firstNode.getCharacter() - secondNode.getCharacter();
            // Default case: prioritize first node
        else
            return -1;
    }
}
