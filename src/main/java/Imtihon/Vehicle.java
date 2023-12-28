package Imtihon;

public class Vehicle {
    public void speedUp(){
        System.out.println(" Main Class ");
    }
    public class Car extends Vehicle {
        @Override
        public void speedUp() {
            System.out.println("Doira o'lchandi");
        }

    }
    public class Bicycle extends Vehicle {
        @Override
        public void speedUp() {
            System.out.println("To'rtburchak o'lchandi");
        }
    }
}