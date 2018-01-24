package amazon;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class DistinctWords {

    public static void main(String[] args) {
        DistinctWords words = new DistinctWords();
        List<String> result = words.subStringsKDist("abcd", 3);
        for (String val : result) {
            System.out.println(val);
        }
    }

    public List<String> subStringsKDist(String inputStr, int num) {
        int start = 0;
        int end = 0;
        Set<Character> set = new HashSet<>(num);
        List<String> result = new LinkedList<>();
        Set<String> contains = new HashSet<>();
        while (true) {
            if (end - start == num) {
                String val = inputStr.substring(start, end);
                if (!contains.contains(val)) {
                    result.add(val);
                    contains.add(val);
                }
                set.remove(inputStr.charAt(start));
                start++;
            } else {
                Character character = inputStr.charAt(end);
                if (!set.contains(character)) {
                    set.add(character);
                    end++;
                } else {
                    set.remove(inputStr.charAt(start));
                    start++;
                }
            }
            if (inputStr.length() - start < num) {
                break;
            }
        }
        return result;
    }

}