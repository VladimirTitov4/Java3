package ru.titov.lesson3.objects.io.streams;

import java.io.*;

public class ObjectStreamMain {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person p1 = new Person("p1");
        Person p2 = new Person("p2");
        Person p3 = new Person("friend");

        p1.age = 25;
        p3.age = 18;

        p1.friend = p3;
        p2.friend = p3;

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("objects.txt")));
        out.writeObject(p1);
        out.writeObject(p2);
        out.close();

        System.out.println("--------");

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("objects.txt"));
        Person p4 = (Person) in.readObject();
        Person p5 = (Person) in.readObject();
        in.close();

        System.out.println(p4);
        System.out.println(p5);
        System.out.println(p5.friend);
        System.out.println(p4.friend);
    }

}
