package esercitazione.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer<T> {
    private final T[] items;
    private int size;
    private final ReentrantLock lock;
    private final Condition notFull;
    private final Condition notEmpty;
    private final int capacity;

    @SuppressWarnings("unchecked")
    public Buffer(int capacity) {
        items = (T[]) new Object[capacity];
        size = 0;
        lock = new ReentrantLock();
        notFull = lock.newCondition();
        notEmpty = lock.newCondition();
        this.capacity = capacity;
    }

    public void add(T item) throws InterruptedException {
        lock.lock();
        try {
            while (size == items.length) {
                notFull.await();
            }
            items[size] = item;
            size++;
            producerLog(item);
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public T extract() throws InterruptedException {
        lock.lock();
        try {
            while (size == 0) {
                notEmpty.await();
            }
            T item = items[0];
            System.arraycopy(items, 1, items, 0, size - 1);
            items[--size] = null; // Help garbage collection
            consumerLog(item);
            notFull.signal();
            return item;
        } finally {
            lock.unlock();
        }
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    private void producerLog(T item) {
        System.out.println("[PRODUCER] number #[" + Thread.currentThread().getClass().getField(number)
                + "] produced Product : [" + product.getId()
                + "] with consumption difficulty : [" + product.getConsumptionDifficulty() + "]");
    }

    private void consumerLog(T item) {
    }
}
