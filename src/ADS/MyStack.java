package ADS;

public class MyStack<T extends Comparable<T>> {
    private MyArrayList<T> list;

    public MyStack() {
        list = new MyArrayList<>();
    }

    public void push(T item) {
        list.add(item);
    }

    public void pop() {
        System.out.println(list.get(list.size() - 1));
        list.remove(list.size() - 1);
    }

    public void peek() {
        System.out.println(list.get(list.size() - 1));
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }


}