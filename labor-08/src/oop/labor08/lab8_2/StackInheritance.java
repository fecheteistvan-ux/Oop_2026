package oop.labor08.lab8_2;
import java.util.ArrayList;

public class StackInheritance extends ArrayList<Object> {
    private int capacity;

    public StackInheritance(int capacity) {
        this.capacity = capacity;
    }

    public void push(Object obj) {
        if (size() < capacity) add(obj);
    }

    public void pop() {
        if (!isEmpty()) remove(size() - 1);
    }

    public Object top() {
        return isEmpty() ? null : get(size() - 1);
    }

    public boolean isFull() { return size() >= capacity; }
}