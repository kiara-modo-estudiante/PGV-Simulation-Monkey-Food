package net.salesianos.threads;

import net.salesianos.shared.SharedResource;
import net.salesianos.utils.ConsoleColors;
import net.salesianos.utils.Utils;

public class Monkey extends Thread {

    // ----------- Attributes -----------
    private int monkeyId;
    private String monkeyName;
    private int totalQuantityToConsume;
    private int maxTimeToConsume;
    private static SharedResource sharedResource;

    // ----------- Complete Constructor -----------
    public Monkey(int monkeyId, String monkeyName, int totalQuantityToConsume, int maxTimeToConsume) {
        this.monkeyId = monkeyId;
        this.monkeyName = monkeyName;
        this.totalQuantityToConsume = totalQuantityToConsume;
        this.maxTimeToConsume = maxTimeToConsume;
    }

    // ----------- Static Method to Set Shared Resource -----------
    public static void setSharedResource(SharedResource resource) {
        sharedResource = resource;
    }

    // ----------- Thread Logic -----------
    @Override
    public void run() {
        try {
            for (int i = 0; i < totalQuantityToConsume; i++) {

                String consumedProduct = sharedResource.consumeProduct();
                System.out.println(
                        ConsoleColors.PURPLE + monkeyName + " is eating: " + ConsoleColors.RESET + consumedProduct);

                int timeToConsume = Utils.getRandomTime(maxTimeToConsume);
                Thread.sleep(timeToConsume * 1000);
            }
            System.out.println(ConsoleColors.GREEN_BOLD + monkeyName + " has finished eating." + ConsoleColors.RESET);
        } catch (InterruptedException e) {
            System.err.println(ConsoleColors.RED_BOLD + monkeyName + " was interrupted." + ConsoleColors.RESET);
        }
    }

    // ----------- toString -----------
    @Override
    public String toString() {
        return "Monkey [monkeyId=" + monkeyId + ", monkeyName=" + monkeyName + ", totalQuantityToConsume="
                + totalQuantityToConsume + ", maxTimeToConsume=" + maxTimeToConsume + "]";
    }
}
