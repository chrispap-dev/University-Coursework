package Stack;

public class Node<Item> {
    protected Item item;
    protected Node<Item> next = null;//αυτοαναφορά

    Node(Item item) {
        this.item = item;
    }

    public Item getData() {
        return this.item;
    }

    public Node<Item> getNext() {
        return this.next;
    }

    public void setNext(Node<Item> next) {
        this.next = next;
    }
}