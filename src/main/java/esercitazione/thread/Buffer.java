package esercitazione.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

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

    public void add(T item, Producer t) throws InterruptedException {
        lock.lock();
        try {
            while (size == items.length) {
                notFull.await();
            }
            items[size] = item;
            size++;
            producerLog(item, t);
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public T extract(Consumer t) throws InterruptedException {
        lock.lock();
        try {
            while (size == 0) {
                notEmpty.await();
            }
            T item = items[0];
            System.arraycopy(items, 1, items, 0, size - 1);
            items[--size] = null; // Help garbage collection
            consumerLog(item, t);
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

    public void setSize(int size) {
        this.size = size;
    }

    private void producerLog(T item, Producer t) {
        EsercitazioneThread.TextAreaProduttori.append(
                LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")) + "[PRODUCER] number #[" + t.getNumber()
                        + "] produced Product : [" + ((Product) item).getId()
                        + "] with consumption difficulty : [" + ((Product) item).getConsumptionDifficulty() + "]");
    }

    private void consumerLog(T item, Consumer t) {
        EsercitazioneThread.TextAreaConsumatori.append(
                LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")) + "[CONSUMER] number #[" + t.getNumber()
                        + "] consumed Product : [" + ((Product) item).getId()
                        + "] with consumption difficulty : [" + ((Product) item).getConsumptionDifficulty() + "]");
    }

}
