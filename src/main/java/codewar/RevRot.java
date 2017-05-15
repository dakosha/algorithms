package codewar;

import java.math.BigInteger;

/**
 * @author Dauren Mussa
 * @since 12/12/16
 */
public class RevRot {

    public static void main(String[] args) {
        System.out.println(revRot("73304991087", 6));
        System.out.println(revRot("849328383334157579", 6));
        System.out.println(revRot("66443875", 4));
        System.out.println(revRot("66443875", 8));
        System.out.println(revRot("664438769", 8));
        System.out.println(revRot("123456779", 8));
        System.out.println(revRot("", 8));
        System.out.println(revRot("123456779", 0));
    }

    public static String revRot(String str, int size) {
        if (size <= 0) return "";
        String result = "";
        for (int i = 0; i < str.length() / size; i++) {
            String token = str.substring(i * size, (i + 1) * size);
            result = result + doJob(token);
        }
        return result;
    }

    private static String doJob(String value) {
        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i < value.length(); i++) {
            long elem = Character.getNumericValue(value.charAt(i));
            BigInteger bigElem = BigInteger.valueOf(elem);
            sum = sum.add(bigElem.multiply(bigElem).multiply(bigElem));
        }
        return sum.mod(BigInteger.valueOf(2l)).longValue() == 0 ? reverse(value) : rotate(value);
    }

    private static String reverse(String value) {
        String result = "";
        for (int i = 0; i < value.length(); i++) {
            result = value.charAt(i) + result;
        }
        return result;
    }

    private static String rotate(String value) {
        return value.substring(1) + value.substring(0, 1);
    }

}

