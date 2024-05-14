package esercitazione.thread;

public class Consumer extends Worker {
    public Consumer(Buffer buffer, int number) {
        super(buffer, number);
    }

    @Override
    public void run() {
        while (Thread.currentThread().isAlive()) {

                // Si segna per poter estrarre

                buffer.numThreadExtractAllowed.decrementAndGet();

                if (buffer.numThreadExtractAllowed.get() > 0) {
                    Product extracted = buffer.extractProduct();
                    log(extracted);
                }
            }
    }



    protected void log(Product product) {
        super.log(product);
        System.out.println("[CONSUMER] number #[" + number + "] consumed Product : [" + product.getId()
                + "] with consumption difficulty : [" + product.getConsumptionDifficulty() + "]");
    }

}
