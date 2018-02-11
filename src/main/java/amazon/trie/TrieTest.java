package amazon.trie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * @author Dauren Mussa
 * @since 2/11/18
 */
public class TrieTest {

    public static void main(String[] args) throws IOException {
        TrieNode root = new TrieNode();

        File file = new File("text_file");
        if (file.exists()) {

            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String word = bufferedReader.readLine();
            while (word != null) {
                root.insertWord(word);
                word = bufferedReader.readLine();
            }

            List<String> words = root.findWordsWithPrefix("cac");
            System.out.println("Total: " + words.size());

            for (String value : words) {
                System.out.println(value);
            }

        } else {
            file.createNewFile();
        }

    }

}
