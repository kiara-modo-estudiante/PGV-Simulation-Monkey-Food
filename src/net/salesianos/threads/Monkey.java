package net.salesianos.threads;

import net.salesianos.shared.MonkeyPark;
import net.salesianos.utils.ConsoleColors;
import net.salesianos.utils.Utils;

public class Monkey extends Thread {

    // ----------- Attributes -----------
    private int monkeyId;
    private String monkeyName;
    private int totalQuantityToConsume;
    private int maxTimeToConsume;
    private MonkeyPark sharedResource;

    // ----------- Complete Constructor -----------
    public Monkey(int monkeyId, String monkeyName, int totalQuantityToConsume, int maxTimeToConsume,
            MonkeyPark sharedResource) {
        this.monkeyId = monkeyId;
        this.monkeyName = monkeyName;
        this.totalQuantityToConsume = totalQuantityToConsume;
        this.maxTimeToConsume = maxTimeToConsume;
        this.sharedResource = sharedResource;
    }

    public int getMonkeyId() {
        return monkeyId;
    }

    public void setMonkeyId(int monkeyId) {
        this.monkeyId = monkeyId;
    }

    public String getMonkeyName() {
        return monkeyName;
    }

    public void setMonkeyName(String monkeyName) {
        this.monkeyName = monkeyName;
    }

    public int getTotalQuantityToConsume() {
        return totalQuantityToConsume;
    }

    public void setTotalQuantityToConsume(int totalQuantityToConsume) {
        this.totalQuantityToConsume = totalQuantityToConsume;
    }

    public int getMaxTimeToConsume() {
        return maxTimeToConsume;
    }

    public void setMaxTimeToConsume(int maxTimeToConsume) {
        this.maxTimeToConsume = maxTimeToConsume;
    }

    public MonkeyPark getSharedResource() {
        return sharedResource;
    }

    public void setSharedResource(MonkeyPark sharedResource) {
        this.sharedResource = sharedResource;
    }

    // ----------- Thread Logic -----------
    @Override
    public void run() {
        try {
            for (int i = 0; i < totalQuantityToConsume; i++) {

                String consumedProduct = sharedResource.consumeProduct(monkeyName);
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
