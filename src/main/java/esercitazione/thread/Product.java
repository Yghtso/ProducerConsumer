package esercitazione.thread;

import java.util.Random;

public class Product {

    public Product(int consumptionDifficulty, int maxId) {
        this.consumptionDifficulty = consumptionDifficulty;
        id = new Random().nextInt(maxId) + 1;
    }

    public int getConsumptionDifficulty() {
        return consumptionDifficulty;
    }

    public int getId() {
        return id;
    }

    public void setConsumptionDifficulty(int consumptionDifficulty) {
        this.consumptionDifficulty = consumptionDifficulty;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int maxConsumptionDifficulty;

    private int id;
    private int consumptionDifficulty;

}
