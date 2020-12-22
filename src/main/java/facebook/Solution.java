package facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        //int[] a = {1, 9, 5, 1, 2, 5, 9, 8, 1, 3};
        //int[] a = {1, 2, 4, -1, 2};
        int[] a = {33, 90, 57, 39, 42, 45, 29, 90, 81, 87, 88, 37, 58, 97, 80, 2, 77, 64, 82, 41, 2, 33, 34, 95, 85, 77, 92, 3, 8, 15, 71, 84, 58, 65, 46, 48, 3, 74, 4, 83, 23, 12, 15, 77, 33, 65, 17, 86, 21, 62, 71, 55, 80, 63, 75, 55, 11, 34, -1, 64, 81, 18, 77, 82, 8, 12, 14, 6, 46, 39, 71, 14, 6, 46, 89, 37, 88, 70, 88, 33, 89, 92, 60, 0, 78, 10, 88, 99, 20};
        int n = 74;
        List<Integer> result = new Solution().cheapestJump(a, n);

        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
        System.out.println();
    }

    public List<Integer> cheapestJump(int[] A, int B) {

        for (int i = 0; i < A.length / 2; i++) {
            int temp = A[i];
            A[i] = A[A.length - i - 1];
            A[A.length - i - 1] = temp;
        }

        int[] currentStep = new int[A.length];
        int[] nextStep = new int[A.length];

        int[] nextPath = new int[A.length];
        int[] path = new int[A.length];
        for (int i = 0; i < currentStep.length; i++) {
            currentStep[i] = Integer.MAX_VALUE;
            nextStep[i] = Integer.MAX_VALUE;
        }

        currentStep[0] = A[0];

        for (int k = 0; k < A.length; k++) {
            for (int i = 0; i < currentStep.length; i++) {
                if (currentStep[i] < Integer.MAX_VALUE && currentStep[i] > -1 && i + 1 < currentStep.length) {
                    for (int j = i + 1; j <= i + B && j < A.length; j++) {
                        if (A[j] > -1 && currentStep[i] + A[j] < nextStep[j]) {
                            nextStep[j] = currentStep[i] + A[j];
                            nextPath[j] = i;
                            if (currentStep[j] > -1 && currentStep[j] < nextStep[j]) {
                                nextStep[j] = currentStep[j];
                                nextPath[j] = path[j];
                            }
                        }
                    }
                } else if (i + 1 == currentStep.length && nextStep[i] > currentStep[i]) {
                    nextStep[i] = currentStep[i];
                    nextPath[i] = path[i];
                }
            }

            currentStep = Arrays.copyOf(nextStep, nextStep.length);
            path = Arrays.copyOf(nextPath, nextPath.length);
            for (int i = 0; i < currentStep.length; i++) {
                nextStep[i] = Integer.MAX_VALUE;
            }
        }

        List<Integer> result = new ArrayList<>();
        List<Integer> result2 = new ArrayList<>();
        if (currentStep[A.length - 1] < Integer.MAX_VALUE && currentStep[A.length - 1] > -1) {
            Stack<Integer> queue = new Stack<>();
            int index = A.length - 1;
            while (index > 0) {
                int next = path[index];
                queue.push(index + 1);
                index = next;
            }

            result.add(1);
            while (queue.size() > 0) {
                result.add(queue.pop());
            }

            for (int i = result.size() - 1; i >= 0; i--) {
                result2.add(A.length - result.get(i) + 1);
            }

            return result2;
        } else {
            return Collections.emptyList();
        }
    }
}
