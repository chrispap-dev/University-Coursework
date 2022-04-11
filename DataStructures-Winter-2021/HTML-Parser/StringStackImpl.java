

import java.io.PrintStream;
import java.util.NoSuchElementException;

public class StringStackImpl<Item> implements StringStack<Item> {
    private Node head;
    private int size;

    public StringStackImpl() {//no arguments constructor
        head = null;
        size = 0;
    }
    @Override
    public boolean isEmpty() { //is the stack empty ?
        return size == 0;
    }

    @Override
    public void push(Item item) {//push an item on top of the stack
        Node helper = new Node(item);
        Node oldhead = head;
        head = helper;
        head.setNext(oldhead);
        size++;
    }


    public Item pop() throws NoSuchElementException {//remove the last item and return it
        if(isEmpty()) throw new NoSuchElementException();
        Item item = (Item) head.getData();
        head = head.next;
        size--;
        return item;
    }

    @Override
    public Item peek() throws NoSuchElementException {//return the last item without removing it.
        if(isEmpty()) throw new NoSuchElementException();
        return (Item) head.getData();
    }

    @Override
    public void printStack(PrintStream stream) {
        if(isEmpty()) throw new NoSuchElementException();
        Node helper = head;
        while(helper!=null){
            System.out.println(helper.getData());
            if(helper.getNext() != null) {
                System.out.println("-->");
            }

            helper = helper.next;
        }
    }

    @Override
    public int size() {
        return this.size;
    } //returns the size of the stack. aka how many items inside it.
}
