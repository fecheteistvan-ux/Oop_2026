package oop.labor08.lab8_2;
import java.util.ArrayList;

public class StackAggregation {
    private ArrayList<Object> items = new ArrayList<>();
    private int capacity;

    public StackAggregation(int capacity) {
        this.capacity = capacity;
    }

    public void push(Object obj) {
        if (!isFull()) items.add(obj);
    }

    public void pop() {
        if (!isEmpty()) items.remove(items.size() - 1);
    }

    public Object top() {
        return isEmpty() ? null : items.get(items.size() - 1);
    }

    public boolean isEmpty() { return items.isEmpty(); }
    public boolean isFull() { return items.size() >= capacity; }
}
