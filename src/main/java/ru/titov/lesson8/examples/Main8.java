package ru.titov.lesson8.examples;

import ru.titov.lesson7.examples.User;
import ru.titov.lesson7.examples.annotation.TestAnnotation;

import java.util.ArrayList;
import java.util.List;

public class Main8 {

    public static void main(String[] args) {
/*
        int a = 5;
        Integer b;
        b = a;

        System.out.println(a);
        System.out.println(b);

        int c = new Integer(8);
        c = Integer.valueOf(8);
        System.out.println(c);

        System.out.println("args" + Arrays.toString(args));
        int serverPort = Integer.parseInt(args[0]);

        int aa;
//        System.out.println(aa);

//        User user = new User();
        System.out.println(user.age);
        System.out.println(user.itSpecialist);
        */
        labelExample();

        // <? super T>        любые родители класса Т
        // <T extends Number> любые наследники Number

        List<Object> objects = new ArrayList<>();

        User user = new User();
        System.out.println(user.hashCode());
        user.age = 44;
        System.out.println(user.hashCode());

        class LocalClass {
            private String field;

            public void print() {
                System.out.println("local class call");
            }
        }

        LocalClass localClass = new LocalClass();
        localClass.print();
    }

    public void cycles() {
        int i = 0;
        while (i < 100) {
            System.out.println(i);
            i++;
        }

        do {
            System.out.println("do");
            i++;
        } while (i < 2);

        for (; ; ) {

        }
    }

    public static void breakExample() {
        for (int i = 0; i < 10; i++) {
            if (i == 8) {
                break;
            }
            System.out.println(i);
        }
    }

    public static void continueExample() {
        for (int i = 0; i < 10; i++) {
            if (i == 8) {
                continue;
            }
            System.out.println(i);
        }
    }

    public static void labelExample() {
        boolean t = true;
        first:
        {
            second:
            {
                third:
                {
                    System.out.println("Перед оператором break");
                    if (t) {
                        break second;
                    }
                }
                System.out.println("Данная строка не отобразится");
            }
            System.out.println("блок first");
        }
    }
}
