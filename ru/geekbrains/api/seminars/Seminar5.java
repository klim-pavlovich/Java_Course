package ru.geekbrains.api.seminars;
import java.util.*;


public class Seminar5 {
    public static void main(String[] args) {
        String[] data = {
            "123456 Иванов",
            "321456 Васильев",
            "234561 Петрова",
            "234432 Иванов",
            "654321 Петрова",
            "345678 Иванов"
        };
        
        String[] students = {
            "Григорьев Анатолий 4 5 2",
            "Фокин Глеб 1 5 2",
            "Шестаков Клим 4 3 2",
            "Хохлов Мартин 2 5 2",
            "Шубин Лазарь 4 5 2",
            "Гущина Арьяна 4 3 3",
            "Брагина Виоланта 2 5 2",
            "Афанасьева Екатерина 1 1 2",
            "Рыбакова Снежана 4 2 2",
            "Лазарева Алла 4 3 2",
            "Бирюков Владлен 4 5 2",
            "Копылов Панкратий 4 4 4",
            "Горбунов Рубен 4 5 3",
            "Лыткин Герман 1 5 2",
            "Соколов Орест 1 1 5"
    };

        // task1_2(data);
        task2(students);
    }

    // Вывести топ 3 самых худших средних баллов и списки студентов с такими баллами

    public static void task2(String[] students){

        // Student student = new Student("AAA", "BBB", 5);

        HashMap<Double, List<Student>> statistics = new HashMap<>();
        for (String student : students){
            String[] studentParts = student.split(" ");
            int a = Integer.parseInt(studentParts[2]);
            int b = Integer.parseInt(studentParts[3]);
            int c = Integer.parseInt(studentParts[4]);
            double middleMark = (double) (a+b+c)/3;
            Student st = new Student(studentParts[1],studentParts[0], middleMark);
            if (statistics.containsKey(middleMark)){
                statistics.get(middleMark).add(st);
            } else {
                ArrayList<Student> lst= new ArrayList<>();
                lst.add(st);
                statistics.put(middleMark, lst);
            }
            
        }

        RatingComparator ratingComparator = new RatingComparator();
        // TreeMap - сортирует по ключу автоматом 
        TreeMap<Double, List<Student>> sortedStatistics = new TreeMap<>(ratingComparator);
        sortedStatistics.putAll(statistics);
        
        System.out.println("ТОП3 худших средних баллов среди студентов: ");
        int counter = 1;
        for (Map.Entry<Double, List<Student>> item : sortedStatistics.entrySet()){
            System.out.printf("%d место - средний бал %.3f\n", counter, item.getKey());
            for (Student student : item.getValue()){
                System.out.println("\t" + student);
            }
            counter ++;
            if(counter > 3){
                break;
            }
        }


    }

        /*
     * Задача 1:
     * Создать структуру для хранения Номеров паспортов и Фамилий сотрудников организации.
     * 123456 Иванов
     * 321456 Васильев
     * 234561 Петрова
     * 234432 Иванов
     * 654321 Петрова
     * 345678 Иванов
     * Вывести данные по сотрудникам с фамилией Иванов.
     */

    public static void task1(String[] data){
        HashMap<Integer, String> hashMap1 = new HashMap<>();
        for (String person : data) {
            String[] parts = person.split(" ");
            hashMap1.put(Integer.parseInt(parts[0]), parts[1]);
        }
        for (Map.Entry<Integer, String> element: hashMap1.entrySet()){
            if (element.getValue().equals("Иванов")){
                System.out.println(element.getKey());
            }

        }
    }

    // Однако если в данных ошибка, то нужно взять за ключ фамилию 
    // (Если текущие данные прогнать через такс1, то последнего Иванова не выведет,
    //  из-за ключа предпоследнего - Петрова)
    //  * 123456 Иванов
    //  * 321456 Васильев
    //  * 234561 Петрова
    //  * 234432 Иванов
    //  * 654321 Петрова
    //  * 654321 Иванов
    public static void task1_2(String[] data){
        HashMap<String, List<Integer>> hashMap2 = new HashMap<>();
        for (String person : data) {
            String[] parts = person.split(" ");
            if (hashMap2.containsKey(parts[1])){
                // List<Integer> lst = hashMap2.get(parts[1]);
                // lst.add(Integer.parseInt(parts[0]));
                hashMap2.get(parts[1]).add(Integer.parseInt(parts[0]));
            } else {
                ArrayList<Integer> lst = new ArrayList<>();
                lst.add(Integer.parseInt(parts[0]));
                hashMap2.put(parts[1], lst);
            }
        }

       List<Integer> lst = hashMap2.get("Иванов");
       if (lst != null){
        System.out.println(lst);
       }
    }
}
