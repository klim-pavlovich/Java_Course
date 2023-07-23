package Java_Lections;
import java.util.Arrays;
import java.util.HashSet;

public class Lection6 {
    public static void main(String[] args) {
        Worker w1 = new Worker();
        w1.firstName = "Имя_1";
        w1.lastName = "Фамилия_1";
        w1.salary = 100;
        w1.id = 1000;

        Worker w4 = new Worker();
        w4.firstName = "Имя_1";
        w4.lastName = "Фамилия_1";
        w4.salary = 100;
        w4.id = 1000;

        Worker w2 = new Worker();
        w2.firstName = "Имя_2";
        w2.lastName = "Фамилия_2";
        w2.salary = 200;
        w2.id = 2000;

        Worker w3 = new Worker();
        w2.firstName = "Имя_3";
        w2.lastName = "Фамилия_3";
        w2.salary = 300;
        w2.id = 3000;

        System.out.println(w1==w4);
        System.out.println(w1.equals(w4));
        var workers = new HashSet<Worker>(Arrays.asList(w1,w2,w3));
        System.out.println(workers.contains(w4));

        System.out.println(w1.toString());
        System.out.println(w1.equals(w3));
        System.out.println(workers.contains(w4));







        // HashSet - как синоним множества
    //     addAll(Coll) - объединение множеств;
    //     retainAll(Coll) - пересечение множеств;
    //     removeAll(Coll) - разность множеств.
    
    // }
    // // Добавление
    //     var a = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7));
    //     var b = new HashSet<>(Arrays.asList(2,3,5,7,11,13,17));
    //     var c = new HashSet<Integer>(a); c.addAll(b);
    //     var d = new HashSet<Integer>(a); a.retainAll(b);
    //     var e = new HashSet<Integer>(a); a.removeAll(b);
    //     System.out.println(c);
    //     System.out.println(d);
    //     System.out.println(e);

        // TreeSet - упорядоченное множество (механизм (критерий) упорядочивания нужно придумывать самим )
        // LinkedHashSet - в основе HashMap, помнит порядок


    }

}
