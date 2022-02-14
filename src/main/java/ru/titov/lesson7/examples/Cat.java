package ru.titov.lesson7.examples;

public class Cat extends SuperCat implements ICat{

    public String color;
    private int age = 10;

    public final boolean kitty;

    public Cat(String name, String color, int age, boolean kitty) {
        super(name);
        this.color = color;
        this.age = age;
        this.kitty = kitty;
    }

    public Cat(String name) {
        super(name);
        this.kitty = true;
    }

    public Cat(String name, int age) {
        super(name);
        this.age = age;
        this.kitty = true;
    }


    @Override
    public void meow(int db) {
        System.out.println(name + " : meow - " + db + " db");
    }

    private void jump() {
        System.out.println(name + " :jump");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "color='" + color + '\'' +
                ", age=" + age +
                ", kitty=" + kitty +
                ", name='" + name + '\'' +
                '}';
    }
}
