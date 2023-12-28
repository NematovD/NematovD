package Imtihon;

import java.io.FileWriter;
import java.io.IOException;

public class Kerak {
        public static void main(String[] args) throws InterruptedException, IOException {

            FileWriter writer = new FileWriter("Fayle/Oquvchilar", true);
            writer.write("Doniyorbek\n");
            writer.close();
            System.out.println("text successfully added ");
        }
    }

