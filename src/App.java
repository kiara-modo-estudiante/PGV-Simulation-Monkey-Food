import net.salesianos.shared.SharedResource;
import net.salesianos.threads.Monkey;
import net.salesianos.threads.Tourist;

public class App {
    public static void main(String[] args) throws Exception {
        SharedResource monkeyPark = new SharedResource(5);

        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║  🍌 Welcome to the Monkey Park Simulator! 🙊   ║");
        System.out.println("╚════════════════════════════════════════════════╝\n" + //
                "");

        Tourist touristOne = new Tourist(1, "(👩) Alice", 3, 3, monkeyPark);
        Tourist touristTwo = new Tourist(2, "(👴) Bob", 3, 3, monkeyPark);

        Monkey monkeyOne = new Monkey(1, "(🐒) George", 3, 2, monkeyPark);
        Monkey monkeyTwo = new Monkey(2, "(🐒) Charlie", 3, 4, monkeyPark);

        touristOne.start();
        touristTwo.start();
        monkeyOne.start();
        monkeyTwo.start();
    }
}
