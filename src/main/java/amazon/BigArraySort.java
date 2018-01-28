package amazon;

import java.util.Random;

/**
 * @author Dauren Mussa
 * @since 1/27/18
 */
public class BigArraySort {

    public static void main(String[] args) {
        int n = 105;
        int[] array = new int[n];
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = rnd.nextInt(10*n);
        }
        printArray(array);
        fullSort(array);
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void fullSort(int[] array) {
        int maxSortable = 10;
        int totalArrays = array.length / maxSortable;
        int lastArray = array.length % maxSortable;
        if (lastArray != 0) {
            totalArrays++;
        }

        int[][] subArrays = new int[totalArrays][];

        for (int i = 0; i < array.length; i += maxSortable) {
            int[] subArray = new int[i + maxSortable <= array.length ? maxSortable : (array.length - i)];
            System.arraycopy(array, i, subArray, 0, i + maxSortable <= array.length ? maxSortable : (array.length - i));
            subArrays[i/maxSortable] = mergeSort(subArray, 0, subArray.length - 1);
            printArray(subArrays[i/maxSortable]);
        }


        for (int k=0; k<totalArrays-1; k++) {
            int[] res = subArrays[k];
            for (int i=k+1; i<totalArrays; i++) {
                int[] left = new int[res.length];
                res = mergeAsc(res, subArrays[i]);

                System.arraycopy(res, 0, left, 0, left.length);
                System.arraycopy(res, left.length, subArrays[i], 0, subArrays[i].length);
                res = left;
            }
            subArrays[k] = res;
        }


        for (int k=0; k<totalArrays; k++) {
            printArray(subArrays[k]);
        }

    }

    public static int[] mergeSort(int[] array, int low, int high) {
        if (high - low >= 1) {
            int mid = (low + high) / 2;
            int[] left = new int[mid - low + 1];
            int[] right = new int[high - mid];

            System.arraycopy(array, low, left, 0, left.length);
            System.arraycopy(array, mid + 1, right, 0, right.length);

            left = mergeSort(left, 0, left.length - 1);
            right = mergeSort(right, 0, right.length - 1);

            array = mergeAsc(left, right);

        }
        return array;
    }

    public static int[] mergeAsc(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        if (left.length == 0) {
            return right;
        } else if (right.length == 0) {
            return left;
        }

        int lIndex = 0;
        int rIndex = 0;
        int RIndex = 0;

        while (RIndex < result.length) {
            if (lIndex == left.length) {
                result[RIndex++] = right[rIndex++];
            } else if (rIndex == right.length) {
                result[RIndex++] = left[lIndex++];
            } else {
                result[RIndex++] = left[lIndex] < right[rIndex] ? left[lIndex++] : right[rIndex++];
            }
        }

        return result;
    }

}
