package ru.geekbrains.api.lesson2.Seminar2;

import java.io.IOException;
import java.util.UUID;

public class Program {
    public static void main(String[] args) /*throws IOException*/ {
        Calculator.run();
        // task1();
        // System.out.println(task2());
    }

    // Работа со строками
    /**
     * Задача:
     * На вход программы подаются произвольные алфавитно-цифровые символы.
     * Требуется написать программу, которая будет печатать последовательность
     * строчных английских букв ('a' 'b'... 'z')
     * из входной последовательности и частот их повторения.
     * Печать должна происходить в алфавитном порядке. Например, пусть на вход
     * подаются следующие символы:
     * fhb5234SSDSFsfsdfskbfsh.fmsdfsdf.
     * '.' - завершение последовательности, всё что после точки - не считываем
     * В этом случае программа должна вывести:
     * b2
     * f3
     * h2
     * k1
     * m1
     * s1
     */
    static String task2() {
        String inputStr = "fhb5234SSDSFsfsdfskbfsh.fmsdfsdf";
        int[] statistic = new int[26];
        int cA = 'a';
        int code;
        char c;
        for (int i = 0; i < inputStr.length(); i++) {
            c = inputStr.charAt(i);
            code = c;
            if (c >= 'a' && c <= 'z') {
                statistic[code - cA]++;
            }
            if (c == '.'){
                break;
            }
        }
        System.out.println("Результат работы приложения:");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < statistic.length; i++) {
            if (statistic[i] > 0) {
                char cc = (char) (i + cA);
                stringBuilder
                        .append(cc)
                        .append(statistic[i])
                        .append('\n');
            }
        }
        return stringBuilder.toString();
    }

    static void task1() {
        int a = 12;
        double b = 14.5;
        String str = "AAA" + "888" + a + "CCC" + b;
        // System.out.println(UUID.randomUUID());
        String buf = "";
        // Засекаем время в мс
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 30000; i++) {
            buf += UUID.randomUUID();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Операция выполнена за " + (endTime - startTime) + "мс.");

        // О StringBuilder, для добавления - append
        buf = "";
        startTime = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        // Кроме того, можно добавлять начальное значение строки и указать начальный
        // capacity (емкость)
        StringBuilder stringBuilder2 = new StringBuilder(1000);
        for (int i = 0; i < 30000; i++) {
            stringBuilder.append(UUID.randomUUID());
        }
        endTime = System.currentTimeMillis();
        System.out.println("Операция выполнена за " + (endTime - startTime) + "мс.");

        // Для того, чтобы после Билдера пользоваться методами строки используем
        // ToString
        // String str1 = stringBuilder.toString();
        // str1.метод
        // Для изменения строки - StringBuilder, для поиска или проверки в строке -
        // String

    }
}