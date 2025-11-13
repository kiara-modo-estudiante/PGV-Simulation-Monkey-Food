package net.salesianos.shared;

import java.util.ArrayList;
import java.util.List;

import net.salesianos.utils.ConsoleColors;

public class SharedResource {
    private final List<String> storage;
    private final int capacity;

    public SharedResource(int capacity) {
        this.capacity = capacity;
        this.storage = new ArrayList<>();
    }

    public synchronized void addProduct(String product) throws InterruptedException {
        while (storage.size() >= capacity) {
            System.out.println(ConsoleColors.ORANGE_BOLD
                    + "✋ Monkey Park is full of fruits! Wait for monkeys to eat to add more." + ConsoleColors.RESET);
            wait();
        }

        storage.add(product);
        System.out.println( ConsoleColors.CYAN + product + " added to the Monkey Park!" + ConsoleColors.RESET);

        notifyAll();
    }

    public synchronized String consumeProduct() throws InterruptedException {

        while (storage.isEmpty()) {
            System.out.println(
                    ConsoleColors.ORANGE_BOLD + "✋ Monkey Park is empty! Monkeys can't eat." + ConsoleColors.RESET);
            wait();
        }

        String product = storage.remove(0);
        System.out.println(ConsoleColors.YELLOW + product + " was eaten by a monkey! 🐒" + ConsoleColors.RESET);

        notifyAll();

        return product;
    }

    public synchronized int getCapacity() {
        return capacity - storage.size();
    }
}