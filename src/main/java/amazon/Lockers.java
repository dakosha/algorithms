package amazon;

/**
 * @author Dauren Mussa
 * @since 1/25/18
 */
public class Lockers {

    public static void main(String[] args) {

        int n=60;

        boolean[] array = new boolean[n];

        for (int i=0; i<n; i++) {

            for (int j=0+i; j<n; j+=(1 + i)) {
                array[j] = !array[j];
            }

            for (int j=0; j<n; j++) {
                System.out.print(array[j] ? "1" : "0");
            }
            System.out.println();
        }
    }

}
