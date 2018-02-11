package amazon;

/**
 * @author Dauren Mussa
 * @since 2/7/18
 */
public class MajorityElement {

    public static void main(String[] args) {
        //int[] array = {5, 982, 73, 5, 5, 74, 865, 5, 5};
        int[] array = {5, 5, 5, 1, 5, 1, 5, 1, 9};
        //int[] array = {1, 2, 5, 9, 5, 9, 5, 5, 5};

        System.out.println(findMajorityElement(array));
    }

    static int find(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
            array[i] = array[i] - Integer.MAX_VALUE;
        }
        System.out.println();

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        return 0;
    }

    static int findMajorityElement(int[] array) {
        int candidate = getCandidate(array);
        return validate(array, candidate) ? candidate : -1;
    }

    static int getCandidate(int[] array) {
        int major = 0;
        int count = 0;
        for (int i=0; i<array.length; i++) {
            if (count == 0) {
                major = array[i];
            }
            if (array[i] == major) {
                count++;
            } else {
                count--;
            }
        }
        return major;
    }

    static boolean validate(int[] array, int major) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == major) {
                count++;
            }
        }
        return count > array.length / 2;
    }

}
