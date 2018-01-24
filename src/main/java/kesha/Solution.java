package kesha;

/**
 * @author Dauren Mussa
 * @since 10/25/17
 */
public class Solution {

    public static void main(String[] args) {
        int[] data = new int[]{-3, 0, 3, 87, 100};
        int[] ress = twoSum(data, 187);
        System.out.println(ress[0] + " and " + ress[1]);
    }

    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length - 1; i++) {

            int toFind = target - nums[i];
            int start = i + 1;
            int oldStart = start;

            while (true) {
                if (start >= nums.length) {
                    start = (oldStart + start) / 2;
                } else {

                    if (nums[start] == toFind) {
                        return new int[]{i + 1, start + 1};
                    } else if (nums[start] < toFind) {
                        oldStart = start;
                        start = start * 2;
                    } else {
                        start = (oldStart + start) / 2;
                    }
                }

                if (oldStart == start) {
                    break;
                }
            }

        }

        return new int[]{-1, -1};
    }

}
