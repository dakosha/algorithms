package leetcode;

/**
 * @author Dauren Mussa
 * @since 5/23/18
 */
public class SurroundedTerritory {

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        /*char[][] board = {
                {'O', 'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'O', 'O'},
                {'X', 'X', 'O', 'X', 'X'},
                {'X', 'O', 'X', 'X', 'X'}
        };*/

        SurroundedTerritory surroundedTerritory = new SurroundedTerritory();
        surroundedTerritory.solve(board);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

    }

    public void solve(char[][] board) {

        if (board == null || board.length == 0) return;
        short n = (short) board.length;
        short m = (short) board[0].length;
        int[] list = new int[n * m];

        int index = 0;

        for (short i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                int val = 0;
                val += i << 16;
                list[index++] = val;
                board[i][0] = 'B';
            }
            if (board[i][m - 1] == 'O') {
                int val = 0;
                val += i << 16;
                val += m - 1;
                list[index++] = val;
                board[i][m - 1] = 'B';
            }
        }

        for (short i = 0; i < m; i++) {
            if (board[0][i] == 'O') {
                int val = 0;
                val += i;
                list[index++] = val;
                board[0][i] = 'B';
            }
            if (board[n - 1][i] == 'O') {
                int val = 0;
                val += n - 1 << 16;
                val += i;
                list[index++] = val;
                board[n - 1][i] = 'B';
            }
        }

        int size = index;
        int ind = 0;
        while (ind < size) {
            int current = list[ind++];
            short y = (short) (current & 0x0000ffff);
            short x = (short) ((current & 0xffff0000) >> 16);

            if (x - 1 >= 0 && board[x - 1][y] == 'O') {
                board[x - 1][y] = 'B';
                int val = 0;
                val += x - 1 << 16;
                val += y;
                list[index++] = val;
                size++;
            }

            if (x + 1 < n && board[x + 1][y] == 'O') {
                board[x + 1][y] = 'B';
                int val = 0;
                val += x + 1 << 16;
                val += y;
                list[index++] = val;
                size++;
            }

            if (y - 1 >= 0 && board[x][y - 1] == 'O') {
                board[x][y - 1] = 'B';
                int val = 0;
                val += x << 16;
                val += y - 1;
                list[index++] = val;
                size++;
            }

            if (y + 1 < m && board[x][y + 1] == 'O') {
                board[x][y + 1] = 'B';
                int val = 0;
                val += x << 16;
                val += y + 1;
                list[index++] = val;
                size++;
            }
        }

        for (short i = 0; i < n; i++) {
            for (short j = 0; j < m; j++) {
                if (board[i][j] == 'B') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }

    }

}
