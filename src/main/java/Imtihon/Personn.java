package Imtihon;

public class Personn {
    private String name;
    private int age;

    public Personn(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void show() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public static void main(String[] args) {
        // Person obyektini yaratish va qiymat bermoq
        Personn person1 = new Personn("John", 25);

        // Qiymatlarni ekranga chop etish
        person1.show();
    }
}
