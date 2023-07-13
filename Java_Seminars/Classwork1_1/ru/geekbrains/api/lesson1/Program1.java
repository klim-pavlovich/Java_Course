package Java_Seminars.Classwork1_1.ru.geekbrains.api.lesson1;

import java.util.Scanner;

public class Program1{

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Укажите номер задачи: ");
        System.out.println("1 - Задача 1");
        System.out.println("2 - Задача 2");
        System.out.println("3 - Задача 3");
        System.out.println("0 - Задача 0 - Завершение работы приложения");
        int no = Integer.parseInt(scanner.nextLine());
        
        boolean f = true;
        while(f){
            switch(no){
            case 2:
                task2();
            case 1:
                printName();
            case 3:
                task3("Добро пожаловать на курс по Java");
            case 0:
                System.out.println("Завершение работы приложения.");
                f = false;
                break;
            default:
                System.out.println("Некорректный номер задачи,\nповтори попытку ввода.");
            break;
        }
        // printName();
        // task2();
        task3("Добро пожаловать на курс по Java");
    }
        }

    // Во фразе "Добро пожаловать на курс по Java" переставить слова в обратном порядке и вывести на экран
    public static void task3(String str){

        String[] words = str.split(" ");
        for (int i = words.length - 1; i >= 0; i--){
            System.out.printf("%s ", words[i]);
        }
        System.out.println();
    }



    static void printName(){
        System.out.print("Введите ваше имя: ");
        String name = scanner.nextLine();
        System.out.println("Привет, " + name + "!");
    }

    // Дан массив двоичных чисел [1,1,0,1,1,1,0,1], вывести
    // максимальное количество подряд идущих 1.
     static void task2(){
        int[] array = new int[5];

        int counter = 0;
        int max = 0;

        // про ++ перед и после переменной
        // int a = ++counter;
        // System.out.println(++counter);
        // counter = a = 1
        // int b = counter ++;
        // System.out.println(counter++);
        // b = 0, counter = 1

        // первый способ задать фиксированный список с фикс значениями
        array[0] = 1;
        array[1] = 1;
        array[2] = 0;
        array[3] = 1;
        array[4] = 0;
        // либо
        int[] array1 = {1,1,0,1,1,1,0,1};
        for (int e : array1){
            if (e==1)
                counter++;
            else{
                if (counter> max)
                    max = counter;
                counter = 0;
            }
        }

        System.out.printf("Максимальное кол-во подряд идущих единиц: %d\n", max);
     }

}