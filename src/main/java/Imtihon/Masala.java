package Imtihon;

public class Masala {
    public static void main(String[] args) {
        int a = 7;
        int b = 14;

        Summation summation = (x, y) -> x + y;

        int sum = summation.sum(a, b);

        System.out.println("Yig'indi: " + sum);
    }

    interface Summation {
        int sum(int x, int y);
    }
}

