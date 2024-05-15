package esercitazione.thread;

import java.util.Random;

public class Producer extends Worker {
    public Producer(int productionRange, Buffer buffer, int number) {
        super(buffer, number);
        this.productionRange = productionRange;
    }

    @Override
    public void run() {
        while (Thread.currentThread().isAlive()) {

            Product addItem = new Product(new Random().nextInt(Product.maxConsumptionDifficulty),
                    new Random().nextInt(buffer.getCapacity()));

            try {
                buffer.add(addItem);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            try {
                Thread.sleep(productionRange * 1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(Thread.currentThread().getName() + " was interrupted.");
            }

        }

    }

    protected void log(Product product) {
        super.log(product);
    }

    private int productionRange;
}
