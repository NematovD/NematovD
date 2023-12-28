package Dars_3_18;

import java.util.concurrent.atomic.AtomicInteger;

public class Main5 {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger counter =new AtomicInteger();

        Thread thread1 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                counter.incrementAndGet();
            }
        });
        Thread thread2 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                counter.incrementAndGet();
            }});

        thread1.start();
        thread1.join();

        thread2.start();
        thread2.join();

        System.out.println("  : " + counter);
    }

}
