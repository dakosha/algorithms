package leetcode;

/**
 * @author Dauren Mussa
 * @since 11/14/17
 */
public class FirstMissingPositive {

    public static void main(String[] args) {
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();

        int[] input = new int[3];
        input[0] = 3;
        input[1] = 1;
        input[2] = 2;

        int result = firstMissingPositive.firstMissingPositive(input);
        System.out.println(result);

    }

    private int shiftNegative(int[] nums) {
        int j = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] <= 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j--;
            }
        }
        return j + 1;
    }

    public int firstMissingPositive(int[] nums) {
        int newSize = shiftNegative(nums);
        int[] nums2 = new int[newSize];
        for (int i = 0; i < newSize; i++) {
            if (nums[i] - 1 >= 0 && nums[i] - 1 < newSize) {
                nums2[nums[i] - 1] = 1;
            }
        }
        for (int i = 0; i < newSize; i++) {
            if (nums2[i] == 0) {
                return i + 1;
            }
        }
        return newSize + 1;
    }

}
