package ru.titov.lesson7.examples;

import java.util.Objects;

public class User {

    public int age;
    public boolean itSpecialist;

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && itSpecialist == user.itSpecialist;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, itSpecialist);
    }
}
