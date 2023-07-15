import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Lection4 {
    private static final String Stack = null;

    public static void main(String[] args) {
        
        // Список - гибкая структура данных, позволяющая легко менять свой размер.
        // Элементы доступны для вставки или удаления в любой позиции.
        // Информацию о элементе i знает только элемент i-1 (односвязный)

        // LinkedList - двусвязный список
        // Информацию о элементе i знает элемент i-1 и элемент i+1


        // Queue очередь на основе LinkListed
        // Queue <Integer> queue = new LinkedList<Integer>();
        // при удалении remove - будет удален тот, который был первым добавлен

        // PriorityQueue - наивысший приоритет имеет "наименьший" элемент
        // PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        // pq.add(123);
        // pq.add(3);
        // pq.add(13);
        // pq.add(1);
        // System.out.println(pq);
        // poll - извлекает по приоритету
        // System.out.println(pq.poll());
        // System.out.println(pq.poll());
        // System.out.println(pq.poll());
        // System.out.println(pq.poll());
        // System.out.println(pq.poll());


        // Deque - линейная коллекция, которая поддерживает вставку
        // и удаление элементов на обоих концах

        // Stack работает по принципу First In Last Out
        // считается устаревшей - лучше нее -  Deque
        // Вычислить значение выражения в постфиксной форме записи
        // 1 + 2 * 3 в постфиксной 123*+
        // (1+2)*3 в постфиксной 12+3*

        var exp = " 1 2 3 * +".split(" ");
        int res = 0;
        System.out.println(exp);

        Stack <Integer> st = new Stack<>();
        for (int i = 0; i < exp.length; i ++){

            if (isDigit(exp[i])){
                st.push(Integer.parseInt(exp[i]));
            } else {
                switch (exp[i]) {
                    case "+":
                        res = st.pop() + st.pop();
                        st.push(res);
                        break;
                    
                    case "-":
                    res = -st.pop() + st.pop();
                    st.push(res);
                    break;

                    case "*":
                        res = st.pop() * st.pop();
                        st.push(res);
                        break;
                    
                    case "/":
                    res = st.pop() / st.pop();
                    st.push(res);
                    break;
            
                    default:
                        break;
                }
            }

        }

    }
    

}
