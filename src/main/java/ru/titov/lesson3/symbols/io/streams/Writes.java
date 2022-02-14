package ru.titov.lesson3.symbols.io.streams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Writes {

    private static final String FILE_NAME = "test_writer.txt";

    private static final String LATIN_SEQUENCE = "abxzABXZ";
    private static final String CYRIL_SEQUENCE = "абюяАБЮЯ";
    private static final String UNICODE_SPECIAL_SEQUENCE = "^½ቖ";

    public static void main(String[] args) throws Exception {
//        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME, StandardCharsets.UTF_8))) {
//            writer.println(LATIN_SEQUENCE);
//            writer.println(CYRIL_SEQUENCE);
//            writer.println(UNICODE_SPECIAL_SEQUENCE);
//        }

//        try (Scanner scanner = new Scanner(new FileReader("test_writer.txt"))) {
//            System.out.println(scanner.nextLine());
//            System.out.println(scanner.nextLine());
//            System.out.println(scanner.nextLine());
//        }
//
        try (BufferedReader reader = new BufferedReader(new FileReader("test_writer.txt"))) {
            System.out.println(reader.readLine());
            System.out.println(reader.readLine());
            System.out.println(reader.readLine());
        }
    }
}
