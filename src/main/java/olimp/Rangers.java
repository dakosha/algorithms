package olimp;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Dauren Mussa
 * @since 4/23/17
 */
public class Rangers {

    //Black - last left
    //Red - first left
    //Blue - first right
    //Yellow - last right
    //Pink - anywhere

    private static int leftMask = 0x40000000;
    private static int rightMask = 0x3fffffff;


    public static void main(String[] args) throws IOException {
        System.out.println(leftMask);
        System.out.println(rightMask);

        FileInputStream stream = new FileInputStream("input.txt");
        Scanner scanner = new Scanner(stream);
        Integer n = scanner.nextInt();
        Integer k = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            Integer x = scanner.nextInt();
            Integer y = scanner.nextInt();
        }
    }

}
