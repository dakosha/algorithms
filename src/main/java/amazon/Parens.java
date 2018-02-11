package amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Dauren Mussa
 * @since 2/3/18
 */
public class Parens {

    static String base = "()";
    static Set<String> baseSet = new LinkedHashSet<>();
    static Map<Integer, Set<String>> map = new HashMap<>();

    static {
        baseSet.add(base);
        map.put(1, baseSet);
    }

    public static void main(String[] args) {
        int n = 10;

        long time1 = System.nanoTime();
        System.out.println(getParens(n));
        System.out.println(System.nanoTime() - time1);

        time1 = System.nanoTime();
        System.out.println(generateParens(n));
        System.out.println(System.nanoTime() - time1);
    }

    public static Set<String> getParens(int n) {
        Set<String> fromMap = map.get(n);
        if (fromMap == null) {
            Set<String> previous = getParens(n - 1);

            Set<String> variants = new LinkedHashSet<>();
            for (String word : previous) {
                variants.addAll(getVariations(word));
            }

            map.put(n, variants);

            fromMap = variants;
        }
        return fromMap;
    }

    public static Set<String> getVariations(String parens) {
        Set<String> result = new LinkedHashSet<>();
        for (int i = 0; i < parens.length(); i++) {
            String newW = parens.substring(0, i) + base + parens.substring(i, parens.length());
            result.add(newW);
        }
        result.add(parens + base);
        return result;
    }

    static void addParen(ArrayList<String> list, int leftRem, int rightRem, char[] str, int index) {
        if (leftRem < 0 || rightRem < leftRem) return;// invalid state
        if (leftRem == 0 && rightRem == 0) {/*Out of left and right parentheses */
            list.add(String.copyValueOf(str));
        } else {
            str[index] = '('; // Add left and recurse
            addParen(list, leftRem - 1, rightRem, str, index + 1);

            str[index] = ')'; // Add right and recurse
            addParen(list, leftRem, rightRem - 1, str, index + 1);
        }
    }

    static ArrayList<String> generateParens(int count) {
        char[] str = new char[count * 2];
        ArrayList<String> list = new ArrayList<String>();
        addParen(list, count, count, str, 0);
        return list;
    }

}
