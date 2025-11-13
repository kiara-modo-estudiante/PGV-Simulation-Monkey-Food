import net.salesianos.shared.SharedResource;
import net.salesianos.threads.Tourist;

public class App {
    public static void main(String[] args) throws Exception {
        SharedResource sharedResource = new SharedResource(5);

        Tourist.setSharedResource(sharedResource);

        String[] food = { "🍌 Banana", "🍎 Apple", "🍊 Orange", "🍇 Grapes", "🍍 Pineapple", "🥭 Mango", "🍑 Peach",
                "🍓 Strawberry",
                "🫐 Blueberry", "🍉 Watermelon" };

        Tourist tourist1 = new Tourist(1, "👩 Alice", 3, food, 3);
        Tourist tourist2 = new Tourist(2, "👴 Bob", 3, food, 3);

        tourist1.start();
        tourist2.start();
    }
}
