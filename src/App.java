import net.salesianos.shared.SharedResource;
import net.salesianos.threads.Tourist;
import net.salesianos.utils.ConsoleColors;

public class App {
    public static void main(String[] args) throws Exception {
        SharedResource monkeyPark = new SharedResource(5);

        Tourist.setSharedResource(monkeyPark);

        String[] food = { "🍌 Banana", "🍎 Apple", "🍊 Orange", "🍇 Grapes", "🍍 Pineapple", "🥭 Mango", "🍑 Peach",
                "🍓 Strawberry",
                "🫐  Blueberry", "🍉 Watermelon" };

        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║      Welcome to the Monkey Park Simulator!     ║");
        System.out.println("╚════════════════════════════════════════════════╝\n" + //
                "");

        Tourist tourist1 = new Tourist(1, "👩 Alice", 3, food, 3);
        Tourist tourist2 = new Tourist(2, "👴 Bob", 3, food, 3);

        tourist1.start();
        tourist2.start();
    }
}
