package codewar;

/**
 * @author Dauren Mussa
 * @since 12/16/16
 */
public class Conversion {

    public static void main(String[] args) {
        Conversion conversion = new Conversion();
        System.out.println(conversion.solution(89));
    }

    public String solution(int n) {
        int thousands = n / 1000;
        int hundreds = (n - (thousands * 1000)) / 100;
        int tens = ((n - (thousands * 1000)) - hundreds * 100) / 10;
        int numbers = n % 10;

        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i<thousands; i++) {
            stringBuilder.append("M");
        }

        for (int i=0; i<hundreds; i++) {
            stringBuilder.append("C");
        }

        for (int i=0; i<tens; i++) {
            stringBuilder.append("X");
        }

        for (int i=0; i<numbers; i++) {
            stringBuilder.append("I");
        }

        int index = 0;
        String result = stringBuilder.toString();
        System.out.println(result);
        while (index > -1) {

            index = result.indexOf("CCCCCCCCC");
            if (index>-1) {
                result = result.replace("CCCCCCCCC", "CM");
            }

            index = result.indexOf("CCCCC");
            if (index>-1) {
                result = result.replace("CCCCC", "D");
            }

            index = result.indexOf("CCCC");
            if (index>-1) {
                result = result.replace("CCCC", "CD");
            }

            index = result.indexOf("XXXXXXXXX");
            if (index>-1) {
                result = result.replace("XXXXXXXXX", "XC");
            }

            index = result.indexOf("XXXXX");
            if (index>-1) {
                result = result.replace("XXXXX", "L");
            }

            index = result.indexOf("XXXX");
            if (index>-1) {
                result = result.replace("XXXX", "XL");
            }

            index = result.indexOf("IIIIIIIII");
            if (index>-1) {
                result = result.replace("IIIIIIIII", "IX");
            }

            index = result.indexOf("IIIII");
            if (index>-1) {
                result = result.replace("IIIII", "V");
            }

            index = result.indexOf("IIII");
            if (index>-1) {
                result = result.replace("IIII", "IV");
            }

        }

        return result;
    }

}
