package net.salesianos.shared;

import java.util.ArrayList;
import java.util.List;

public class SharedResource {
    private final List<String> storage;
    private final int capacity;

    public SharedResource(int capacity) {
        this.capacity = capacity;
        this.storage = new ArrayList<>();
    }

    public synchronized void addProduct(String product) throws InterruptedException {
        while (storage.size() >= capacity) {
            System.out.println("✋ Monkey Park is full of fruits! Wait for monkeys to eat to add more.");
            wait();
        }

        storage.add(product);
        System.out.println(product + " added to the Monkey Park!");

        notifyAll();
    }

    public synchronized String consumeProduct() throws InterruptedException {

        while (storage.isEmpty()) {
            System.out.println("✋ Monkey Park is empty! Monkeys can't eat.");
            wait();
        }

        String product = storage.remove(0);
        System.out.println(product + " was eaten by a monkey! 🐒");

        notifyAll();

        return product;
    }

    public synchronized int getCapacity() {
        return capacity - storage.size();
    }
}