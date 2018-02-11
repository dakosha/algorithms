package amazon.matrix;

/**
 * @author Dauren Mussa
 * @since 2/1/18
 */
public class MatrixRotations {

    public static void main(String[] args) {
        int[][] matrix = generate(2);
        int[][] rotated = rotate(matrix, 90);
        printMatrix(rotated);
        matrix = generate(2);
        rotated = rotate(matrix, 180);
        printMatrix(rotated);
        matrix = generate(2);
        rotated = rotate(matrix, 270);
        printMatrix(rotated);

    }

    public static int[][] generate(int n) {
        int[][] result = new int[n][];
        for (int i = 0; i < n; i++) {
            result[i] = new int[n];
            for (int j = 0; j < n; j++) {
                result[i][j] = i * n + j + 1;
            }
        }
        return result;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void rotate90(int[][] matrix, int i, int j, int n) {
        int x1 = i, y1 = j;
        int x2 = j, y2 = n - i;
        int x3 = n - i, y3 = n - j;
        int x4 = n - j, y4 = i;

        swap(matrix, x1, y1, x2, y2, x3, y3, x4, y4);
    }

    public static void rotate180(int[][] matrix, int i, int j, int n) {
        rotate90(matrix, i, j, n);
        rotate90(matrix, i, j, n);
    }

    public static void rotate270(int[][] matrix, int i, int j, int n) {
        rotate90(matrix, i, j, n);
        rotate90(matrix, i, j, n);
        rotate90(matrix, i, j, n);
    }

    public static void swap(int[][] matrix, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        int temp = matrix[x4][y4];
        matrix[x4][y4] = matrix[x3][y3];
        matrix[x3][y3] = matrix[x2][y2];
        matrix[x2][y2] = matrix[x1][y1];
        matrix[x1][y1] = temp;
    }

    public static int[][] rotate(int[][] matrix, int degree) {
        int n = matrix.length - 1;
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = i; j < matrix.length - i - 1; j++) {
                switch (degree) {
                    case 90: {
                        rotate90(matrix, i, j, n);
                        break;
                    }
                    case 180: {
                        rotate180(matrix, i, j, n);
                        break;
                    }
                    case 270: {
                        rotate270(matrix, i, j, n);
                        break;
                    }
                    default: {
                        System.out.println("Unsupported");
                        System.exit(0);
                    }
                }
            }
        }
        return matrix;
    }

}
