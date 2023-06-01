package org.example;

public class Node {
    private final int frequency;
    private Character character = null;
    public Node left = null;
    public Node right = null;

    public Node(Character character, int frequency) {
        this.frequency = frequency;
        this.character = character;
    }

    // Internal node with frequency only
    public Node(int frequency) {
        this.frequency = frequency;
    }

    // Not internal node
    public boolean isLeaf() {
        return character != null;
    }

    public int getFrequency() {
        return frequency;
    }

    public Character getCharacter() {
        return character;
    }
}
