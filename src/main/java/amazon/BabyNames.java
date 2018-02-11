package amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Dauren Mussa
 * @since 2/6/18
 */
public class BabyNames {

    public static void main(String[] args) {
        String[][] dictionary = {
                {"Jonathan", "John"},
                {"Joh", "Johnny"},
                {"Johnny", "John"},
                {"Kari", "Carrie"},
                {"Carleton", "Carlton"}
        };

        Map<String, Integer> map = new HashMap<>();
        map.put("John", 10);
        map.put("Joh", 3);
        map.put("Davis", 2);
        map.put("Kari", 3);
        map.put("Johnny", 11);
        map.put("Carlton", 8);
        map.put("Carleton", 2);
        map.put("Jonathan", 9);
        map.put("Carrie", 5);

        Set<String> val1 = null;
        Set<String> val2 = null;

        if (val1 != val2) {
            System.out.println("NULL not equals to NULL");
        }

        System.out.println(countNames(map, dictionary));
    }

    static Map<String, Counter> createMap(String[][] dictionary) {
        Map<String, Counter> result = new HashMap<>();

        for (int i = 0; i < dictionary.length; i++) {
            String first = dictionary[i][0];
            String second = dictionary[i][1];

            Counter counter = result.get(first);
            if (counter == null) {
                Counter c = new Counter();
                result.put(first, c);
                result.put(second, c);
            }
        }

        return result;
    }

    static Map<String, Integer> countNames(Map<String, Integer> map, String[][] dictionary) {


        return null;
    }

    static class Counter {
        int count;
    }

}
