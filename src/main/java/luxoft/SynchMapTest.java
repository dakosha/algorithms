package luxoft;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Dauren Mussa
 * @since 1/30/18
 */
public class SynchMapTest {

    public static void main(String[] args) {
        Map<String, String> map = Collections.synchronizedMap(new HashMap<>());

        for (int i=0; i<100; i++) {
            map.put(String.valueOf(i), String.valueOf(i));
        }

        for (String key : map.keySet()) {
            map.remove(key);
        }


    }

}
