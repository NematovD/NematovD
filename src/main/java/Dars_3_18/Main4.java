package Dars_3_18;

public class Main4 {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            System.out.println("Hello World");
        });

        t.start();
    }
}

