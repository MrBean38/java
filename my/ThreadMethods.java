//lab7
class MyThread extends Thread {

    boolean stopped = false;

    public void run() {

        for (int i = 1; i <= 10; i++) {

            if (stopped)
                break;

            System.out.println("Thread: " + i);

            if (i == 3) {
                Thread.yield();
                System.out.println("Yield called");
            }

            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
    }

    void stopThread() {
        stopped = true;
    }
}

public class ThreadMethods {

    public static void main(String[] args) throws Exception {

        MyThread t = new MyThread();

        t.start();

        Thread.sleep(6000);

        t.stopThread();

        System.out.println("Thread Stopped");
    }
}