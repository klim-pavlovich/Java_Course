package ru.geekbrains.homeworks;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

// 3. В калькулятор (урок 1 и 2) добавьте возможность отменить последнюю операцию.

public class CalculatorUpgraded {
    static Scanner scanner = new Scanner(System.in);
    static double result = 0;
    static Deque<Character> operationsDeque = new ArrayDeque<>();
    static Deque<Double> resultsDeque = new ArrayDeque<>();

    public static void run() {
        System.out.println("Введите первое число: ");
        double result = getValidDouble();
        boolean continueCalculations = true; // Флаг для контроля выполнения цикла

        while (continueCalculations) {
            System.out.println("Введите операцию (+ - / * или ~ для отмены операции): ");
            char operation = getValidOperation();

            if (operation == '~') {
                if (resultsDeque.isEmpty()) {
                    System.out.println("Предыдущий результат отсутствует. Введите новую операцию.");
                } else {
                    resultsDeque.pollLast();
                    result = resultsDeque.pollLast(); 
                    System.out.println("Отмена операции. Предыдущий результат: " + result);
                    System.out.println("Желаете продолжить? Отправьте 'y' для продолжения или любой другой символ для завершения работы калькулятора.");
                    String choice = scanner.nextLine();
                    continueCalculations = choice.equalsIgnoreCase("y");
                    continue;
                }
            }

            System.out.println("Введите второе число: ");
            double y = getValidDouble();

            if (operation == '+') {
                result = plus(result, y);
            } else if (operation == '-') {
                result = minus(result, y);
            } else if (operation == '*') {
                result = multiply(result, y);
            } else if (operation == '/') {
                result = divide(result, y);
            }
            
            resultsDeque.addLast(result);
            operationsDeque.addLast(operation);

            System.out.println("Результат: " + result);
            System.out.println("Желаете продолжить? Отправьте 'y' для продолжения или любой другой символ для завершения работы калькулятора.");
            String choice = scanner.nextLine();
            continueCalculations = choice.equalsIgnoreCase("y");
        }
    }

    static double getValidDouble() {
        while (true) {
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Неверный ввод числа. Повторите попытку.");
                continue;
            }
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат числа. Повторите попытку.");
            }
        }
    }

    static char getValidOperation() {
        while (true) {
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Неверный ввод операции. Повторите попытку.");
                continue;
            }
            char operation = input.charAt(0);
            if (operation == '+' || operation == '-' || operation == '*' || operation == '/' || operation == '~') {
                return operation;
            } else {
                System.out.println("Неверная операция. Повторите попытку.");
            }
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
