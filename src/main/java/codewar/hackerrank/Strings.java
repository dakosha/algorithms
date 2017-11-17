package codewar.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Dauren Mussa
 * @since 5/15/17
 */
public class Strings {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        Map<String, Integer> map = new HashMap<>();
        //String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            String key = scanner.next();
            Integer count = map.get(key);
            if (count == null || count == 0) {
                map.put(key, 1);
            }
            else {
                map.put(key, count+1);
            }
        }

        Integer m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            String key = scanner.next();
            Integer count = map.get(key);
            if (count != null) {
                System.out.println(count);
            }
            else {
                System.out.println(0);
            }
        }


    }

}
