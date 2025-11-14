package net.salesianos.constants;

import java.util.Random;

public class FoodRepository {
    public static final String[] FOOD = {
            "(🍌) Banana", "(🍎) Red Apple", "(🍊) Orange", "(🍇) Grapes", "(🍍) Pineapple",
            "(🥭) Mango", "(🍑) Peach", "(🍓) Strawberry", "(🫐 ) Blueberry", "(🍉) Watermelon",
            "(🥝) Kiwi", "(🍒) Cherry", "(🍋) Lemon", "(🍈) Melon", "(🍏) Green Apple"
    };

    private static final Random random = new Random();

    /**
     * Selects a random fruit from the food array.
     * 
     * @return A random fruit from the food array.
     */
    public static String getRandomFruit() {
        return FOOD[random.nextInt(FOOD.length)];
    }
}