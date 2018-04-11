package leetcode;

/**
 * @author Dauren Mussa
 * @since 2/17/18
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        rotateInPlace(array, k);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    static void rotateInPlace(int[] nums, int k) {
        if (k >= nums.length) {
            k = k % nums.length;
        }
        if (k == 0) {
            return;
        }
        if (nums.length == 1) {
            return;
        }

        for (int j = 0; j < k; j++) {
            for (int i = 1; i < nums.length; i++) {
                int temp = nums[0];
                nums[0] = nums[i];
                nums[i] = temp;
            }
        }

    }

    //rotate with System.arraycopy
    static void rotate(int[] nums, int k) {
        if (k >= nums.length) {
            k = k % nums.length;
        }
        if (k == 0) {
            return;
        }
        if (nums.length == 1) {
            return;
        }

        int firstLength = nums.length - k;
        int secondLength = nums.length - firstLength;

        int[] prev = new int[firstLength];
        System.arraycopy(nums, 0, prev, 0, firstLength);

        int[] second = new int[secondLength];
        System.arraycopy(nums, prev.length, second, 0, secondLength);

        System.arraycopy(second, 0, nums, 0, second.length);
        System.arraycopy(prev, 0, nums, k, prev.length);

    }

}
