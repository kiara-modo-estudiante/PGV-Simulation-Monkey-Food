package net.salesianos.shared;

import java.util.ArrayList;
import java.util.List;

import net.salesianos.utils.ConsoleColors;

public class MonkeyPark {
    // ----------- Attributes -----------
    private final List<String> storage;
    private final int capacity;

    // ----------- Constructor -----------
    public MonkeyPark(int capacity) {
        this.capacity = capacity;
        this.storage = new ArrayList<>();
    }

    /**
     * Adds a product to the Monkey Park's storage. If the storage is full, the
     * method
     * will block and wait until there is space available.
     *
     * @param product     The name of the product (e.g., fruit) to be added to the
     *                    storage.
     * @param touristName The name of the tourist who is adding the product.
     * @throws InterruptedException If the thread is interrupted while waiting for
     *                              space in the storage.
     */
    public synchronized void addProduct(String product, String touristName) throws InterruptedException {
        while (storage.size() >= capacity) {
            System.out.println(ConsoleColors.ORANGE_BOLD
                    + "(✋) Monkey Park is full of fruits! Wait for monkeys to eat to add more." + ConsoleColors.RESET);
            wait();
        }

        storage.add(product);
        System.out.println(
                ConsoleColors.GREEN + touristName + " threw " + product.toLowerCase() + " to the Monkey Park!"
                        + ConsoleColors.RESET);

        notifyAll();
    }

    /**
     * Allows a monkey to consume a product from the park's storage.
     * This method is synchronized to ensure thread safety when multiple monkeys
     * attempt to consume products concurrently.
     *
     * @param monkeyConsumer The name or identifier of the monkey consuming the
     *                       product.
     * @return The product that was consumed by the monkey.
     * @throws InterruptedException If the thread is interrupted while waiting for
     *                              storage to have products.
     */
    public synchronized String consumeProduct(String monkeyConsumer) throws InterruptedException {

        while (storage.isEmpty()) {
            System.out.println(
                    ConsoleColors.ORANGE_BOLD + "(✋) Monkey Park is empty! Monkeys have nothing to take."
                            + ConsoleColors.RESET);
            wait();
        }

        String product = storage.remove(0);
        System.out.println(
                ConsoleColors.RED + monkeyConsumer + " took the " + product.toLowerCase() + "!" + ConsoleColors.RESET);

        notifyAll();

        return product;
    }

    /**
     * Retrieves the remaining capacity of the monkey park.
     * This method calculates the difference between the total capacity
     * and the current number of items in storage.
     *
     * @return the number of available slots in the park.
     */
    public synchronized int getCapacity() {
        return capacity - storage.size();
    }
}