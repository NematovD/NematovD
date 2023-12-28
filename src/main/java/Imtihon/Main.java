package Imtihon;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 6, 8, 10, 18, 36};

        double average = calculateAverage(numbers);

        System.out.println("Shu sonlarning o'rtacha qiymati: " + average);
    }

    public static double calculateAverage(int[] numbers) {
        return Arrays.stream(numbers)
                .average()
                .orElse(0.0);
    }
}
