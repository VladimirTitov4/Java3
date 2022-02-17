package ru.titov.lesson8.examples;

public class Truck extends Car {

    private static int a;
    private int b = 4;

    static {
        System.out.println("Truck static block");
        a = 10;
    }

    {
        System.out.println("Truck non-static block");
        b = 4;
    }

    public Truck() {
        System.out.println("Truck constructor");
    }

    public static void main(String[] args) {
        Truck truck = new Truck();
    }
}
