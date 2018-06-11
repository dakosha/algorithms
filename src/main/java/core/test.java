package core;

/**
 * @author Dauren Mussa
 * @since 6/2/18
 */
public class test {

    public static void main(String[] args) {
        int i=1;
        if (i++ == --i) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }

}
