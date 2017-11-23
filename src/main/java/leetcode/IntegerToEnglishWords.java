package leetcode;

/**
 * @author Dauren Mussa
 * @since 11/23/17
 */
public class IntegerToEnglishWords {

    private String[] words = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private String[] centi = {"", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private String[] decim = {"Hundred", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private String[] hh = {"", "Thousand", "Million", "Billion"};

    public static void main(String[] args) {
        int value = 123456789;
        IntegerToEnglishWords words = new IntegerToEnglishWords();

        System.out.println(words.numberToWords(value));
    }

    private String numberToWords(int sum, int level) {
        return "";
    }

    public String numberToWords(int num) {
        return "";
    }

}
