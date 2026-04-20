package oop.labor09.lab9_1;
import java.util.ArrayList;
import java.util.Objects;

public class ArrayListQueue implements IQueue {
    private ArrayList<Object> items;
    private final int CAPACITY;

    public ArrayListQueue(int capacity) {
        this.CAPACITY = capacity;
        this.items = new ArrayList<>(capacity);
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public boolean isFull() {
        return items.size() == CAPACITY;
    }

    @Override
    public void enQueue(Object obj) {
        if (!isFull()) {
            items.add(obj);
        } else {
            System.out.println("A sor tele van!");
        }
    }

    @Override
    public Object deQueue() {
        if (!isEmpty()) {
            return items.remove(0);
        }
        return null;
    }

    @Override
    public void printQueue() {
        System.out.println(items);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayListQueue that = (ArrayListQueue) o;
        return Objects.equals(items, that.items);
    }
}