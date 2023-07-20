package ru.geekbrains.homeworks;

import java.util.Scanner;

// Задание с телефонным справочником

public class Homework5 {
    public static void main(String[] args) {
        PhoneDirectory phoneDirectory = new PhoneDirectory();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Привет! Это телефонный справочник.");
        boolean exitFromPhoneDirectory = false;
        while (!exitFromPhoneDirectory) {
            System.out.println("Чтобы добавить контакт введи 'add';");
            System.out.println("Чтобы найти номер телефона по фамилии - 'get'");
            System.out.println("Чтобы выйти - 'exit'");
            String userInput = scanner.nextLine();
            
            switch (userInput) {
                case "add":
                    phoneDirectory.add();
                    break;
                case "get":
                    phoneDirectory.get();
                    break;
                case "exit":
                    exitFromPhoneDirectory = true;
                    System.out.println("До свидания!");
                    break;
                default:
                    System.out.println("Неверная команда");
                    break;
            }
        }
    }
}
