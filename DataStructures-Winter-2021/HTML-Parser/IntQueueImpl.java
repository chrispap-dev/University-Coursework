import java.io.PrintStream;
import java.util.NoSuchElementException;

public class IntQueueImpl<Item> implements IntQueue<Item> {
    private Node head ;
    private Node tail ;
    private int size;

    public IntQueueImpl(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void put(Item item) {
        Node n = new Node(item);
        if (isEmpty()){
            head = tail = n;
        }else{
            tail.setNext(n);
            tail = n;
        }
        size++;

    }

    @Override
    public Item get() throws NoSuchElementException {
        if(isEmpty()) throw new NoSuchElementException();

        Item deleted_node =(Item) head.getData();

        if(head==tail){
            head = tail = null;//Λογική διαγραφή
        }else{
            head = head.next;
        }
        size--;
        return deleted_node;
    }

    @Override
    public Item peek() throws NoSuchElementException {
        if(isEmpty()) throw new NoSuchElementException();

        Item oldest_item =(Item) head.getData();
        return oldest_item;
    }

    @Override
    public void printQueue(PrintStream stream) {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        }else{
            Node start = head;
            while (start != null){
                System.out.println(start.getData());
                if(start.getNext() != null) {
                    System.out.println("-->");
                }
                start = start.next;
            }
        }

    }

    @Override
    public int size() {
        return size;
    }
}
