package ru.titov.lesson7.examples;

import java.lang.reflect.*;

public class TestCat {

    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        ICat cat = new Cat("Barsik", "black", 7, true);

        Class<? extends ICat> clazz = cat.getClass();

//        for (Field field : clazz.getDeclaredFields()) {
//            field.setAccessible(true);
//            System.out.println(String.format("%s Type '%s' for field '%s' value = %s",
//                    getAccessModifier(field),
//                    field.getType().getSimpleName(),
//                    field.getName(),
//                    field.get(cat)));
//        }

//        changeAge(cat);
//        changeKitty(cat);

//        for (Method declaredMethod : clazz.getDeclaredMethods()) {
//            System.out.println(getAccessModifier(declaredMethod) + " "
//                    + declaredMethod.getReturnType() + " "
//                    + declaredMethod.getName() + " "
//                    + Arrays.toString(declaredMethod.getParameterTypes()));
//
//        }

//        Method jump = clazz.getDeclaredMethod("jump");
//        jump.setAccessible(true);
//        jump.invoke(cat); // cat.jump();
//
//
//        Method meow = clazz.getDeclaredMethod("meow", int.class);
//        meow.setAccessible(true);
//        meow.invoke(cat, 50);

//        for (Constructor<?> declaredConstructor : clazz.getDeclaredConstructors()) {
//            System.out.println(declaredConstructor);
//        }

//        Constructor<? extends ICat> declaredConstructor = clazz.getDeclaredConstructor(String.class, String.class, int.class, boolean.class);
//        ICat cat2 = declaredConstructor.newInstance("catName", "white", 4, true);
//        System.out.println(cat2);
//
//        clazz.newInstance();
//
//        for (Class<?> anInterface : clazz.getInterfaces()) {
//            System.out.println("Is interface: " + anInterface.isInterface());
//            System.out.println(anInterface.getSimpleName());
//        }

        printAllSuperclasses(clazz);

    }

    private static String getAccessModifier(Method method) {
        if (Modifier.isPublic(method.getModifiers())) {
            return "Public";
        }
        else if (Modifier.isProtected(method.getModifiers())) {
            return "Protected";
        }
        else if (Modifier.isPrivate(method.getModifiers())) {
            return "Private";
        }
        else {
            return "Default";
        }
    }

    private static String getAccessModifier(Field field) {
        if (Modifier.isPublic(field.getModifiers())) {
            return "Public";
        }
        else if (Modifier.isProtected(field.getModifiers())) {
            return "Protected";
        }
        else if (Modifier.isPrivate(field.getModifiers())) {
            return "Private";
        }
        else {
            return "Default";
        }
    }

    private static void changeAge(ICat cat) throws NoSuchFieldException, IllegalAccessException {
        Field ageField = cat.getClass().getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.setInt(cat, 17);

        System.out.println(cat);
    }

    private static void changeKitty(ICat cat) throws NoSuchFieldException, IllegalAccessException {
        Field cattyField = cat.getClass().getDeclaredField("kitty");
        cattyField.setAccessible(true);
        System.out.println("kitty is " + cattyField.get(cat));

        cattyField.set(cat, false);
        System.out.println(cat);

        //Change static
    }

    private static void printAllSuperclasses(Class<? extends ICat> clazz) {
        Class<?> currentClass = clazz;
        while (currentClass != null) {
            System.out.println(currentClass.getSimpleName());
            System.out.println("Superclass is abstract: " + Modifier.isAbstract(currentClass.getModifiers()));
            currentClass = currentClass.getSuperclass();
        }
        System.out.println();
    }
}
