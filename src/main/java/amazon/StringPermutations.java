package amazon;

/**
 * @author Dauren Mussa
 * @since 1/25/18
 */
public class StringPermutations {

    public static void main(String[] args) {
        String a = "abcde";
        permutate(a, "");
    }

    public static void permutate(String source, String prefix) {
        if (source.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i=0; i<source.length(); i++) {
                permutate(source.substring(0, i) + source.substring(i+1), prefix + source.charAt(i));
            }
        }
    }

}
