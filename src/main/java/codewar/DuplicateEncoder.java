package codewar;

/**
 * @author Dauren Mussa
 * @since 12/11/16
 */
public class DuplicateEncoder {

    public static void main(String[] args) {
        final String test1 = "Prespecialized";
        System.out.println(encode(test1));
    }

    static String encode(String word) {
        final String text = word.toLowerCase();

        byte[] map = new byte[255];
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            byte amount = map[symbol];
            if (amount == 0) {
                int index = text.lastIndexOf(symbol);
                if (index == i) {
                    result = result + "(";
                }
                else {
                    result = result + ")";
                    map[symbol] = 1;
                }
            }
            else {
                result = result + ")";
            }
        }

        return result;
    }

}
