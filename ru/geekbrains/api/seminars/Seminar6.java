package ru.geekbrains.api.seminars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import javax.naming.LimitExceededException;
import javax.print.attribute.HashAttributeSet;

public class Seminar6 {
    
private static Random random = new Random(0);

    public static void main(String[] args) {
        // task1();
        // task2();
        task3();
        
    }

    // Задача на работу с классом Дробь
    static void task3(){

        Fraction fraction1 = new Fraction();

        Fraction fraction2 = new Fraction(1,4);
        fraction2.setNumerator(5);
        fraction2.setDenominator(4);

        fraction1.plus(fraction2);
        // Первый способ
        // System.out.printf("%s + %s = %s\n", fraction1,fraction2,fraction1.plus(fraction2));
        // Второй способ
        System.out.printf("%s + %s = %s\n", fraction1,fraction2,Fraction.plus(fraction1, fraction2));

        HashSet<Fraction> hashSet = new HashSet<>();
        hashSet.add(new Fraction(3,4));
        hashSet.add(new Fraction(-1,2));
        hashSet.add(new Fraction(2,5));
        hashSet.add(new Fraction(3,4));
        hashSet.add(new Fraction(6,8));
        hashSet.add(new Fraction(3,4));
        System.out.println(new Fraction(3,4).equals(new Fraction(3,4)));
        System.out.println(hashSet);



        // System.out.println(fraction2.getNumerator());     
        // System.out.println(fraction1);
        // System.out.println(fraction2);

    }


    // Задача:
    // 1. Напишите метод, который заполнит массив из 1000 элементов Случайными цифрами от 0 до 24.
    // 2. Создайте метод, в который передайте заполненный выше массив u с помощью Set
    // вычислите процент уникальных значений в данном массиве
    // и верните его в виде числа с плавающей запятой.
    // Для вычисления процента используйте формулу:
    // процент уникальных чисел = количество уникальных чисел * 100 / общее количество чисел в массиве.


    public static void task2(){
        Integer[] array = new Integer[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(25);
        }
        findPercentageOfUniqueValues(array);
    }

    public static void findPercentageOfUniqueValues(Integer[] array){
        HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(array));
        // С перегрузкой с ограниченной емкостью
        // hashSet.addAll(Arrays.asList(array));
        System.out.println("% уникальных чисел: " + (double)hashSet.size() * 100 / array.length);
    }

    public static void task1(){
        HashSet<Integer> hashSet = new HashSet<>();
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        int size = random.nextInt(10,21);
        System.out.println("Общее кол-во элементов: " + size);
        System.out.println("Случайные числа:");
        for (int i = 0; i < size; i++){
            int number = random.nextInt(-9,10);
            System.out.printf("%d ", number);
            hashSet.add(number);
            linkedHashSet.add(number);
            treeSet.add(number);
        }
        System.out.println();
        System.out.println("HashSet" + hashSet);
        System.out.println("LinkedHashSet" + linkedHashSet);
        System.out.println("TreeSet" + treeSet);
    }
}
