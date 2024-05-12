package esercitazione.thread;

import java.util.ArrayList;

public class EsercitazioneThread {
    public static void main(String[] args) {

        final int numProduttori = Integer.parseInt(args[0]);
        final int numConsumatori = Integer.parseInt(args[1]);
        final int intervalloProduzione = Integer.parseInt(args[2]);
        final int maxDiffConsumo = Integer.parseInt(args[3]);
        final int dimensioneBuff = Integer.parseInt(args[4]);

        Product.maxConsumptionDifficulty = maxDiffConsumo;
        ArrayList<Worker> threads = new ArrayList<Worker>();
        Buffer sharedData = new Buffer(dimensioneBuff);

        // creo il numero di consumatori che si dovranno avere
        for (int i = 0; i < numProduttori; i++) {
            threads.add(new Producer(intervalloProduzione, sharedData, i + 1));
        }

        // creo il numero di produttori che si dovranno avere
        for (int i = 0; i < numConsumatori; i++) {
            threads.add(new Consumer(sharedData, i + 1));
        }

        // avvio la simulazione con tutti i thread
        for (Worker worker : threads) {
            worker.start();
        }
    }
}
