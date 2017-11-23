package leetcode;

/**
 * @author Dauren Mussa
 * @since 11/22/17
 */
public class ImportantReversePairs {

    public static void main(String[] args) {
        //int[] array = new int[] {1,3,2,3,1};
        int[] array = new int[]{2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647};
        ImportantReversePairs pairs = new ImportantReversePairs();

        System.out.println(pairs.reversePairs(array));
    }

    public int reversePairs(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if ((nums[i] < 0 && nums[j] < 0) || nums[i] > 0) {
                        long var = (long) nums[j] * 2;
                        if (nums[i] > var) {
                            result++;
                        }
                    }
                }
            }
        }
        return result;
    }

}
