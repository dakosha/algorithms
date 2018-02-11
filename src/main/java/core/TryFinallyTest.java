package core;

/**
 * @author Dauren Mussa
 * @since 2/9/18
 */
public class TryFinallyTest {

    public static void main(String[] args) {
        System.out.println(getNumber());
    }

    static int getNumber() {
        try {
            return 10;
        } finally {
            return 5;
        }
    }

}
