package esercitazione.thread;

public abstract class Worker extends Thread {
    public void run() {
    }

    protected int number;
    protected Buffer buffer;

    public Worker(Buffer buffer, int number) {
        this.buffer = buffer;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public Buffer getBuffer() {
        return buffer;
    }

}
