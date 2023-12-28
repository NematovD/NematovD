package Dars_3_18;

import java.util.Arrays;
import java.util.List;

public class Main3 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3, 6, 8, 10, 18, 36);

        double average = numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();

        System.out.println("Ro'yxatning o'rtacha ko'rsatkichi:: " + average);
    }
}
