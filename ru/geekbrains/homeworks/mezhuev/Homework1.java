package ru.geekbrains.homeworks.mezhuev;

import java.util.Arrays;
import java.util.Scanner;

public class Homework1 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean allTasks = true;
        int userInput;
        
        while (allTasks) {
            System.out.println("Введите номер задачи: ");
            System.out.println("1 - Задача 1 (Треугольник)");
            System.out.println("2 - Задача 2 (Простые числа до 1000)");
            System.out.println("3 - Задача 3 (Калькулятор)");
            System.out.println("0 - Завершение работы приложения");
            String tmp = "";
            while (tmp == "") {
                tmp = scanner.nextLine();
            }
            userInput = Integer.parseInt(tmp);

            switch (userInput) {
                case 1:
                    task1();
                    break;
                case 2:
                    task2();
                    break;
                case 3:
                    Calculator.runCalculator();
                    break;
                case 0:
                    System.out.println("Завершение работы приложения.");
                    allTasks = false;
                    break;
                default:
                    System.out.println("Некорректный номер задачи,\nповтори попытку ввода.");
                    break;
            }
            if (!allTasks) {
                break;
            }
        }
    }

    // Задача 1. Вычислить n-ое треугольного число (сумма чисел от 1 до n), n!
    // (произведение чисел от 1 до n)

    public static void task1() {
        boolean exitFirstTask = false;
        int userInputInTask1;
        while (!exitFirstTask) {
            System.out.println("Для нахождения количества точек, которые могут быть расставлены в n-ом правильном треугольнике, Вам будет предложено ввести длину ребра.");
            System.out.println("Если хотите запустить выполнение задачи - нажмите 1, выйти в главное меню - 0");
            userInputInTask1 = Integer.parseInt(scanner.nextLine());
            // int noTask1 = Integer.parseInt(scanner.nextLine());
            switch (userInputInTask1) {
                case 1:
                    System.out.print("Введите длину ребра правильного треугольника целым числом: ");
                    int numFromUser = scanner.nextInt();
                    scanner.nextLine();
                    int sumOfPoints = 0;
                    sumOfPoints = (int) (0.5 * numFromUser * (numFromUser + 1));
                    System.out.printf("Сумма точек в правильном треугольнике, длина ребра которого %d, равна %d\n",
                            numFromUser, sumOfPoints);
                    break;
                case 0:
                    System.out.println("Завершение работы с задачей 1.");
                    exitFirstTask = true;
                    break;
                default:
                    System.out.println("Некорректный выбор. Попробуйте еще раз.");
                    break;
            }
            if (exitFirstTask) {
                return;
            }
        }
    }

    // Задача 2. Вывести все простые числа от 1 до 1000

    public static void task2() {
        System.out.println("Все простые число от 1 до 1000 *(1 - не является простым числом)");
        int[] arrayWithPrimeNums = new int[0];
        for (int num = 1; num <= 1000; num++) {
            if (isPrime(num)) {
                arrayWithPrimeNums = Arrays.copyOf(arrayWithPrimeNums, arrayWithPrimeNums.length + 1);
                arrayWithPrimeNums[arrayWithPrimeNums.length - 1] = num;
            }
        }
        System.out.println(Arrays.toString(arrayWithPrimeNums));
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Задача 3. Реализовать простой калькулятор

    static class Calculator {
        public static void runCalculator() {
            System.out.println("Вы открыли калькулятор");
            boolean exitCalculator = false;
            int userInputInCalculatorMenu;
            while (!exitCalculator) {
                System.out.println("Введите номер действия: ");
                System.out.println("1 - Сложение");
                System.out.println("2 - Вычитание");
                System.out.println("3 - Умножение");
                System.out.println("4 - Деление");
                System.out.println("0 - Выйти из калькулятора и вернуться к меню с дз");
                userInputInCalculatorMenu = getNumberFromUserInt("Введите номер действия");
                if (userInputInCalculatorMenu >= 1 && userInputInCalculatorMenu <= 4) {
                    double a = getNumberFromUserDouble("Введите первое число");
                    double b = getNumberFromUserDouble("Введите второе число");
                    switch (userInputInCalculatorMenu) {
                        case 1:
                            add(a, b);
                            break;
                        case 2:
                            subtract(a, b);
                            break;
                        case 3:
                            multiply(a, b);
                            break;
                        case 4:
                            divide(a, b);
                            break;
                    }}
                else if (userInputInCalculatorMenu == 0){
                    System.out.println("Завершение работы калькулятора");
                    exitCalculator = true;
                    return;
                }
                else{
                    System.out.println("Некорректный выбор. Попробуйте еще раз.");
                }
                // if (exitCalculator){
                //     break;
                // }
            }
        }

        public static int getNumberFromUserInt(String message) {
            System.out.println(message);
            return scanner.nextInt();
        }

        public static double getNumberFromUserDouble(String message) {
            System.out.println(message);
            return scanner.nextDouble();
        }

        public static void add(double a, double b) {
            double res = a + b;
            if (res % 1 == 0) {
                System.out.printf("Сумма чисел %.0f и %.0f равна %.0f\n", a, b, res);
            } else {
                System.out.printf("Сумма чисел %.2f и %.2f равна %.2f\n", a, b, res);
            }
        }

        public static void subtract(double a, double b) {
            double res = a - b;
            if (res % 1 == 0) {
                System.out.printf("Разность чисел %.0f и %.0f равна %.0f\n", a, b, res);
            } else {
                System.out.printf("Разность чисел %.2f и %.2f равна %.2f\n", a, b, res);
            }
        }

        public static void multiply(double a, double b) {
            double res = a * b;
            if (res % 1 == 0) {
                System.out.printf("Произведение чисел %.0f и %.0f равно %.0f\n", a, b, res);
            } else {
                System.out.printf("Произведение чисел %.2f и %.2f равно %.2f\n", a, b, res);
            }
        }

        public static void divide(double a, double b) {
            double res = a / b;
            if (res % 1 == 0) {
                System.out.printf("Частное чисел %.0f и %.0f равно %.0f\n", a, b, res);
            } else {
                System.out.printf("частное чисел %.2f и %.2f равно %.2f\n", a, b, res);
            }
        }
    }
}
