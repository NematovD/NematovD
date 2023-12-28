package Imtihon;

//package imtihon;
//
public class Person {
    private static String name;
    private static int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void show() {
        System.out.println("name: " + name + "\nage: " + age);
    }

}
