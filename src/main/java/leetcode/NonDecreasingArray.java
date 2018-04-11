package leetcode;

/**
 * @author Dauren Mussa
 * @since 2/17/18
 */
public class NonDecreasingArray {

    public static void main(String[] args) {
        int[] array3 = {3, 4, 2, 3};
        int[] array = {4, 1, 2};
        int[] array2 = {4, 2, 1};

        System.out.println(checkPossibility(array3));
        System.out.println(checkPossibility(array));
        System.out.println(checkPossibility(array2));
    }

    static boolean checkPossibility(int[] nums) {
        boolean result = true;
        boolean changed = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (!changed) {
                    if (i > 0) {
                        int dif = nums[i] - nums[i - 1];
                        int dif2 = nums[i] - nums[i + 1];
                        if (dif2 > dif) {
                            if (i + 1 == nums.length - 1) {
                                return true;
                            } else {
                                nums[i + 1] = nums[i];
                                changed = true;
                            }
                        } else {
                            changed = true;
                        }
                    } else {
                        nums[i] = 0;
                        changed = true;
                    }
                } else {
                    result = false;
                    break;
                }
            }
        }

        return result;
    }

}
