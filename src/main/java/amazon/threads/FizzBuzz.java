package amazon.threads;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Dauren Mussa
 * @since 2/4/18
 */
public class FizzBuzz {

    public static void main(String[] args) {
        NumberHolder numberHolder = new NumberHolder();

        Counter counter = new Counter(numberHolder, 100);

        FizzBuzzChecker fizzBuzzChecker = new FizzBuzzChecker(numberHolder);
        FizzChecker fizzChecker = new FizzChecker(numberHolder);
        BuzzChecker buzzChecker = new BuzzChecker(numberHolder);

        fizzChecker.start();
        buzzChecker.start();
        fizzBuzzChecker.start();

        counter.start();
    }

    static class NumberHolder {
        private AtomicInteger number = new AtomicInteger();

        public NumberHolder() {
            number.set(1);
        }

        public AtomicInteger getNumber() {
            return number;
        }
    }

    static class Counter extends Thread {

        private NumberHolder numberHolder;
        private int max;

        public Counter(NumberHolder numberHolder, int max) {
            this.numberHolder = numberHolder;
            this.max = max;
        }

        @Override
        public void run() {
            while (numberHolder.getNumber().getAndAdd(1) < max) {
                try {
                    synchronized (numberHolder) {
                        numberHolder.notifyAll();
                    }
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    static class FizzChecker extends Thread {
        private NumberHolder numberHolder;

        public FizzChecker(NumberHolder numberHolder) {
            this.numberHolder = numberHolder;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    synchronized (numberHolder) {
                        numberHolder.wait();
                    }
                    int number = numberHolder.getNumber().get();
                    if (number % 3 == 0 && number % 5 != 0) {
                        System.out.println("Fizz -> " + number);
                    }
                } catch (InterruptedException e) {
                }
            }
        }
    }

    static class BuzzChecker extends Thread {
        private NumberHolder numberHolder;

        public BuzzChecker(NumberHolder numberHolder) {
            this.numberHolder = numberHolder;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    synchronized (numberHolder) {
                        numberHolder.wait();
                    }
                    int number = numberHolder.getNumber().get();
                    if (number % 5 == 0 && number % 3 != 0) {
                        System.out.println("Buzz -> " + number);
                    }
                } catch (InterruptedException e) {
                }
            }
        }
    }

    static class FizzBuzzChecker extends Thread {
        private NumberHolder numberHolder;

        public FizzBuzzChecker(NumberHolder numberHolder) {
            this.numberHolder = numberHolder;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    synchronized (numberHolder) {
                        numberHolder.wait();
                    }
                    int currentNumber = numberHolder.getNumber().get();
                    if (currentNumber % 3 == 0 && currentNumber % 5 == 0) {
                        System.out.println("FizzBuzz -> " + currentNumber);
                    }
                } catch (InterruptedException e) {
                }
            }
        }
    }

}
