import java.util.HashMap;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;
import javax.xml.transform.stream.StreamSource;

public class Lection5 {
    public static void main(String[] args) {
        // Колекции map
        // HashMap
        Integer a = 123;
        // Пример функции хэширования
        System.out.println(a.hashCode());
        System.out.println("z".hashCode());
        
        // Map - это множество коллекций, работающих с данными
        // по принципу <Ключ/Значение>.

        // Ключевые особенности:
        // ускоренная обработка данных;
        // порядок добавления не запоминается;
        // допускаются только уникальные ключи, значения могут повторятся;
        // помните про null значения (пустая ссылка).
        // В HashMap элементы располагается как угодно и могут менять свое положение.

        Map<Integer, String> db = new HashMap<>();
        db.putIfAbsent(1, "один");
        db.put(2, "два");
        db.put(null, "!null");
        System.out.println(db);
        System.out.println(db.get(44));
        // System.out.printf(null);
        System.out.println(db); // {1=один. 2=два}
        System.out.println(db.containsValue("один")); // true
        System.out.println(db.containsValue(1)); // false
        System.out.println(db.containsKey("один")); // false
        System.out.println(db.containsKey(1)); // true
        System.out.println(db.keySet());
        System.out.println(db.values());

        for (var item : db.entrySet()){
            System.out.printf("[%d: %s]\n", item.getKey(), item.getValue());
        }

        // Основные методы HashMap'a
        // put(K,V) - добавить пару или изменить значение, если ключ имеется
        // putIfAbsent(K,V) - произвести добавление если ключ не найден.
        // get(K) - получение значения по ключу.
        // remove(K) - удаляет пару по ключу.
        // containsValue(V) - проверка наличия значения.
        // containsKey(K) - проверка наличия ключа.
        // keySet() - возвращает множество ключей.
        // values() - возвращает набор значений.

         
        // Map<Integer, String> map1 = new HashMap<>(); // выделяется значение по умолчанию (напр.16)
        // Map<Integer, String> map2 = new HashMap<>(9); // можно задать значение
        // Map<Integer, String> map3 = new HashMap<>(9, 1.0f); // задаем значение массива, в котором будет хранится данные,
        // а вторым элементом - когда нужно увеличивать значение при заполнении в процентном соотношениия, в данном случае, после полного заполнения

        // Коллекция TreeMap - в процессе добавления пары упорядываются по ключу

        // Основные методы: put(K,V), get(K), remove(K); descendingKeySet(V) - получить исключительно ключи
        // descendingMap() - перевести(показать) в обратном порядке
        // tailMap() - показать значения больше чем 
        // headMap() - показать значения меньше чем 
        // lastEntry() - вернуть ключ значение по самому большому ключу
        // firstEntry() - вернуть ключ значение по самому мелкому ключу

        // LinkedHashMap - помнит порядок добавления элементов -> более медлительный
        // функционал наследован от HashMap

        // HashTable - устаревшая коллекция HashMap, не хранит null


    }
}
