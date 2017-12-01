package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Dauren Mussa
 * @since 11/30/17
 */
public class TwoSums {

    public static void main(String[] args) {
        int[] arr = new int[1000000];
        for (int i=0; i<arr.length; i++) {
            arr[i] = i;
        }

        TwoSums twoSums = new TwoSums();

        long time1 = System.nanoTime();

        int[] result = twoSums.twoSum(arr, 3);

        long time2 = System.nanoTime();

        System.out.println(result[0] + " " + result[1]);

        System.out.println(time2 - time1);

        time1 = System.nanoTime();

        result = twoSums.twoSum1(arr, 1999997);

        time2 = System.nanoTime();

        System.out.println(result[0] + " " + result[1]);

        System.out.println(time2 - time1);
    }

    private Map<Integer, Integer> map;
    public int[] twoSum1(int[] nums, int target) {

        map = new HashMap<>();
        for (int i = 0; i< nums.length; i++) {
            Integer e = map.get(target - nums[i]);
            if (e != null) {
                return new int[] {e, i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }

    public int[] twoSum(int[] nums, int target) {
        int min = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (min > nums[i] && nums[i] < 0) {
                min = nums[i];
            }
            if (max < nums[i] && nums[i] > 0) {
                max = nums[i];
            }
        }

        min = Math.abs(min);
        int[] map = new int[min + max + 1];


        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (diff <= max && (diff + min) >= 0) {
                if (map[diff + min] >= 1) {
                    return new int[]{i, map[diff + min]-1};
                }
            }
            map[nums[i] + min] = i+1;
        }
        return new int[]{-1, -1};
    }

}
