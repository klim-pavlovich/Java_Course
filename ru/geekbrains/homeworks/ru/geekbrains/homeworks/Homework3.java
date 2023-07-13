package ru.geekbrains.homeworks;

import java.util.ArrayList;
import java.util.Random;

public class Homework3 {

//     Задание

// Пусть дан произвольный список целых чисел.

// 1) Нужно удалить из него чётные числа
// 2) Найти минимальное значение
// 3) Найти максимальное значение
// 4) Найти среднее значение

    static Random random = new Random();
    public static void main(String[] args) {
        task1();
    }

    static void task1(){
        ArrayList<Integer> startArrayList = new ArrayList<>();
        int size = random.nextInt(10,16);
        for (int i = 0; i < size; i++) {
            startArrayList.add(random.nextInt(-10,11));
        }
        System.out.println("Изначальный рандомный список: " + startArrayList);
        ArrayList<Integer> finalArrayList = new ArrayList<>();

        finalArrayList = deleteEvenNums(startArrayList);
        System.out.println("ArrayList без четных чисел: " + finalArrayList);
        
        Integer minValue = findMinValue(startArrayList);
        System.out.println("Минимальное значение в изначальном массиве: " + minValue);
        
        Integer maxValue = findMaxValue(startArrayList);
        System.out.println("Максимальное значение в изначальном массиве: " + maxValue);
        
        double averageValue = findAverageValue(startArrayList);
        System.out.println("Среднее значение в изначальном массиве: " + averageValue);
    }

    static ArrayList<Integer> deleteEvenNums(ArrayList<Integer> arrayList){
        ArrayList<Integer> finalArrayList = new ArrayList<>();
        int size = arrayList.size();

        for (int i = 0; i < size; i++) {
            if (arrayList.get(i) %2 !=0){
                finalArrayList.add(arrayList.get(i));
            }
        }
        return finalArrayList;
    }
    
    static int findMinValue(ArrayList<Integer> arrayList){
        int size = arrayList.size();
        int min = arrayList.get(0);
        for (int i = 1; i < size; i++) {
            if (arrayList.get(i) < min){
                min = arrayList.get(i);
            }
        }
        return min;
    }

    static int findMaxValue(ArrayList<Integer> arrayList){
        int size = arrayList.size();
        int max = arrayList.get(0);
        for (int i = 1; i < size; i++) {
            if (arrayList.get(i) > max){
                max = arrayList.get(i);
            }
        }
        return max;
    }

    static double findAverageValue (ArrayList<Integer> arrayList){
        int size = arrayList.size();
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum = sum + arrayList.get(i);
        }
        double averageValue = 0;
        averageValue = sum/size;
        return averageValue;        
    }
}
