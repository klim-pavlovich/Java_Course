package ru.geekbrains.api.seminars.Seminar2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Calculator {

    static Scanner scanner = new Scanner(System.in);

    // throws IOException позволяет запустить программу без обработки ошибок
    public static void run() /* throws IOException */ {
        try {
            File logFile = new File("log.txt");
            FileWriter fileWriter = new FileWriter(logFile, true);

            for (int i = 0; i < 5; i++){
                fileWriter.write("hello" + i + '\n');
            }

            fileWriter.flush(); /*позволяет сразу сохранить данные файлы, а не хранить в буфере */
            fileWriter.close(); /*при закрытии flush работает автоматом, если не закроем - файлом нельзя будет пользоваться*/
            System.out.println("Введите первое число: ");
            double x = Double.parseDouble(scanner.nextLine());

            System.out.println("Введите операцию (+ - / *): ");
            char operation = scanner.nextLine().charAt(0);

            System.out.println("Введите второе число: ");
            double y = Double.parseDouble(scanner.nextLine());

            if (operation == '+') {
                System.out.printf("%.2f + %.2f = %.2f\n", x, y, plus(x, y));
            }

            if (operation == '-') {
                System.out.printf("%.2f - %.2f = %.2f\n", x, y, minus(x, y));
            }

            if (operation == '*') {
                System.out.printf("%.2f * %.2f = %.2f\n", x, y, multiply(x, y));
            }

            if (operation == '/') {
                System.out.printf("%.2f / %.2f = %.2f\n", x, y, divide(x, y));
            }
        } catch (Exception ex) {
             
        }

    }

    static double plus(double a, double b) {
        return a + b;
    }

    static double minus(double a, double b) {
        return a - b;
    }

    static double multiply(double a, double b) {
        return a * b;
    }

    static double divide(double a, double b) {
        return a / b;
    }
}