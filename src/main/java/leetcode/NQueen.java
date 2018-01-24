package leetcode;

import java.util.List;

/**
 * @author Dauren Mussa
 * @since 1/15/18
 */
public class NQueen {

    public static void main(String[] args) {
        NQueen nQueen = new NQueen();
        List<List<String>> result = nQueen.solveNQueens(4);

        for (List<String> list : result) {
            for (String val : list) {
                System.out.println(val);
            }
            System.out.println();
        }
    }


    public List<List<String>> solveNQueens(int n) {

        return null;
    }

}
