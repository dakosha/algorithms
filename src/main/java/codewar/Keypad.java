package codewar;

/**
 * @author Dauren Mussa
 * @since 12/12/16
 */
public class Keypad {

    /*
    |     | | ABC | | DEF |
    |  1  | |  2  | |  3  |
    ------- ------- -------
    | GHI | | JKL | | MNO |
    |  4  | |  5  | |  6  |
    ------- ------- -------
    |PQRS | | TUV | | WXYZ|
    |  7  | |  8  | |  9  |
    ------- ------- -------
    |     | |space| |     |
    |  *  | |  0  | |  #  |
     */

    private static final String[] buttons = {"1", "ABC2", "DEF3", "GHI4", "JKL5", "MNO6", "PQRS7", "TUV8", "WXYZ9", "*", " 0", "#"};

    public static void main(String[] args) {
        System.out.println(Keypad.presses("WHERE DO U WANT 2 MEET L8R"));
    }

    public static int presses(String phrase) {
        if (phrase != null && phrase.length() > 0) {
            String text = phrase.toUpperCase();
            int sum = 0;
            for (int i = 0; i < text.length(); i++) {
                sum += pressesForLetter(text.charAt(i));
            }
            return sum;
        } else
            return 0;
    }

    private static int pressesForLetter(Character character) {
        for (int i = 0; i < buttons.length; i++) {
            int index = buttons[i].indexOf(character.charValue());
            if (index > -1) {
                return index + 1;
            }
        }
        return 0;
    }

}
