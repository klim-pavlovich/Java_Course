package ru.geekbrains.api.seminars;

public class Student {
    
    String name;
    String surName;
    double rating;

    // Для избежания конфликтов и для быстрого нахождения переменных используют try {
    // например String _name
    
    // Как только мы создаем свой конструктор, тот что по умолчанию - исчезает
    public Student(String name, String surName, double rating){
        // Чтобы избежать конфликта из=за одинаковых названий и обратиться к членам объектам с помощью this
        this.name = name;
        this.surName = surName;
        this.rating = rating;
    }
    // Но можно его добавить, создав вручную
    // public Student(){
    //     // можно указать начальные значения
    //     name = "USER";
    //     surName = "USER";
    //     rating = 1;
    // }

    @Override
    public String toString(){
        return surName + " " + name;
    }
}
