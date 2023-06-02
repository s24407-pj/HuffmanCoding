package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input text that consist of a-z
        System.out.print("Enter text to compress and press ENTER to confirm: ");
        String text = scanner.nextLine();

        // Encode provided text
        HashMap<Character,String> encodedValues = new HashMap<>();
        Node root = HuffmanCoding.createTree(text);
        HuffmanCoding.encodeText(root,"",encodedValues);

        //
        StringBuilder encodedText = new StringBuilder();
        for(Character ch : text.toCharArray()){
            encodedText.append(encodedValues.get(ch));
        }
        System.out.println("Encoded text: " + encodedText);
        System.out.println("Decoded text: " + HuffmanCoding.decode(root, String.valueOf(encodedText)));

    }
}