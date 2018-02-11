package amazon;

/**
 * @author Dauren Mussa
 * @since 2/3/18
 */
public class Multiplier {

    public static void main(String[] args) {
        int a = 12, b = 15;
        System.out.println(minProduct(a, b));
    }

    static int minProduct(int a, int b) {
        int bigger = a < b ? b : a;
        int smaller = a < b ? a : b;
        return minProductHelper(smaller, bigger);
    }

    static int minProductHelper(int smaller, int bigger) {
        if (smaller == 0) return 0;
        else if (smaller == 1) return bigger;

        int s = smaller >> 1;
        int halfProd = minProductHelper(s, bigger);

        if (smaller % 2 == 0) {
            return halfProd + halfProd;
        } else {
            return halfProd + halfProd + bigger;
        }
    }

}
