package esercitazione.thread;

public class Consumer extends Worker {
    public Consumer(Buffer buffer, int number) {
        super(buffer, number);
    }

    @Override
    public void run() {
        while (Thread.currentThread().isAlive()) {

            // Si segna per poter estrarre
            Product extractedProduct = null;
            try {
                extractedProduct = (Product) buffer.extract(this);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            try {
                Thread.sleep(extractedProduct.getConsumptionDifficulty() * 1000); // Sleep for 2000 milliseconds (2
                                                                                  // seconds)
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(Thread.currentThread().getName() + " was interrupted.");
            }
        }
    }

}
