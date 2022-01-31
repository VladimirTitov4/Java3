package ru.titov.lesson3.objects.io.streams;

import java.io.Serial;
import java.io.Serializable;

public class Human implements Serializable {

    @Serial
    private static final long serialVersionUID = -2797844370655404141L;

    public int age;
    public /*transient*/ String lastName;

    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                '}';
    }
}
