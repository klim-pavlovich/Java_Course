package RU.FinalTask;

import java.util.Objects;

public class Cat {

    private String name;
    private String breed;
    private String color;
    private Double weight;
    private Double age;

    // Значения задаем с заглавной буквы, вес в кг, возраст в годах
    public Cat(String name, String breed, String color, Double weight, Double age){
        this.name=name;
        this.breed=breed;
        this.color = color;
        this.weight=weight;
        this.age=age;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || (!(o instanceof Cat))) return false;
        Cat cat = (Cat) o;
        return Objects.equals(name, cat.name) &&
                Objects.equals(breed, cat.breed) &&
                Objects.equals(color, cat.color) &&
                Objects.equals(weight, cat.weight) &&
                Objects.equals(age, cat.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, breed, color, weight, age);
    }

    @Override
    public String toString(){
        return "Cat:" +
                "name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                ", age=" + age;
    }
}
