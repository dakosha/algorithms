package amazon.threads;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Dauren Mussa
 * @since 2/4/18
 */
public class Philosophers {

    public static void main(String[] args) {
        int n = 5;
        List<Philosopher> philosophers = new LinkedList<>();

        List<Fork> forks = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            forks.add(new Fork(i + 1));
        }

        for (int i = 0; i < n; i++) {
            Fork lower = forks.get(i);
            Fork higher = null;
            if (i + 1 == n) {
                higher = forks.get(0);
            } else {
                higher = forks.get(i);
            }
            philosophers.add(new Philosopher(i + 1, lower, higher));
        }

        for (int i = 0; i < n; i++) {
            philosophers.get(i).start();
        }
    }

    static class Fork {
        private Lock lock;
        private int number;

        public Fork(int number) {
            this.lock = new ReentrantLock();
            this.number = number;
        }

        public void pickUp() {
            this.lock.lock();
        }

        public void putDown() {
            this.lock.unlock();
        }

        public int getNumber() {
            return number;
        }
    }

    static class Philosopher extends Thread {
        private Fork lower, higher;
        private int index;
        private int bites = 10;

        public Philosopher(int i, Fork left, Fork right) {
            index = i;
            if (left.getNumber() < right.getNumber()) {
                this.lower = left;
                this.higher = right;
            } else {
                this.lower = right;
                this.higher = left;
            }
        }

        public void chew() {
            System.out.println(this.index + " Philosopher eating...");
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
            }
        }

        public void pickUp() {
            lower.pickUp();
            higher.pickUp();
        }

        public void putDown() {
            higher.putDown();
            lower.putDown();
        }

        public void eat() {
            pickUp();
            chew();
            putDown();
        }

        @Override
        public void run() {
            for (int i = 0; i < bites; i++) {
                eat();
            }
        }
    }

}
