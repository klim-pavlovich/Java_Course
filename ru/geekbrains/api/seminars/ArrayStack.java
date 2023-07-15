package ru.geekbrains.api.seminars;

import java.util.EmptyStackException;

public class ArrayStack {
    
    static final int CAPACITY = 1000;
    private int[] data;
    private int topIndex = -1;


    ArrayStack(){
        data = new int[CAPACITY];
    }

    ArrayStack(int capacity){
        if (capacity < 0){
            throw new IllegalArgumentException();
        }
        data = new int[capacity];
    }

    int size(){
        return topIndex + 1;
    }

    boolean empty(){
        return topIndex == -1;
    }

    void push(int e){
        if (size() == data.length){
            throw new StackOverflowError("Переполнение стека. Невозможно добавить элемент.");
        }
        data[++topIndex] = e;
    }

    int peek(){
        if (empty()){
            throw new EmptyStackException();
        }
        return data[topIndex];
    }

    int pop(){
        if (empty()){
            throw new EmptyStackException();
        }
        return data[topIndex--];
    }
}
