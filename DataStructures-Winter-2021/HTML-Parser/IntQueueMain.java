import java.util.NoSuchElementException;

public class IntQueueMain {
    public static void main(String[] args) {
        // Create an empty list
        IntQueue queue = new IntQueueImpl();

        try {

            // Add 3 elements at back
            queue.put(2);
            queue.put(7);
            queue.put(9);

            // Remove from front
            Object removed = queue.get();
            System.out.println(removed + " just got removed");

            // Insert ta back
            queue.put(6);

            // keep removing until an exception is thrown
            System.out.println("Keep removing from queue!");
            for (int i = 0; i < 100; ++i) {
                removed = queue.get();
                System.out.println(removed + " just got removed");
            }
        } catch (NoSuchElementException ex) {
            System.out.println("Tried to remove from an empty queue!");
        }
    }
}

