package esercitazione.thread;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Product {

    public Product(int maxId) {
        consumptionDifficulty = ThreadLocalRandom.current().nextInt(maxConsumptionDifficulty);
        id = ThreadLocalRandom.current().nextInt(maxId);
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
