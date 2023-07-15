package ru.geekbrains.homeworks;

import java.util.LinkedList;
import java.util.Scanner;

public class Homework4 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exitFromHomework4 = false;

        while (!exitFromHomework4) {
            System.out.println("Ввведите номер задачи: ");
            System.out.println("1 - Задача 1");
            System.out.println("2 - Задача 2");
            System.out.println("3 - Задача 3");
            System.out.println("0 - Завершение работы приложения");

            if (scanner.hasNextInt()) {
                int userInput = scanner.nextInt();

                switch (userInput) {
                    case 1:
                        task1();
                        break;
                    case 2:
                        System.out.println("При работе с вторым заданием, рекомендуется сначала надобавлять элементов в очередь, а затем - удалять и возвращать их.");
                        task2();
                        break;
                    case 3:
                        CalculatorUpgraded.run();
                        break;
                    case 0:
                        System.out.println("Заверешние работы приложения.");
                        exitFromHomework4 = true;
                        break;
                    default:
                        System.out.println("Некорректный номер ввода. Повторите попытку.");
                        break;
                }
            } else {
                String invalidInput = scanner.nextLine();
                System.out.println("Некорректный ввод. Повторите попытку.");
            }
        }

    }

    // 1. Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который
    // вернет “перевернутый” список.
    public static void task1() {
        boolean exitFromFirstTask = false;
        LinkedList<String> userLinkedList = new LinkedList<>();
        while (!exitFromFirstTask){
            System.out.println("Чтобы добавить элемент, введите 'add'. Чтобы вернуть перевернутый список - 'reverse'.");
            System.out.println("Введите 'back', чтобы вернуться в меню со всеми задачами.");
            

            if (scanner.hasNext()) {
                String tmp = "";
                while (tmp == "") {
                    tmp = scanner.nextLine();
                }
                
                String userInput = tmp.toLowerCase();
                if (userInput.equals("add")) {
                    System.out.println("Введите значение добавляемого элемента: ");
                    String userElement = scanner.nextLine();
                    userLinkedList.add(userElement);
                }

                else if (userInput.equals("reverse")){
                    LinkedList<String> reversedUserLinkedList = new LinkedList<>();
                    int sizeLinkedList = userLinkedList.size();
                    for (int i = 0; i < sizeLinkedList; i++) {
                        reversedUserLinkedList.addFirst(userLinkedList.get(i));
                    }
                    System.out.println("Изначальный LinkedList: " + userLinkedList);
                    System.out.println("Перевернутый LinkedList: " + reversedUserLinkedList);
                }

                else if (userInput.equals("back")) {
                    System.out.println("Выход в главное меню.");
                    exitFromFirstTask = true;
                    return;
                }

                else {
                    String invalidInput = scanner.nextLine();
                    System.out.println("Вы ввели неверное значение. Повторите попытку");
                }
            }
        }
    }

    // Условие в MyQueue.java

    public static void task2(){
        boolean exitFromSecondTask = false;
        MyQueue<String> myqueue = new MyQueue<>();

        while(!exitFromSecondTask){
            System.out.println("Введите команду для работы с очередью: ");
            System.out.println("'enqueue' - добавить элемент в конец очереди,");
            System.out.println("'dequeue' -  вернуть первый элемент из очереди и удалить его,");
            System.out.println("'first' -  вернуть первый элемент из очереди, не удаляя его,");
            System.out.println("'back' - вернуться в меню со всеми задачами.");
            


            if (scanner.hasNext()) {
                String tmp = "";
                while (tmp == "") {
                    tmp = scanner.nextLine();
                }
                
                String userInput = tmp.toLowerCase();
                if (userInput.equals("enqueue")) {
                    System.out.println("Введите значение добавляемого элемента: ");
                    String userElement = scanner.nextLine();
                    myqueue.enqueue(userElement);
                    System.out.println("Элемент " + userElement + " добавлен в очередь.");
                }

                else if (userInput.equals("dequeue")){
                    String dequeuedElement = myqueue.dequeue();
                    System.out.println("Первый элемент в очереди: " + dequeuedElement + " удален.");
                    // System.out.println("удален.");
                }

                else if (userInput.equals("first")){
                    String firstElement = myqueue.first();
                    System.out.println("Первый элемент в очереди: " + firstElement);

                }

                else if (userInput.equals("back")) {
                    System.out.println("Выход в главное меню.");
                    exitFromSecondTask = true;
                    return;
                }

                else {
                    String invalidInput = scanner.nextLine();
                    System.out.println("Вы ввели неверное значение. Повторите попытку");
                }
        }
    }

}
}