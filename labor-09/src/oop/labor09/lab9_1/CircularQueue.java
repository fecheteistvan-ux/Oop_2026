package oop.labor09.lab9_1;
import java.util.Objects;

public class CircularQueue implements IQueue {
    private final int CAPACITY;
    private Object[] items;
    private int front;
    private int rear;
    private int currentSize;

    public CircularQueue(int capacity) {
        this.CAPACITY = capacity;
        this.items = new Object[capacity];
        this.front = -1;
        this.rear = -1;
        this.currentSize = 0;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    @Override
    public boolean isFull() {
        return currentSize == CAPACITY;
    }

    @Override
    public void enQueue(Object obj) {
        if (isFull()) {
            System.out.println("A sor tele van!");
            return;
        }
        if (front == -1) {
            front = 0;
        }
        rear = (rear + 1) % CAPACITY;
        items[rear] = obj;
        currentSize++;
    }

    @Override
    public Object deQueue() {
        if (isEmpty()) {
            return null;
        }
        Object deQueuedElement = items[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % CAPACITY;
        }
        currentSize--;
        return deQueuedElement;
    }

    @Override
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("[]");
            return;
        }
        System.out.print("CircularQueue [ array: [ ");
        for (int i = 0; i < currentSize; i++) {
            int index = (front + i) % CAPACITY;
            System.out.print(items[index] + " ");
        }
        System.out.println("], front: " + front + ", rear: " + rear + "]");
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CircularQueue that = (CircularQueue) o;

        if (this.CAPACITY != that.CAPACITY) return false;
        if (this.currentSize != that.currentSize) return false;

        for (int i = 0; i < currentSize; i++) {
            int thisIndex = (this.front + i) % this.CAPACITY;
            int thatIndex = (that.front + i) % that.CAPACITY;
            if (!Objects.equals(this.items[thisIndex], that.items[thatIndex])) {
                return false;
            }
        }
        return true;
    }
}