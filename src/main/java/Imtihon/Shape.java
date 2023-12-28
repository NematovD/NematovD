package Imtihon;

public class Shape {
    public void calculateArea(){
        System.out.println(" asosiy sinf shakli ");
    }
    public class Circle extends Shape{
        @Override
        public void calculateArea() {
            System.out.println("Doira o'lchandi");
        }

    }
    public class Rectangle extends Shape{
        @Override
        public void calculateArea() {
            System.out.println("To'rtburchak o'lchandi");
        }
    }    public class Triangle extends Shape{
        @Override
        public void calculateArea() {
            System.out.println("Uchburchak o'lchandi");
        }
    }
}