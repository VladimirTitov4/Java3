package ru.titov.lesson8.examples;

public class TestStatic {

    private static int a;
    private int b;

    static {
        System.out.println("static block call");
        a = 5;
    }

    {
        System.out.println("non-static block call");
        b = 3;
    }

    public TestStatic() {
        System.out.println("constructor call");
    }

    public static void main(String[] args) {
        TestStatic testStatic = new TestStatic();
        System.out.println(testStatic.a);
        System.out.println(testStatic.b);
    }

}
