package ru.titov.lesson7.examples;

import java.lang.reflect.Modifier;

public class TestClass {

    public static void main(String[] args) {
        String str = "Java";
        Class<? extends String> clazz = str.getClass();

        System.out.println(clazz.getName());
        System.out.println(clazz.getSimpleName());

        int modifiers = clazz.getModifiers();

        if (Modifier.isPublic(modifiers)) {
            System.out.println("String is public");
        }

        if (Modifier.isFinal(modifiers)) {
            System.out.println("String is final");
        }

        if (Modifier.isAbstract(modifiers)) {
            System.out.println("String is abstract");
        }


    }
}
