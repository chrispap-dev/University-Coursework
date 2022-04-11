import java.util.NoSuchElementException;

public class StringStackMain<Item> {
    public static void main(String[] args) {
        // Create an empty list
        StringStackImpl stack = new StringStackImpl();

        try {

            // Add 3 elements
            stack.push("first");
            stack.push("second");
            stack.push("third");

            // Remove
            //Item removed = stack.pop();
            System.out.println(stack.pop() + " just got removed");

            // Insert element
            stack.push("fourth");

            // keep removing until an exception is thrown
            System.out.println("Keep removing from stack!");
            for (int i = 0; i < 100; ++i) {
                System.out.println(stack.pop() + " just got removed");
            }
        } catch (NoSuchElementException ex) {
            System.out.println("Tried to remove from an empty stack!");
        }
    }
}