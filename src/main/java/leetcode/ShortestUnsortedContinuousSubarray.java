package leetcode;

/**
 * @author Dauren Mussa
 * @since 5/14/18
 */
public class ShortestUnsortedContinuousSubarray {

    public static void main(String[] args) {
        ShortestUnsortedContinuousSubarray shortestUnsortedContinuousSubarray = new ShortestUnsortedContinuousSubarray();

        int array[] = {1, 2, 3, 1, 2, 6, 5, 7, 8, 9};

        System.out.println(shortestUnsortedContinuousSubarray.findUnsortedSubarray(array));

    }

    public int findUnsortedSubarray(int[] nums) {

        int left = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (i == 1) {
                    left = 0;
                    break;
                } else {
                    int current = nums[i--];
                    while (current < nums[i]) {
                        i--;
                        if (i == -1) {
                            left = 0;
                            break;
                        }
                    }
                    left = i + 1;
                    break;
                }
            }
        }

        int right = nums.length-1;


        return 0;
    }

}
