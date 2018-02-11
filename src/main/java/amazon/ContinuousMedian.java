package amazon;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author Dauren Mussa
 * @since 2/7/18
 */
public class ContinuousMedian {

    public static void main(String[] args) {

        Random random = new Random();
        for (int i=0; i<50; i++) {
            int cur = random.nextInt(1000);
            median(cur);
        }

        System.out.println(max);
        System.out.println(min);
    }

    static double currentMedian = 0;
    static int currentCount = 0;

    static Comparator<Integer> maxComparator = (val1, val2) -> val1 - val2;
    static Comparator<Integer> minComparator = (val1, val2) -> val2 - val1;

    static PriorityQueue<Integer> max = new PriorityQueue<>(maxComparator);
    static PriorityQueue<Integer> min = new PriorityQueue<>(minComparator);

    static double storeMedian(int number) {
        double currentNumber = currentCount * currentMedian;
        currentNumber += number;
        currentCount++;
        currentMedian = currentNumber / currentCount;
        return currentMedian;
    }


    static int median(int number) {
        max.add(number);
        min.add(number);
        return (max.peek() + min.peek()) / 2;
    }


}
