package esercitazione.thread;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public abstract class Worker extends Thread {
    public void run() {
    }

    protected void log(Product product) {
        System.out.print(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")) + "  ");
    }

    protected int number;
    protected Buffer buffer;

    public Worker(Buffer buffer, int number) {
        this.buffer = buffer;
        this.number = number;
    }
}
