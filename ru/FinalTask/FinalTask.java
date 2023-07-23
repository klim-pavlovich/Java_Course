package RU.FinalTask;

import java.util.*;


public class FinalTask {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Vasya","Maine Coon","Grey",15.1,6.0);
        Cat cat2 = new Cat("Stesha","Maine Coon","Brown",4.5,1.0);
        Cat cat3 = new Cat("Vasya","Maine Coon","Grey",15.1,6.0);
        Cat cat4 = new Cat("Tisha","Scottish Fold","Light Grey",5.2,3.5);
        Cat cat5 = new Cat("Lucy","Scottish Fold","Red",5.3,2.0);
        Cat cat6 = new Cat("Max","Abyssinian","Black",3.8,0.5);
        Cat cat7 = new Cat("Thomas","Bengali","Light Brown",4.7,2.2);

        HashSet<Cat> catHashSet = new HashSet<>();
        catHashSet.add(cat1);
        catHashSet.add(cat2);
        catHashSet.add(cat3);
        catHashSet.add(cat4);
        catHashSet.add(cat5);
        catHashSet.add(cat6);
        catHashSet.add(cat7);

        System.out.println("Размер множества: " + catHashSet.size());
        for (Cat cat : catHashSet){
            System.out.println(cat);
        }
    }
}
