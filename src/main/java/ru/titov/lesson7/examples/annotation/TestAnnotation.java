package ru.titov.lesson7.examples.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@MarkingAnnotation
public class TestAnnotation {

    @MarkingAnnotation
    private String title;

    @MarkingAnnotation
    public void method() {
        System.out.println("Hello world");
    }

    @MarkingAnnotation(type = "customType", value = 111111.f)
    public void print(String word, float value) {
        System.out.println("Word: " + word);
        System.out.println("Value: " + value);
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        @MarkingAnnotation TestAnnotation test = new TestAnnotation();

        Method printMethod = test.getClass().getMethod("print", String.class, float.class);

        if (printMethod.isAnnotationPresent(MarkingAnnotation.class)) {
            MarkingAnnotation annotation = printMethod.getAnnotation(MarkingAnnotation.class);
            printMethod.invoke(test, annotation.type(), annotation.value());
        }

    }

}
