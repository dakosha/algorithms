package kesha;

import java.util.ArrayList;
import java.util.TreeMap;

public class LiteralsCals {

    public static boolean checker2(String m) {
        for (int i = 0; i < m.length() / 2; i++) {
            if (m.charAt(i) != m.charAt(m.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void polyndrom2(String elem) {
        String[] someWords = elem.split("\\s+");
        TreeMap<String, Integer> map = new TreeMap<>();

        for (int i = 0; i < someWords.length; i++) {
            if (checker2(someWords[i])) {
                map.put(someWords[i], map.get(someWords[i]) != null ? map.get(someWords[i]) + 1 : 1);
            }
        }

        for (String key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
    }

    public static void main(String[] args) {
        polyndrom2("AKA AKA AKA KKfKK kfeffrvrffefk AKA aka AKA R#FORFRF enoofn AKA AKA");
    }
}