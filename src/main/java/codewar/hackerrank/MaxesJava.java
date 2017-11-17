package codewar.hackerrank;

import java.util.Arrays;

/**
 * @author Dauren Mussa
 * @since 5/20/17
 */
public class MaxesJava {

    public static void main(String[] args) {

        int[] nums = new int[4];
        nums[0] = 1;
        nums[1] = 4;
        nums[2] = 2;
        nums[3] = 4;

        int[] maxes = new int[2];
        maxes[0] = 3;
        maxes[1] = 5;

        counts(nums, maxes);

    }

    static int findIndex(int[] nums, int number) {
        if (number >= nums[nums.length - 1]) {
            return nums.length;
        }
        int left = 0;
        int right = nums.length - 1;
        int index = (left + right) / 2;
        while (true) {
            if (nums[index] <= number && nums[index + 1] > number) {
                return index + 1;
            }
            if (index == nums.length - 1 || index == 0) {
                return index;
            }

            if (nums[index] <= number) {
                left = index;
                index = (left + right) / 2;
            } else if (nums[index] > number) {
                right = index;
                index = (left + right) / 2;
            }
        }
    }

    static int[] counts(int[] nums, int[] maxes) {
        Arrays.sort(nums);
        for (int i = 0; i < maxes.length; i++) {
            maxes[i] = findIndex(nums, maxes[i]);
        }
        return maxes;
    }

}
