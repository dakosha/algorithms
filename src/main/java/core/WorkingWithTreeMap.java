package core;

import java.util.TreeMap;

/**
 * @author Dauren Mussa
 * @since 2/11/18
 */
public class WorkingWithTreeMap {

    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        map.put(1,1);

        map.put(2,2);

        map.put(3,3);

        System.out.println(map);
    }

}
