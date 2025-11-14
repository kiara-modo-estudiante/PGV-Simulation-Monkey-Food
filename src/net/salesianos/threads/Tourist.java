package net.salesianos.threads;

import net.salesianos.constants.FoodRepository;
import net.salesianos.shared.MonkeyPark;
import net.salesianos.utils.ConsoleColors;
import net.salesianos.utils.Utils;

public class Tourist extends Thread {

    // ----------- Attributes -----------
    private int touristId;
    private String touristName;
    private int totalQuantityToProduce;
    private int maxTimeToProduce;
    private MonkeyPark sharedResource;

    // ----------- Complete Constructor -----------
    public Tourist(int touristId, String touristName, int totalQuantityToProduce, int maxTimeToProduce,
            MonkeyPark sharedResource) {
        this.touristId = touristId;
        this.touristName = touristName;
        this.totalQuantityToProduce = totalQuantityToProduce;
        this.maxTimeToProduce = maxTimeToProduce;
        this.sharedResource = sharedResource;
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

    public int getMaxTimeToProduce() {
        return maxTimeToProduce;
    }

    public void setMaxTimeToProduce(int maxTimeToProduce) {
        this.maxTimeToProduce = maxTimeToProduce;
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
            for (int i = 0; i < totalQuantityToProduce; i++) {
                // Simulate producing food
                String producedFood = FoodRepository.getRandomFruit();
                System.out.println(
                        ConsoleColors.PURPLE + touristName + " is picking up: " + ConsoleColors.RESET + producedFood);

                int timeToProduce = Utils.getRandomTime(maxTimeToProduce);
                Thread.sleep(timeToProduce * 1000);

                sharedResource.addProduct(producedFood, touristName);
            }
            System.out.println(ConsoleColors.GREEN_BOLD + touristName + " has finished picking up fruits. 👋"
                    + ConsoleColors.RESET);
        } catch (InterruptedException e) {
            System.err.println(ConsoleColors.RED_BOLD + touristName + " was interrupted!" + ConsoleColors.RESET);
        }
    }

    // ----------- toString -----------
    @Override
    public String toString() {
        return "Tourist [touristId=" + touristId + ", name=" + touristName + ", totalQuantityToProduce="
                + totalQuantityToProduce
                + ", maxTimeToProduce=" + maxTimeToProduce + "]";
    }

}