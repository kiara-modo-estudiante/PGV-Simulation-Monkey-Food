package net.salesianos.utils;

import java.util.Random;

public class Utils {
    private static final Random random = new Random();

    /**
     * Generates a random time within the range [1, maxTime].
     * 
     * @param maxTime The maximum time (in seconds).
     * @return A random time (in seconds).
     */
    public static int getRandomTime(int maxTime) {
        return (int) (Math.random() * maxTime) + 1;
    }

    /**
     * Selects a random item from an array of strings.
     * 
     * @param items The array of strings to select from.
     * @return A random string from the array.
     * @throws IllegalArgumentException if the array is null or empty.
     */
    public static String getRandomItem(String[] items) {
        if (items == null || items.length == 0) {
            throw new IllegalArgumentException("The array must not be null or empty.");
        }
        return items[random.nextInt(items.length)];
    }
}
