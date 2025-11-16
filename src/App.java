import net.salesianos.shared.MonkeyPark;
import net.salesianos.threads.Monkey;
import net.salesianos.threads.Tourist;

public class App {
    public static void main(String[] args) throws Exception {
        MonkeyPark monkeyPark = new MonkeyPark(5);

        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║  🍌 Welcome to the Monkey Park Simulator! 🙊   ║");
        System.out.println("╚════════════════════════════════════════════════╝\n" +
                "");

        Tourist tourist = new Tourist(3, "(👵) Concepción", 5, 2, monkeyPark);

        Monkey monkey = new Monkey(1, "(🐒) Chemita Jr.", 5, 3, monkeyPark);

        tourist.start();
        monkey.start();
    }
}
