package Dars_3_18;

abstract class Shape {

    abstract double calculateArea();
}

class Circle extends Shape {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    double length;
    double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double calculateArea() {
        return length * width;
    }
}

class Triangle extends Shape {
    double base;
    double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    double calculateArea() {
        return 0.5 * base * height;
    }
}

public class Main2 {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        System.out.println("Doira maydoni: " + circle.calculateArea());

        Rectangle rectangle = new Rectangle(4, 8);
        System.out.println("To'rtburchak maydoni: " + rectangle.calculateArea());

        Triangle triangle = new Triangle(3, 6);
        System.out.println("Uchburchak maydoni: " + triangle.calculateArea());
    }
}
