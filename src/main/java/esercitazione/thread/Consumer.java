package esercitazione.thread;

public class Consumer extends Worker {
    public Consumer(Buffer buffer, int number) {
        super(buffer, number);
    }

    @Override
    public void run() {
        while (Thread.currentThread().isAlive()) {

            Product extracted;

            if (!buffer.isEmpty()) {
                extracted = buffer.extractProduct();
                log(extracted);

                try {
                    Thread.sleep(extracted.getConsumptionDifficulty());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    protected void log(Product product) {
        super.log(product);
        System.out.println("[CONSUMER] number #[" + number + "] consumed Product : [" + product.getId()
                + "] with consumption difficulty : [" + product.getConsumptionDifficulty() + "]");
    }

}
