package esercitazione.thread;

public class Buffer {
    // classe completa ma non ancora sincronizzata
    public Buffer(int dimension) {
        products = new Product[(int) dimension];
        this.dimension = dimension;

        full = false;
        empty = true;
    }

    public Product extractProduct() {
        Product extracted = null;
        for (Product product : products) {

            if (product != null) {
                product = null;
                extracted = product;
                full = false;
                break;
            }
        }
        checkEmpty();
        checkFull();
        return extracted;
    }

    public void addProduct(Product addProduct) {
        for (Product product : products) {

            if (product == null) {
                product = addProduct;
                empty = false;
                break;
            }
        }
        checkEmpty();
        checkFull();
    }

    private void checkFull() {
        for (Product product : products) {
            if (product == null) {
                full = false;
                return;
            }
        }
        full = true;
    }

    private void checkEmpty() {
        for (Product product : products) {
            if (product != null) {
                empty = false;
                return;
            }
        }
        empty = true;
    }

    public boolean isFull() {
        return full;
    }

    public boolean isEmpty() {
        return empty;
    }

    public int getDimension() {
        return dimension;
    }

    private boolean full;
    private boolean empty;
    private final int dimension;
    private Product[] products;

}
