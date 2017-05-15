package codewar.hackerrank;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Dauren Mussa
 * @since 4/28/17
 */
public class CountStrings {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Expression[] expressions = new Expression[n];
        for (int i=0; i<n; i++) {
            expressions[i] = new Expression(scanner.next(), scanner.nextInt());
        }

        for (int i=0; i<n; i++) {
            expressions[i].validate();
            System.out.println(expressions[i].toString());
        }

    }

    private static class Expression {
        private static final String START_PARENTHESIS = "(";
        private static final String END_PARENTHESIS = ")";
        private static final String UNION = "|";
        private static final String ANY = "*";
        private static final String LETTER_A = "a";
        private static final String LETTER_B = "b";

        final private String exp;
        final private int length;
        Expression(String exp, int length) {
            this.exp = exp;
            this.length = length;
        }

        private boolean isLetter(String elem) {
            return elem.equals(LETTER_B) || elem.equals(LETTER_A);
        }

        private boolean isAnyParenthesis(String elem) {
            return elem.equals(START_PARENTHESIS) || elem.equals(END_PARENTHESIS);
        }

        public void validate() {
            Stack<String> strings = new Stack<>();
            for (int i=0; i<exp.length(); i++) {

            }
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Expression{");
            sb.append("exp='").append(exp).append('\'');
            sb.append(", length=").append(length);
            sb.append('}');
            return sb.toString();
        }
    }

}
