package Imtihon;

public class CounterExample {
    private static int counter = 0;

    public static void main(String[] args) {
        Thread thread1 = new CounterThread("Thread 1");
        Thread thread2 = new CounterThread("Thread 2");
        Thread thread3 = new CounterThread("Thread 3");

        thread1.start();
        thread2.start();
        thread3.start();
    }

    private synchronized static void incrementCounter() {
        counter++;
        System.out.println(Thread.currentThread().getName() + " | Counter: " + counter);
    }

    private static class CounterThread extends Thread {
        public CounterThread(String name) {
            super(name);
        }

        public void run() {
            for (int i = 0; i < 5; i++) {
                incrementCounter();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
