package net.salesianos.threads;

import java.util.Arrays;

import net.salesianos.shared.SharedResource;
import net.salesianos.utils.Utils;

public class Tourist extends Thread {

    // ----------- Attributes -----------
    private int touristId;
    private String touristName;
    private int totalQuantityToProduce;
    private String[] food;
    private int maxTimeToProduce;
    private static SharedResource sharedResource;

    // ----------- Complete Constructor -----------
    public Tourist(int touristId, String touristName, int totalQuantityToProduce, String[] food, int maxTimeToProduce) {
        this.touristId = touristId;
        this.touristName = touristName;
        this.totalQuantityToProduce = totalQuantityToProduce;
        this.food = food;
        this.maxTimeToProduce = maxTimeToProduce;
    }

    // ----------- Static Method to Set Shared Resource -----------
    public static void setSharedResource(SharedResource resource) {
        sharedResource = resource;
    }

    // ----------- Getters and Setters -----------
    public int getTouristId() {
        return touristId;
    }

    public void setTouristId(int touristId) {
        this.touristId = touristId;
    }

    public String getTouristName() {
        return touristName;
    }

    public void setTouristName(String touristName) {
        this.touristName = touristName;
    }

    public int getTotalQuantityToProduce() {
        return totalQuantityToProduce;
    }

    public void setTotalQuantityToProduce(int totalQuantityToProduce) {
        this.totalQuantityToProduce = totalQuantityToProduce;
    }

    public String[] getFood() {
        return food;
    }

    public void setFood(String[] food) {
        this.food = food;
    }

    public int getMaxTimeToProduce() {
        return maxTimeToProduce;
    }

    public void setMaxTimeToProduce(int maxTimeToProduce) {
        this.maxTimeToProduce = maxTimeToProduce;
    }

    // ----------- Thread Logic -----------
    @Override
    public void run() {
        try {
            for (int i = 0; i < totalQuantityToProduce; i++) {
                // Simulate producing food
                String producedFood = food[i % food.length];
                System.out.println(touristName + " is picking up: " + producedFood);

                int timeToProduce = Utils.getRandomTime(maxTimeToProduce);
                Thread.sleep(timeToProduce * 1000);

                sharedResource.addProduct(producedFood);
            }
            System.out.println(touristName + " has finished picking up fruits. 👋");
        } catch (InterruptedException e) {
            System.err.println(touristName + " was interrupted!");
        }
    }

    // ----------- toString -----------
    @Override
    public String toString() {
        return "Tourist [touristId=" + touristId + ", name=" + touristName + ", totalQuantityToProduce="
                + totalQuantityToProduce
                + ", food=" + Arrays.toString(food) + ", maxTimeToProduce=" + maxTimeToProduce + "]";
    }
}