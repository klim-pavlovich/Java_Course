package ru.geekbrains.homeworks;

import java.util.Scanner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import java.util.HashMap;
import java.util.Map;



// Задание
// Написать простой класс Телефонный Справочник (с помощью HashMap), который хранит в себе список фамилий и телефонных номеров.
// В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get() искать номер телефона по фамилии.
// Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
// тогда при запросе такой фамилии должны выводиться все телефоны.

// ***Желательно не добавлять лишний функционал (дополнительные поля (имя, отчество, адрес),
// взаимодействие с пользователем через консоль и т.д). Консоль использовать только для вывода результатов проверки телефонного справочника.


public class PhoneDirectory{
    static java.util.Scanner scanner = new Scanner(System.in);
    
    static private java.util.HashMap<String,List<String>> phoneBook;

    public PhoneDirectory(){
        phoneBook = new HashMap<>();
    }

    public void add(){
        System.out.println("Введите фамилию нового контакта для добавления: ");
        String lastName = scanner.nextLine();

        System.out.println("Введите номер телефона добавляемого контакта: ");
        String phoneNumber = scanner.nextLine();

        if (phoneBook.containsKey(lastName)){
            List<String> numbers = phoneBook.get(lastName);
            numbers.add(phoneNumber);
        } else {
            List<String> numbers = new ArrayList<>();
            numbers.add(phoneNumber);
            phoneBook.put(lastName, numbers);
        }
        
    }

    public void get(){
        System.out.println("Введите фамилию контакта для поиска номера телефона: ");
        String lastName = scanner.nextLine();

        if (phoneBook.containsKey(lastName)){
            List<String> numbers = phoneBook.get(lastName);
            System.out.println("Номера телефонов контакта с фамилией "+lastName+":");
            for (String number:numbers){
                System.out.println(number);
            }
        } else {
            System.out.println("Фамили нет в справочнике.");
        }

    }
}