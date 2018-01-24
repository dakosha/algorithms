package leetcode;

/**
 * @author Dauren Mussa
 * @since 12/3/17
 */
public class CherryPickup {

    public static void main(String[] args) {
        /*int[][] array = new int[][]{
                {1,1,1,1,0,0,0},
                {0,0,0,1,0,0,0},
                {0,0,0,1,0,0,1},
                {1,0,0,1,0,0,0},
                {0,0,0,1,0,0,0},
                {0,0,0,1,0,0,0},
                {0,0,0,1,1,1,1}
        };*/
        /*int[][] array = new int[][]{
                {0}
        };*/

        int[][] array = new int[][]{
                {1, -1, -1, -1, -1},
                {1, 0, 1, -1, -1},
                {0, -1, 1, 0, 1},
                {1, 0, 1, 1, 0},
                {-1, -1, -1, 1, 1}
        };

        System.out.println(new CherryPickup().cherryPickup(array));

    }

    private void printArray(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public int cherryPickup(int[][] grid) {
        int size = grid.length;
        int[][] collect = new int[size][size];
        boolean[][] connected = new boolean[size][size];

        collect[0][0] = grid[0][0];
        connected[0][0] = true;

        printArray(grid);

        //go to size,size;
        int x = 0;
        int y = 0;

        while (true) {
            if (x == 0 && y == 0) collect[x][y] = grid[x][y];
            else {
                int upSum = grid[x][y];
                int leftSum = grid[x][y];

                if (x > 0 && grid[x - 1][y] > -1) {
                    leftSum += collect[x - 1][y];
                    if (connected[x - 1][y]) {
                        connected[x][y] = true;
                    }
                }

                if (y > 0 && grid[x][y - 1] > -1) {
                    upSum += collect[x][y - 1];
                    if (connected[x][y - 1]) {
                        connected[x][y] = true;
                    }
                }

                if (leftSum > upSum && grid[x - 1][y] != -1) {
                    collect[x][y] = leftSum;
                } else {
                    collect[x][y] = upSum;
                }

                if (x == size - 1 && y == size - 1) break;
            }

            y++;
            if (y == size) {
                y=0;
                x++;
            }
            while (grid[x][y] == -1) {
                y++;
            }
        }

        printArray(collect);

        x = size - 1;
        y = size - 1;

        if (!connected[x][y]) return 0;

        while (true) {

            grid[x][y] = 0;

            if (x == 0 && y == 0) break;

            int maxLeft = 0;
            int maxUp = 0;

            if (x > 0) {
                maxUp = collect[x - 1][y];
            }
            if (y > 0) {
                maxLeft = collect[x][y - 1];
            }

            if (maxLeft >= maxUp && y - 1 >= 0) {
                y--;
            } else {
                x--;
            }

        }

        printArray(grid);

        grid[size - 1][size - 1] = collect[size - 1][size - 1];

        printArray(grid);

        for (int i = size - 1; i >= 0; i--) {
            for (int j = size - 1; j >= 0; j--) {
                if (connected[i][j]) {
                    collect[i][j] = grid[i][j];

                    //check right
                    if (i < size - 1 && connected[i + 1][j]) {
                        collect[i][j] = grid[i][j] + collect[i + 1][j];
                    }

                    //check bottom
                    if (j < size - 1 && connected[i][j + 1] && collect[i][j] < (grid[i][j] + collect[i][j + 1])) {
                        collect[i][j] = grid[i][j] + collect[i][j + 1];
                    }
                }
            }
        }

        if (size > 1) {
            if (collect[0][1] == collect[1][0]) {
                collect[0][0]++;
            }
        }

        printArray(collect);

        return collect[0][0];
    }

}
