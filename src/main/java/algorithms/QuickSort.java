package algorithms;

import java.util.Random;

public class QuickSort {

    static int counter = 0;

    public static void main(String[] args) {
        int n = 1000000;
        Random rnd = new Random();
        int[] array = new int[n];
        for (int i=0; i< n; i++) {
            array[i] = rnd.nextInt();
        }

        quickSort(array, 0, array.length - 1);


        System.out.println();
        System.out.println("elem number = " + array.length);
        System.out.println("elem swap = " + counter);

    }

    public static void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public static void quickSort(int[] array, int left, int right) {
        int pivot = array[(left + right) / 2];
        int i = left;
        int j = right;
        while (i <= j) {
            while (array[i] < pivot) i += 1;
            while (array[j] > pivot) j -= 1;
            if (i <= j) {
                counter++;
                swap(array, i, j);
                i += 1;
                j -= 1;
            }
        }
        if (left < j) quickSort(array, left, j);
        if (j < right) quickSort(array, i, right);
    }

}
