package leetcode;

/**
 * @author Dauren Mussa
 * @since 5/14/18
 */
public class SubarrayProductLessThanK {

    public static void main(String[] args) {
        SubarrayProductLessThanK subarrayProductLessThanK = new SubarrayProductLessThanK();

        //int[] array = {10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3};
        int[] array = {10, 2, 2, 5, 4, 4, 4, 3, 7, 7};
        //int[] array = {10, 5, 2, 6};
        //int[] array = {1, 1, 1};

        System.out.println(subarrayProductLessThanK.numSubarrayProductLessThanK(array, 289));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;

        int result = 0;
        int left = 0;
        int right = 0;
        int product = 1;

        while (true) {
            product *= nums[right];

            while (product >= k) {
                product /= nums[left++];
            }

            result += (right - left + 1);

            right++;

            if (right == nums.length) {
                break;
            }
        }

        return result;
    }

}
