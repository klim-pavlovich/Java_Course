import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Iterator;

public class Lection3 {

    // Тип данных - Object
    // public static void main(String[] args) {
    //     Object o = 1; GetType(o);
    //     o = 1.2; GetType(o);

    // }
    // static void GetType(Object obj){
    //     System.out.println(obj.getClass().getName());
    // }

    // добавление итема в массив
    
    // static int[] AddItem(int[] array, int item){
    //     int length = array.length;
    //     int[] temp = new int[length - 1];
    //     System.arraycopy(array,0,temp,0,length);
    //     temp[length] = item;
    //     return temp;
    // }
    // public static void main(String[] args) {
    //     int[] a = new int[] {0,9};
    //     for (int i : a) {System.out.printf("%d" , i);}
    //     a = AddItem(a,2);
    //     a = AddItem(a, 3);
    //     for (int j : a) {System.out.printf("%d", j);}
    // }

    // ArrayList
    // public static void main(String[] args) {
    //     // ArrayList list = new ArrayList();

    //     // С помощью обобщения можно явно указывать с каким типом мы работаем
    //     ArrayList<Integer> list = new ArrayList<Integer>();

    //     // При написании конструктора можно не указывать тип
    //     ArrayList<Integer> list2 = new ArrayList<>();

    //     // Можно также указать размерность передав число или лист
    //     ArrayList<Integer> list3 = new ArrayList<>(10);
    //     ArrayList<Integer> list4 = new ArrayList<>(list3);
    //     list.add(2809);

    //     for (Object o : list){
    //         System.out.println(o);
    //     }
        // public static void main(String[] args) {
        //     int day = 29;
        //     int month = 9;
        //     int year = 1990;
        //     Integer[] date = { day, month, year};
        //     List<Integer> d = Arrays.asList(date);
        //     System.out.println(d);
        // }
        // public static void main(String[] args) {
        //     StringBuilder day = new StringBuilder("28");
        //     StringBuilder month = new StringBuilder("9");
        //     StringBuilder year = new StringBuilder("1990");
        //     StringBuilder[] date =  new StringBuilder[] {day,month,year};
        //     List<StringBuilder> d = Arrays.asList(date);
        //     System.out.println(d);
        //     date[1] = new StringBuilder("09");
        //     System.out.println(d);
        // }

        // Итератор
        public static void main(String[] args) {
            List<Integer> list = List.of(1, 12, 123, 1234, 12345);

            for (int item : list){
                System.out.println(item);
            }

            Iterator<Integer> col = list.iterator();
            System.out.println();

            while (col.hasNext()){
                System.out.println(col.next());
                // Если использовать тут next и remove - будет ошибка
                // col.next();
                // col.remove();
            }
        }
    }