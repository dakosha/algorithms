package crossover;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @author Dauren Mussa
 * @since 6/2/18
 */
public class TestDecimalFormat {

    private static final DecimalFormat decimalFormat = new DecimalFormat("######.######");

    public static void main(String[] args) {
        double value = 0.123456;
        double value2 = 0.123123123;

        String val = decimalFormat.format(value);
        String val2 = decimalFormat.format(value2);

        String vall = String.valueOf(value);
        String vall2 = String.valueOf(value2);

        System.out.println(val);
        System.out.println(val2);

        System.out.println(vall);
        System.out.println(vall2);
    }

}
