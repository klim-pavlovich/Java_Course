package ru.geekbrains.api.seminars.Seminar3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Seminar3{


    static Random random = new Random();

    // РЕШЕНИЕ ЗАДАЧ
    // Заполнить список десятью случайными числами
    // Отсортировать список методом sort() и вывести его на экран.

    static void task1(){
        ArrayList<Integer> arrayList = new ArrayList<>();
        int size = random.nextInt(10,21);
        for (int i = 0; i < size; i++){
            arrayList.add(random.nextInt(-9,10));
        }
        System.out.println("До сортировки: " + arrayList);
        Collections.sort(arrayList);
        System.out.println("После сортировки: " + arrayList);
    }

    // Задача 2
    // Каталог товаров книжного магазина сохранен в виде двумерного
    // списка ArrayList<ArrayList<String>> так, что на 8й позиции каждого внутреннего списка
    // содержится название жанра, а на остальных позициях - названия книг.
    // Напишите метод для заполнения данной структуры.

    static ArrayList<ArrayList<String>> catalog = new ArrayList<>();


    static void task2(){
        addBook("Поэма","Книга #1");
        addBook("Поэма","Книга #2");
        addBook("Поэма","Книга #3");
        addBook("Пьеса","Книга #1");
        addBook("Пьеса","Книга #15");

        printCatalog();

    }

    static void addBook(String genre, String bookName){
        for (ArrayList<String> books : catalog){
            if (books != null && books.size() > 0 && books.get(0).equals(genre)){
                books.add(bookName);
                return;
            }
        }
        ArrayList<String> books = new ArrayList<>();
        books.add(genre);
        books.add(bookName);
        catalog.add(books);
    }

    static void printCatalog(){
        int i = 0;
        boolean f = true;
        while (f){
            f = false;
            for (ArrayList<String> books : catalog){
                if(books != null && books.size() > i){
                    f = true;
                    System.out.printf("%s\t\t", books.get(i));
                }
        }
        System.out.println();
        i++;
        }
    }
    public static void main(String[] args) {
        
        task2();


        task1();
        Person person1 = new Person();
        person1.name = "User1";
        person1.age = 16;

        Person person2 = new Person();
        person2.name = "User2";
        person2.age = 16;

        System.out.println(person1);
        System.out.println(person2);

        // Про сравнение строк: вернется true, тк компилятор создат один объект
        // а str1 и str2 будут ссылаться на этот объект
        String str1 = "Hello!";
        String str2 = "Hello!";
        System.out.println(str1==str2);
        // И даже если склеивать строку, компилятор сначала склеит ее, увидет, что
        // есть объект с таким значеним и сошлется на него
        String str3 = "He" + "ll" + "o!";
        System.out.println(str2 == str3);
        // Для создания уникального объекта используем конструктор
        String str4 = new String("Hello!");
        System.out.println(str4==str3);
        // Но если будем использовать equals, то вернется try () {
        System.out.println(str1.equals(str4));


        
        // // Пример ссылочного сравнения, всегда будут разные (искл. если в одном из объектов ссылка на другой сравниваемый объект)
        // System.out.println(person1 == person2);
        // // Если не задать стратегию сравнению то equals также сравнит ссылки на объекты
        // System.out.println(person1.equals(person2));
        // // Сравнение с стратегией (переделал equals (предыдущий закомментировал))
        // System.out.println(person1.equals(person2));


        // Коллекции теория
        // Коллекции бывают двух видов: обобщенные и необобщенные
        // необобщенные коллекции: ArrayList
        ArrayList arrayList1 = new ArrayList();
        // работает с object, можно запихнуть что-угодно
        arrayList1.add(false);
        arrayList1.add(person1);
        arrayList1.add("text");
        arrayList1.add(123);

        // Отработает только
        // arrayList2.add(person1);
        // Не сработает с:
        // arrayList2.add(false);
        // arrayList2.add("text");
        // arrayList2.add(123);

        doProcess(arrayList1);
     
        
        // Указываем тип коллекции
        ArrayList<Person> arrayList2 = new ArrayList<>();


        MyArrayList<Person> myArrayList = new MyArrayList(new Person[5]);
        myArrayList.add(person1);
        myArrayList.add(person2);

    }

    static void doProcess(ArrayList list){
        for (Object o : list){
            // Пример даункастинга - преобразование вниз от супер класс к классу наследнику
            // (небезопасная процедура) защищаем себя с instanceof
            if (o instanceof Person){
                Person p = (Person)o;
                // теперь даункастинг безопасен
                System.out.println("Возраст: " + p.age );
            }

        }
    }
}


class Person{
    String name;
    int age;


    // @Override
    // public boolean equals(Object obj){
    //     return super.equals(obj);
    // }

    // Сравнение с установлением стратегии сравнения
    @Override
    public boolean equals(Object obj){
        // instanceof позволяет проверить на основе какого типа был создан объект
        if (obj instanceof Person){
            // приведение к типу
            Person p = (Person)obj;
            if(age == p.age){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }
    // Расширение базовых методов языка (в Си подобных - только виртуальные, в Java - все)
    @Override
    public String toString(){
        // с помощью super можно совершить вызов/указать члены базового типа 
        // return super.toString();
        return "[" + name + ";" + age + "]";

    }
}

// Обобщенные коллекции
// В <универсальный параметр>
class Person_gen <T>{
    String name;
    int age;
    @Override
    public boolean equals(Object obj){
        // instanceof позволяет проверить на основе какого типа был создан объект
        if (obj instanceof Person){
            // приведение к типу
            Person p = (Person)obj;
            if(age == p.age){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }
    // Расширение базовых методов языка (в Си подобных - только виртуальные, в Java - все)
    @Override
    public String toString(){
        // с помощью super можно совершить вызов/указать члены базового типа 
        // return super.toString();
        return "[" + name + ";" + age + "]";

    }
}


// Обобщенный класс
class MyArrayList <E>{

    int index = -1;
    E[] array;

    public MyArrayList(E[] baseArray){
        array = baseArray;
    }

    public MyArrayList(int capacity){
        array = new int[capacity];
    }
    
    public void add(E i){
        array[++index] = i;
    }
}