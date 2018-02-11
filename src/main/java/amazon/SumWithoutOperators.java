package amazon;

/**
 * @author Dauren Mussa
 * @since 1/29/18
 */
public class SumWithoutOperators {

    public static void main(String[] args) {
        int a = 4;
        int b = 5;
        System.out.println(add(a, b));
    }

    public static int sum(int a, int b) {
        int res = 0;
        int restemp = 0;

        int add = 0;
        while (a > 0 || b > 0) {
            int a1 = a & 0x1;
            int b1 = b & 0x1;

            int next = 0;
            int r1 = a1 & b1;
            int r2 = a1 | b1;

            if (r1 == r2 && r1 == 1) {
                next = 0;
                if (add == 1) {
                    next = 1;
                    add = 1;
                } else {
                    next = 0;
                    add = 1;
                }
            } else if (r1 == r2 && r1 == 0) {
                next = 0;
                add = 0;
            } else {
                next = 1 & add;
                if (next == 1) {
                    next = 0;
                    add = 1;
                } else {
                    next = 1;
                    add = 0;
                }
            }

            System.out.println(a1 + " " + b1 + "; next=" + next + "; add=" + add);

            restemp = (restemp | next) << 1;

            a = a >> 1;
            b = b >> 1;

            //System.out.println(restemp);
        }
        if (add > 0) {
            restemp = restemp | add;
        }
        //System.out.println(restemp);
        System.out.println(restemp);

        do {
            int n = restemp & 0x1;
            //System.out.println(n);
            res = res | n;
            res = res << 1;
            restemp = restemp >> 1;
        } while (restemp > 0);
        res = res >> 1;

        return res;
    }

    static int add(int a, int b) {
        if (b == 0) return a;
        int sum = a ^ b;// add without carrying
        int carry = (a & b) << 1; // carry, but don't add

        return add(sum, carry); // recurse with sum + carry
    }

}
