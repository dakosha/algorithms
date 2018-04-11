package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Dauren Mussa
 * @since 2/17/18
 */
public class TextJustification {

    public static void main(String[] args) {
        //String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        String[] words = {"a", "b", "c", "d", "e"};
        int L = 1;

        TextJustification textJustification = new TextJustification();
        List<String> result = textJustification.fullJustify(words, L);

        for (String value : result) {
            System.out.println(value);
        }
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new LinkedList<>();

        int index = 0;
        List<String> line = new LinkedList<>();
        int lineLength = 0;
        while (index < words.length) {
            String currentWord = words[index];

            if (lineLength + currentWord.length() + line.size() <= maxWidth) {
                lineLength += currentWord.length();
                line.add(currentWord);
                index++;
            } else {
                int spaces = maxWidth - lineLength;
                int div = 0;
                int mod = 0;
                if (line.size() > 1) {
                    div = spaces / (line.size() - 1);
                    mod = spaces % (line.size() - 1);
                }

                String spacesAppend = "";
                for (int i = 0; i < div; i++) {
                    spacesAppend += " ";
                }

                StringBuilder st = new StringBuilder();

                for (int i = 0; i < line.size(); i++) {
                    st.append(line.get(i));
                    if (i < line.size() - 1) {
                        st.append(spacesAppend);
                    }
                    if (mod != 0) {
                        st.append(" ");
                        mod -= 1;
                    }
                }

                while (st.length() < maxWidth) {
                    st.append(" ");
                }

                result.add(st.toString());

                lineLength = 0;
                line = new LinkedList<>();

            }

            if (index == words.length) {
                StringBuilder st = new StringBuilder();
                for (int i = 0; i < line.size(); i++) {
                    st.append(line.get(i));
                    if (i < line.size() - 1) {
                        st.append(" ");
                    }
                }
                while (st.length() < maxWidth) {
                    st.append(" ");
                }

                result.add(st.toString());
            }

        }


        return result;
    }

}
