package ru.titov.lesson8.examples;

public class Car {

    private static int a;
    private int b;

    static {
        System.out.println("Car static block");
        a = 10;
    }

    {
        System.out.println("Car non-static block");
        b = 4;
    }

    public Car() {
        System.out.println("Car constructor");
    }
}
