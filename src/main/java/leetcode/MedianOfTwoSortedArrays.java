package leetcode;

/**
 * @author Dauren Mussa
 * @since 11/12/17
 */
public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] a = new int[]{1, 3};
        int[] b = new int[]{2};
        System.out.println(findMedianSortedArrays(a, b));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int index1 = 0;
        int index2 = 0;
        int length = (nums1.length + nums2.length);
        boolean atTheMiddle = true;

        int neededIndex = length / 2;
        if (length % 2 == 0) {
            atTheMiddle = false;
        }

        int prevNumber = 0;
        int currentNumber = 0;

        for (int i = 0; i < length; i++) {
            if (index1+index2 == neededIndex && atTheMiddle) {
                if (index1 < nums1.length && index2 < nums2.length) {
                    if (nums1[index1] < nums2[index2]) {
                        currentNumber = prevNumber;
                        prevNumber = nums1[index1];
                        index1++;
                    } else {
                        currentNumber = prevNumber;
                        prevNumber = nums2[index2];
                        index2++;
                    }
                } else {
                    if (index1 < nums1.length) {
                        currentNumber = prevNumber;
                        prevNumber = nums1[index1];
                        index1++;
                    } else {
                        currentNumber = prevNumber;
                        prevNumber = nums2[index2];
                        index2++;
                    }
                }
                return prevNumber;
            } else if (index1+index2 == neededIndex && !atTheMiddle) {
                if (index1 < nums1.length && index2 < nums2.length) {
                    if (nums1[index1] < nums2[index2]) {
                        currentNumber = prevNumber;
                        prevNumber = nums1[index1];
                        index1++;
                    } else {
                        currentNumber = prevNumber;
                        prevNumber = nums2[index2];
                        index2++;
                    }
                } else {
                    if (index1 < nums1.length) {
                        currentNumber = prevNumber;
                        prevNumber = nums1[index1];
                        index1++;
                    } else {
                        currentNumber = prevNumber;
                        prevNumber = nums2[index2];
                        index2++;
                    }
                }
                return (double) (currentNumber + prevNumber) / (double) 2;
            } else {
                if (index1 < nums1.length && index2 < nums2.length) {
                    if (nums1[index1] < nums2[index2]) {
                        currentNumber = prevNumber;
                        prevNumber = nums1[index1];
                        index1++;
                    } else {
                        currentNumber = prevNumber;
                        prevNumber = nums2[index2];
                        index2++;
                    }
                } else {
                    if (index1 < nums1.length) {
                        currentNumber = prevNumber;
                        prevNumber = nums1[index1];
                        index1++;
                    } else {
                        currentNumber = prevNumber;
                        prevNumber = nums2[index2];
                        index2++;
                    }
                }
            }

        }

        return 0;
    }

}
