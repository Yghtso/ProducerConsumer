package esercitazione.thread;

public abstract class Worker extends Thread {
    public void run() {
        System.out.println("Nuovo Thread creato con ID : " + Thread.currentThread().threadId());
    }
}
