package kesha;

/**
 * @author Dauren Mussa
 * @since 10/19/17
 */
public class WorkerThread implements Runnable {

    public static void main(String[] args) throws Exception {
        Thread a = new Thread(new WorkerThread());
        Thread b = new Thread(new WorkerThread());
        Thread c = new Thread(new WorkerThread());
        Thread d = new Thread(new WorkerThread());
        Thread e = new Thread(new WorkerThread());

        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }

    public void letOnlyOneThreadAtATime() throws InterruptedException {
        synchronized (this) {
            System.out.println("Entered thread" + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("Exited thread" + Thread.currentThread().getName());
        }
    }

    @Override
    public void run() {
        try {
            letOnlyOneThreadAtATime();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}