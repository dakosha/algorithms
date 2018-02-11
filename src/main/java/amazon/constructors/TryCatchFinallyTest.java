package amazon.constructors;

/**
 * @author Dauren Mussa
 * @since 2/9/18
 */
public class TryCatchFinallyTest {

    public static void main(String[] args) {
        System.out.println(getNumber());
    }

    static int getNumber() {
        try {
            return 10/0;
        } catch (Throwable ex) {
            return 8;
        } finally {
            return 5;
        }
    }

}
