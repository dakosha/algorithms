package amazon;

import java.util.Random;

/**
 * @author Dauren Mussa
 * @since 2/8/18
 */
public class MaxSumOfSubMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {9, -8, 1, 3, -2},
                {-3, 7, 6, -2, 4},
                {6, -4, -4, 8, -7}
        };

        int n = 5;
        int m = 5;
        matrix = getRandomMatrix(n, m);

        int[] maxRes = maxSubMatrix(matrix);
        System.out.println("max = " + maxRes[0]);
        System.out.println("coordinates = " + maxRes[1] + " " + maxRes[2] + " " + maxRes[3] + " " + maxRes[4]);
        System.out.println();

        printDimensions(matrix, maxRes[1], maxRes[2], maxRes[3], maxRes[4]);

        System.out.println();

        printMatrix(matrix);
        System.out.println();

        int[][] leftSums = precomputeLeftTop(matrix);
        int[][] rightSums = precomputeRightBottom(matrix);

        printMatrix(leftSums);
        System.out.println();
        printMatrix(rightSums);
        System.out.println();

        int[] leftMax = findMax(leftSums);
        int[] rightMax = findMax(rightSums);
        System.out.println(rightMax[0] + ":" + rightMax[1]);
        System.out.println(leftMax[0] + ":" + leftMax[1]);

        System.out.println();
        printDimensions(matrix, rightMax[0], rightMax[1], leftMax[0], leftMax[1]);

        System.out.println("ext-sum = " + getSum(matrix, rightMax[0], rightMax[1], leftMax[0], leftMax[1]));

        int[][][][][] cub = new int[5][5][5][5][5];
        for (int i=0; i<cub.length; i++) {
            for (int j=0; j<cub[i].length; j++) {
                for (int k=0; k<cub[i][j].length; k++) {
                    for (int l=0; l<cub[i][j][k].length; l++) {
                        for (int u=0; u<cub[i][j][k][l].length; u++) {
                            cub[i][j][k][l][u] = 5;
                        }
                    }
                }
            }
        }

    }


    static int[] maxSubMatrix(int[][] matrix) {
        int[] result = new int[5];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                for (int k = i; k < matrix.length; k++) {
                    for (int l = j; l < matrix[k].length; l++) {
                        int curmax = getSum(matrix, i, j, k, l);
                        if (curmax > max) {
                            max = curmax;
                            result[0] = curmax;
                            result[1] = i;
                            result[2] = j;
                            result[3] = k;
                            result[4] = l;
                        }
                    }
                }
            }
        }
        return result;
    }

    static int getSum(int[][] matrix, int x1, int y1, int x2, int y2) {
        int sum = 0;
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    static void printDimensions(int[][] matrix, int x1, int y1, int x2, int y2) {
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    static int[] findMax(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        int[] result = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    static int[][] precomputeLeftTop(int[][] matrix) {
        int[][] result = new int[matrix.length][];

        for (int i = 0; i < matrix.length; i++) {
            result[i] = new int[matrix[i].length];
            result[i][0] = matrix[i][0];

            for (int j = 0; j < matrix[i].length; j++) {
                result[i][j] = (i > 0 ? result[i - 1][j] : 0) +
                        (j > 0 ? result[i][j - 1] : 0) + matrix[i][j]
                        - (i > 0 && j > 0 ? result[i - 1][j - 1] : 0);
            }
        }

        return result;
    }

    static int[][] precomputeRightBottom(int[][] matrix) {
        int[][] result = new int[matrix.length][];

        for (int i = matrix.length - 1; i >= 0; i--) {
            result[i] = new int[matrix[i].length];
            result[i][matrix[i].length - 1] = matrix[i][matrix[i].length - 1];

            for (int j = matrix[i].length - 1; j >= 0; j--) {
                result[i][j] = (i < matrix.length - 1 ? result[i + 1][j] : 0) +
                        (j < matrix[i].length - 1 ? result[i][j + 1] : 0) + matrix[i][j]
                        - (i < matrix.length - 1 && j < matrix[i].length - 1 ? result[i + 1][j + 1] : 0);
            }
        }

        return result;
    }

    static int[][] getRandomMatrix(int n, int m) {
        Random rnd = new Random();
        int[][] matrix = new int[n][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new int[m];
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = rnd.nextInt(150) - 50;
            }
        }
        return matrix;
    }

}
