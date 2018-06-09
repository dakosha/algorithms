package leetcode;

/**
 * @author Dauren Mussa
 * @since 5/13/18
 */
public class ThirdBiggestNumber {

    public static void main(String[] args) {
        int[] array = {1,2};
        ThirdBiggestNumber thirdBiggestNumber = new ThirdBiggestNumber();

        int val = thirdBiggestNumber.thirdMax(array);

        System.out.println(val);
    }

    public int thirdMax(int[] nums) {
        long max1 = Long.MIN_VALUE;
        long max2 = Long.MIN_VALUE;
        long max3 = Long.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (max1 < nums[i]) {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            } else if (max2 < nums[i] && max1 != nums[i]) {
                max3 = max2;
                max2 = nums[i];
            } else if (max3 < nums[i] && max2 != nums[i] && max1 != nums[i]) {
                max3 = nums[i];
            }
        }
        if (max3 == Long.MIN_VALUE) {
            return (int)max1;
        } else {
            return (int)max3;
        }
    }

}
