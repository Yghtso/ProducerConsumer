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

            Product product = new Product(new Random().nextInt(Product.maxConsumptionDifficulty),
                    new Random().nextInt(buffer.getDimension()));

            if (!buffer.isFull() && product.getConsumptionDifficulty() != 0) {
                buffer.addProduct(product);
                log(product);

                try {
                    Thread.sleep(productionRange);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    protected void log(Product product) {
        super.log(product);
        System.out.println("[PRODUCER] number #[" + number + "] produced Product : [" + product.getId()
                + "] with consumption difficulty : [" + product.getConsumptionDifficulty() + "]");
    }

    private int productionRange;
}
