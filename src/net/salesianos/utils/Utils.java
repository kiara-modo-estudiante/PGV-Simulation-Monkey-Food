package net.salesianos.utils;

public class Utils {
    /**
     * Generates a random time within the range [1, maxTime].
     * 
     * @param maxTime The maximum time (in seconds).
     * @return A random time (in seconds).
     */
    public static int getRandomTime(int maxTime) {
        return (int) (Math.random() * maxTime) + 1;
    }
}
