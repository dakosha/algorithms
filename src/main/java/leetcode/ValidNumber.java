package leetcode;

/**
 * @author Dauren Mussa
 * @since 11/15/17
 */
public class ValidNumber {

    public static void main(String[] args) {
        ValidNumber validNumber = new ValidNumber();
        String value = "asdf";
        String value2 = "0.1";

        System.out.println(validNumber.isNumber(value));
        System.out.println(validNumber.isNumber(value2));
    }

    public boolean isNumber(String s) {
        try {
            String ss = s.trim();
            if (ss.toLowerCase().contains(".f")) {
                return false;
            }
            if (ss.toLowerCase().endsWith("f")) {
                return false;
            }
            if (ss.toLowerCase().contains(".d")) {
                return false;
            }
            if (ss.toLowerCase().endsWith("d")) {
                return false;
            }
            Double.valueOf(s);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
