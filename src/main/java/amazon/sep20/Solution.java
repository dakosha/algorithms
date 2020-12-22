package amazon.sep20;

        import com.google.common.collect.Lists;

        import java.util.ArrayList;
        import java.util.Collections;
        import java.util.List;

public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.prioritizedOrders(6, Lists.newArrayList("zld 93 12",
                "fp kindle book", "10a echo show", "17g 12 25 6",
                "ab1 kindle book", "125 echo dot second generation"));
    }

    public List<String> prioritizedOrders(int numOrders, List<String> orderList) {

        List<String> primeOrders = new ArrayList<>();
        List<String> nonPrime = new ArrayList<>();

        for (String order : orderList) {

            String[] tokens = order.split(" ");
            boolean flag = true;
            for (int i=1; i<tokens.length; i++) {
                try {
                    Integer.valueOf(tokens[i]);
                } catch (Exception ex) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                nonPrime.add(order);
            } else {
                primeOrders.add(order);
            }

            Collections.sort(nonPrime);
            Collections.sort(primeOrders);

            primeOrders.addAll(nonPrime);

        }

        return primeOrders;
    }

}