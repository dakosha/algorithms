package leetcode;

/**
 * @author Dauren Mussa
 * @since 1/16/18
 */
public class JumpGame2 {

    public static void main(String[] args) {
        JumpGame2 jumpGame2 = new JumpGame2();

        int[] nums = new int[]{2, 3, 1, 1, 4};

        int result = jumpGame2.jump(nums);
        System.out.println(result);
    }

    private int findShortest(int[] moves, int currentPos, int steps) {
        while (currentPos != 0) {
            while (moves[currentPos] == -1) {
                currentPos++;
            }
            currentPos = moves[currentPos];
            steps++;
        }
        return steps;
    }

    public int jump(int[] nums) {
        int[] moves = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            moves[i] = -1;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            int index = i + nums[i] < nums.length ? i + nums[i] : nums.length - 1;
            boolean flag = false;
            for (int j = index; j < nums.length; j++) {
                if (moves[j] != -1) {
                    flag = true;
                    break;
                }
            }
            if (moves[index] == -1 && !flag) {
                moves[index] = i;
            }
        }

        return findShortest(moves, nums.length - 1, 0);
    }

}
