package ru.titov.lesson1.generic;

import java.time.LocalDate;

public class TestGeneric {

    public static void main(String[] args) {
        /*GenericStorage<String> stringStorage = new GenericStorageImpl<>(5);
        stringStorage.add("first");
        stringStorage.add("second");
        stringStorage.display();*/

        GenericStorage<LocalDate> dateStorage = new GenericStorageImpl<>(5);
        dateStorage.add(LocalDate.parse("2020-01-01"));
        dateStorage.add(LocalDate.parse("2021-01-01"));
        dateStorage.add(LocalDate.parse("2022-01-01"));
        dateStorage.display();


        LocalDate valueLeft = dateStorage.min().getValueLeft();
        System.out.println("valueLeft = " + valueLeft);

    }
}
