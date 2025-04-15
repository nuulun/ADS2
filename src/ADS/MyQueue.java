
package ADS;

public class MyQueue<T extends Comparable<T>> {
    private MyLinkedList<T> list;

    public MyQueue() {
        list = new MyLinkedList<>();
    }

    public void enqueue(T element) {
        list.addLast(element);
    }

    public void dequeue() {

        System.out.println(list.get(0));
        list.removeFirst();
    }

    public void peek() {

        System.out.println(list.getFirst());
    }

    public boolean empty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }


}