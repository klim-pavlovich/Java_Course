package ru.geekbrains.homeworks;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Homework2 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        boolean exitFromProgram = false;

        while (!exitFromProgram) {
            System.out.println("Введите номер задачи: ");
            System.out.println("1 - Задача 1");
            System.out.println("2 - Задача 2");
            System.out.println("3 - Задача 3");
            System.out.println("4 - Задача 4");
            System.out.println("0 - Завершение работы приложения");

            if (scanner.hasNextInt()) {
                int userChoice = scanner.nextInt();

                switch (userChoice) {
                    case 1:
                        System.out.println("Задача 1: формирование SQL-запроса: ");
                        task1();
                        break;
                    case 2:
                        System.out.println("Задача 2: сортировка и логирование");
                        task2();
                        break;
                    case 3:
                        System.out.println("Задача 3: вывод JSON строки об успеваемости учеников");
                        task3();
                        break;
                    case 4:
                        System.out.println("Задача 4");
                        break;
                    case 0:
                        System.out.println("Завершение работы приложения.");
                        exitFromProgram = true;
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

    // Задание 1
    // Дана строка sql-запроса "select * from students where ". Сформируйте часть
    // WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены
    // ниже в виде json-строки.
    // Если значение null, то параметр не должен попадать в запрос.
    // Параметры для фильтрации: {"name":"Ivanov", "country":"Russia",
    // "city":"Moscow", "age":"null"}

    public static void task1() {
        String sqlQuery = "select * from students where ";
        String filterJsonString = "{\"name\":\"Ivanov\", \"country\":\"Russia\",\"city\":\"Moscow\", \"age\":\"null\"}";

        StringBuilder stringBuilder = new StringBuilder(sqlQuery);
        stringBuilder.append(buildWhereClause(filterJsonString));

        String finalQuery = stringBuilder.toString();
        System.out.println("SQL Query: " + finalQuery);
    }

    public static String buildWhereClause(String filterJsonString) {
        StringBuilder whereClause = new StringBuilder();
        filterJsonString = filterJsonString.replace("{", "").replace("}", "");

        String[] keyValuePairs = filterJsonString.split(",");

        for (String pair : keyValuePairs) {
            String[] keyValue = pair.split(":");
            String key = keyValue[0].replace("\"", "");
            String value = keyValue[1].replace("\"", "");

            if (!value.equals("null")) {
                if (whereClause.length() > 0) {
                    whereClause.append(" AND ");
                }
                whereClause.append(key).append((" = '")).append(value).append("'");
            }
        }
        return whereClause.toString();
    }

    // 2) Реализуйте алгоритм сортировки пузырьком числового массива, результат
    // после каждой итерации запишите в лог-файл.

    public static void task2() throws IOException {
        int[] userArray = getIntArrayFromUser();
        bubbleSort(userArray);
        System.out.println("Результат сортировки каждой итерации сохранен в файле \"log.txt\n.");
    }

    public static void bubbleSort(int[] arr) throws IOException {
        try {
            File logFile = new File("log.txt");
            FileWriter fileWriter = new FileWriter(logFile, true);

            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = 0; j < arr.length - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }

                fileWriter.write(System.lineSeparator() + "Итерация " + (i + 1) + ": " + Arrays.toString(arr));
            }
            fileWriter.write("Отсортированный массив: " + Arrays.toString(arr));
            fileWriter.close(); // не забываем закрыть FileWriter после использования
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[] getIntArrayFromUser() {
        System.out.println("Введите целые числа массива через пробел: ");
        String userInput = "";
        while (userInput == "") {
            userInput = scanner.nextLine();
        }
        // String userInput = scanner.nextLine();
        String[] numbersStr = userInput.split(" ");
        int[] result = new int[numbersStr.length];
        for (int i = 0; i < numbersStr.length; i++) {
            try {
                result[i] = Integer.parseInt(numbersStr[i]);
            } catch (NumberFormatException nfe) {
                System.out.println("Вы ввели неправильные значения, попробуйте еще раз.");
                return null;
            }
        }
        return result;
    }

    // Задание 3. Дана json-строка (можно сохранить в файл и читать из файла)
    // [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
    // Написать метод(ы), который распарсит json и, используя StringBuilder, создаст
    // строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
    // Пример вывода:
    // Студент Иванов получил 5 по предмету Математика.
    // Студент Петрова получил 4 по предмету Информатика.
    // Студент Краснов получил 5 по предмету Физика.

    public static void task3() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new FileReader("raitingsAccounting.txt"));
            String jsonContent = reader.readLine();
            jsonContent = jsonContent.replace("[", "").replace("]", "");

            String[] records = jsonContent.split("\\},\\{");

            for (String record : records) {
                record = record.replace("{", "").replace("}", "").replace("\"", "");

                String[] keyValuePairs = record.split(",");
                String surname = null;
                String grade = null;
                String subject = null;

                for (String pair : keyValuePairs) {
                    // Разделите ключ и значение по двоеточию
                    String[] keyValue = pair.split(":");

                    String key = keyValue[0].trim();
                    String value = keyValue[1].trim();

                    if (key.equals("\"фамилия\"")) {
                        surname = value.replace("\"", "");
                    } else if (key.equals("\"оценка\"")) {
                        grade = value.replace("\"", "");
                    } else if (key.equals("\"предмет\"")) {
                        subject = value.replace("\"", "");
                    }
                    if (surname != null && grade != null && subject != null) {
                    stringBuilder.append("Студент ").append(surname).append(" получил ").append(grade).append(" по предмету ").append(subject).append(".\n");
                }
                }

                
            }
            reader.close();
            System.out.println(stringBuilder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}