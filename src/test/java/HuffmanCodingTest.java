import org.example.HuffmanCoding;
import org.example.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class HuffmanCodingTest {

    @Test
    public void testEncodeAndDecode() {
        // Test input
        String text = "#1. A SIMPLE STRING TO BE ENCODED USING A MINIMAL NUMBER OF BITS #2. a simple string to be encoded using a minimal number of bits";

        // Create tree and encoded values from provided text
        HashMap<Character, String> encodedValues = new HashMap<>();
        Node root = HuffmanCoding.createTree(text);


        // Create encoded text
        HuffmanCoding.encodeText(root, "", encodedValues);
        StringBuilder encodedText = new StringBuilder();
        for (Character ch : text.toCharArray()) {
            encodedText.append(encodedValues.get(ch));
        }

        // Decode text
        String decodedText = HuffmanCoding.decode(root, String.valueOf(encodedText));

        // Match native text with decoded text
        Assertions.assertEquals(text, decodedText);

    }
}

