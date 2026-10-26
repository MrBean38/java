
 // Lab 5
class OperationThread extends Thread {

    boolean suspended = false;
    boolean stopped = false;

    synchronized void suspendThread() {
        suspended = true;
    }

    synchronized void resumeThread() {
        suspended = false;
        notify();
    }

    synchronized void stopThread() {
        stopped = true;
        suspended = false;
        notify();
    }

    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {

                synchronized (this) {
                    while (suspended && !stopped)
                        wait();

                    if (stopped)
                        break;
                }

                System.out.println("Thread: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Thread stopped.");
    }
}

public class ThreadOperation {

    public static void main(String[] args) throws InterruptedException {

        OperationThread t = new OperationThread();
        t.start();

        Thread.sleep(2000);
        t.suspendThread();
        System.out.println("Thread Suspended");

        Thread.sleep(2000);
        t.resumeThread();
        System.out.println("Thread Resumed");

        Thread.sleep(2000);
        t.stopThread();
        System.out.println("Thread Stopped");
    }
}
