package esercitazione.thread;

import java.util.concurrent.atomic.AtomicBoolean;

public class Buffer {
    // classe completa ma non ancora sincronizzata
    public Buffer(int dimension) {
        products = new Product[(int) dimension];
        this.dimension = dimension;
    }

    public Product extractProduct() {

        for (AtomicBoolean product : productsState) {
            product.compareAndSet(false, true);
        }

    }

    public void addProduct(Product addProduct) {
    }

    private int numElements;

    private final int dimension;
    private Product[] products;
    private AtomicBoolean[] productsState;

}
