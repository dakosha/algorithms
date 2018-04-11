package leetcode;

/**
 * @author Dauren Mussa
 * @since 2/17/18
 */
public class StrongPasswordChecker {

    public static void main(String[] args) {
        StrongPasswordChecker strongPasswordChecker = new StrongPasswordChecker();
        System.out.println(strongPasswordChecker.strongPasswordChecker("aaa123"));
    }

    public int strongPasswordChecker(String s) {
        int totalChanges = 0;
        int lengthModif = 0;
        int lengthModif2 = 0;

        if (s.length() < 6) {
            lengthModif = 6 - s.length();
        }
        if (s.length() > 20) {
            lengthModif2 = s.length() - 20;
        }

        if (s.length() > 0 && !hasUpperCase(s)) {
            totalChanges++;
        }
        if (s.length() > 0 && !hasLowerCase(s)) {
            totalChanges++;
        }
        if (s.length() > 0 && !hasDigit(s)) {
            totalChanges++;
        }

        int repeats = 0;
        if (s.length() > 0) {
            repeats = validateRepeats(s);
        }



        return repeats + totalChanges;

    }

    public int validateRepeats(String s) {
        char current = s.charAt(0);
        int result = 0;
        byte count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (count == 3) {
                result++;
                count = 0;
                current = s.charAt(i);
            }
            if (s.charAt(i) == current) {
                count++;
            } else {
                current = s.charAt(i);
                count = 1;
            }
        }

        if (count == 3) {
            result++;
        }

        return result;
    }

    public boolean hasDigit(String s) {
        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(i, i + 1);
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                return true;
            }
        }
        return false;
    }

    public boolean hasUpperCase(String s) {
        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(i, i + 1);
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z' || s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                if (sub.equals(sub.toUpperCase())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasLowerCase(String s) {
        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(i, i + 1);
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z' || s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                if (sub.equals(sub.toLowerCase())) {
                    return true;
                }
            }
        }
        return false;
    }

}
