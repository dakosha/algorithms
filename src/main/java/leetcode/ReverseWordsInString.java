package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Dauren Mussa
 * @since 5/15/18
 */
public class ReverseWordsInString {

    public static void main(String[] args) {
        ReverseWordsInString reverseWordsInString = new ReverseWordsInString();

        String val = "My name is Dauren";

        String result = reverseWordsInString.reverseWords(val);

        System.out.println(result);

        result = reverseWordsInString.reverseWords2(val);

        System.out.println(result);
    }

    public String reverseWords(String s) {
        List<String> words = new ArrayList<>();
        s = s + " ";

        String word = "";
        for (int i = 0; i < s.length(); i++) {
            char sym = s.charAt(i);
            if (sym != ' ') {
                word += sym;
            } else {
                if (word.trim().length() > 0) {
                    words.add(word);
                    word = "";
                }
            }
        }

        StringBuilder st = new StringBuilder();
        for (int i=words.size()-1; i>=0; i--) {
            st.append(words.get(i));
            st.append(" ");
        }

        return st.toString().trim();
    }

    public String reverseWords2(String s) {
        String[] words = s.split(" ");

        StringBuilder st = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i].trim().length() > 0) {
                st.append(words[i]);
                st.append(" ");
            }
        }

        return st.toString().trim();

    }

}
