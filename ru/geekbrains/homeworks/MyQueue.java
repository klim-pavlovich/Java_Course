package ru.geekbrains.homeworks;

// 2 *. Реализуйте очередь с помощью LinkedList со следующими методами:
    // enqueue() - помещает элемент в конец очереди,
    // dequeue() - возвращает первый элемент из очереди и удаляет его,
    // first() - возвращает первый элемент из очереди, не удаляя.
    // Это задание повышенной сложности, для решения задачи потребуется создать класс-обертку над LinkedList

import java.util.LinkedList;

class MyQueue<E> {
    private LinkedList<E> myqueue;

    public MyQueue() {
        myqueue = new LinkedList<>();
    }
    
    public void enqueue(E element){
        myqueue.addLast(element);
    }

    public E dequeue(){
        return myqueue.removeFirst();
    }

    public E first(){
        return myqueue.peek();
    }
}

