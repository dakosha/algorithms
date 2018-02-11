package amazon;

/**
 * @author Dauren Mussa
 * @since 1/30/18
 */
public class CountOf2s {

    public static void main(String[] args) {
        int n = 22222;

        int total = 0;
        for (int i = 2; i <= n; i++) {
            int subTotal = 0;
            int r = i;
            while (r > 0) {
                if (r % 10 == 2) {
                    subTotal++;
                }
                r = r / 10;
            }
            total += subTotal;
            System.out.println("for number: " + i + " - " + subTotal + " 2s, total = " + total);
        }

        System.out.println(total);

        System.out.println(count2s(n, 2));

    }

    static int count2s(int n, int digit) {
        int count = 0;
        int number = n;
        int pow = 0;

        while (number > 0) {
            int numPow = (int) Math.pow(10, pow);
            int multiplier = number / 10;
            int tempCount = (int) (multiplier * numPow);
            int nn = number % 10;
            if (nn > digit) {
                tempCount += numPow;
            } else if (nn < digit) {
                //
            } else {
                tempCount += numPow - (numPow - n % numPow)+1;
            }

            count += tempCount;

            pow++;

            number = number / 10;
        }

        return count;
    }

}
