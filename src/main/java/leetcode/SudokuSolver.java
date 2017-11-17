package leetcode;

import java.util.HashSet;

/**
 * @author Dauren Mussa
 * @since 11/14/17
 */
public class SudokuSolver {

    HashSet[] hSet = new HashSet[9];
    HashSet[] vSet = new HashSet[9];
    HashSet[] cubeSet = new HashSet[9];
    HashSet localSet = new HashSet();
    Integer totalSpaces = 0;
    Boolean solved = false;

    public static void main(String[] args) {
        SudokuSolver solver = new SudokuSolver();
        char[][] board = new char[][]{
                {'.', '.', '9', '7', '4', '8', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
                {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
                {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
                {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
                {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '2', '7', '5', '9', '.', '.'}
        };
        solver.solveSudoku(board);
        solver.printSudoku(board);
    }

    private void analyzeBoard(char[][] board) {
        localSet.add('1');
        localSet.add('2');
        localSet.add('3');
        localSet.add('4');
        localSet.add('5');
        localSet.add('6');
        localSet.add('7');
        localSet.add('8');
        localSet.add('9');
        initHashes();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    vSet[i].add(board[i][j]);
                    hSet[j].add(board[i][j]);
                    cubeSet[getCubeNumber(i, j)].add(board[i][j]);
                } else {
                    totalSpaces++;
                }
            }
        }
    }

    private void solveSudokuInternal(char[][] board, int i, int j) {
        if (totalSpaces == 0) {
            solved = true;
            return;
        }

        if (board[i][j] == '.') {
            int cubeNumber = getCubeNumber(i, j);
            HashSet local = (HashSet) localSet.clone();
            local.removeAll(vSet[i]);
            local.removeAll(hSet[j]);
            local.removeAll(cubeSet[cubeNumber]);
            for (Object object : local) {

                vSet[i].add(object);
                hSet[j].add(object);
                cubeSet[cubeNumber].add(object);

                board[i][j] = (char) object;

                totalSpaces--;

                int newI = i;
                int newJ = j;
                newJ++;
                if (newJ>8) {
                    newI++;
                    newJ=0;
                }
                solveSudokuInternal(board, newI, newJ);
                if (solved) {
                    return;
                }


                totalSpaces++;

                board[i][j] = '.';

                vSet[i].remove(object);
                hSet[j].remove(object);
                cubeSet[cubeNumber].remove(object);
            }
        } else {
            int newI = i;
            int newJ = j;
            newJ++;
            if (newJ>8) {
                newI++;
                newJ=0;
            }
            solveSudokuInternal(board, newI, newJ);
        }
    }

    private void printSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public void solveSudoku(char[][] board) {
        analyzeBoard(board);
        solveSudokuInternal(board, 0, 0);
    }

    private void initHashes() {
        for (int i = 0; i < 9; i++) {
            hSet[i] = new HashSet();
            vSet[i] = new HashSet();
            cubeSet[i] = new HashSet();
        }
    }


    private int getCubeNumber(int x, int y) {
        if (x >= 0 && x <= 2) {
            if (y >= 0 && y <= 2) {
                return 0;
            } else if (y >= 3 && y <= 5) {
                return 1;
            } else if (y >= 6 && y <= 8) {
                return 2;
            } else {
                throw new IndexOutOfBoundsException();
            }
        } else if (x >= 3 && x <= 5) {
            if (y >= 0 && y <= 2) {
                return 3;
            } else if (y >= 3 && y <= 5) {
                return 4;
            } else if (y >= 6 && y <= 8) {
                return 5;
            } else {
                throw new IndexOutOfBoundsException();
            }
        } else if (x >= 6 && x <= 8) {
            if (y >= 0 && y <= 2) {
                return 6;
            } else if (y >= 3 && y <= 5) {
                return 7;
            } else if (y >= 6 && y <= 8) {
                return 8;
            } else {
                throw new IndexOutOfBoundsException();
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
}
