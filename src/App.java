import net.salesianos.shared.MonkeyPark;
import net.salesianos.threads.Monkey;
import net.salesianos.threads.Tourist;

public class App {
    public static void main(String[] args) throws Exception {
        MonkeyPark monkeyPark = new MonkeyPark(5);

        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║  🍌 Welcome to the Monkey Park Simulator! 🙊   ║");
        System.out.println("╚════════════════════════════════════════════════╝\n" + //
                "");

        Tourist touristOne = new Tourist(1, "(👩) Alice", 2, 2, monkeyPark);
        Tourist touristTwo = new Tourist(2, "(👴) Bob", 3, 2, monkeyPark);
        Tourist touristThree = new Tourist(3, "(👶) Timmy", 8, 2, monkeyPark);

        Monkey monkeyOne = new Monkey(1, "(🐒) George", 2, 2, monkeyPark);
        Monkey monkeyTwo = new Monkey(2, "(🐒) Charlie", 3, 4, monkeyPark);
        Monkey monkeyThree = new Monkey(3, "(🦍) Kong", 7, 2, monkeyPark);
        Monkey monkeyFour = new Monkey(4, "(🐒) Pepito", 1, 10, monkeyPark);

        touristOne.start();
        touristTwo.start();
        touristThree.start();
        monkeyOne.start();
        monkeyTwo.start();
        monkeyThree.start();
        monkeyFour.start();
    }
}
