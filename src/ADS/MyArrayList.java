package ADS;

import java.util.Iterator;

public class MyArrayList<T extends Comparable<T>> implements MyList<T> {
    private Object[] array;
    private int size = 0;
    private  int capacity = 5;

    public MyArrayList() {
        array = new Object[capacity];
    }

    private void increaseBuffer() {
        capacity = (int) (1.5 *capacity);
        Object[] newArray = new Object[capacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }


    @Override
    public void add(T item) {
        if (size == capacity) {
            increaseBuffer();
        }
        array[size++] = item;

    }

    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    @Override
    public void addLast(T item) {
        if (capacity == size) {
            increaseBuffer();
        }
        array[size++] = item;
    }

    @Override
    public void add(int index, T item) {
        if (capacity == size) {
            increaseBuffer();
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = item;
        size++;
    }

    @Override
    public T get(int index) {
        return (T) array[index];
    }

    @Override
    public T getFirst() {
        return get(0);
    }

    @Override
    public T getLast() {
        return get(size - 1);
    }

    @Override
    public void set(int index, T item) {
        array[index] = item;
    }

    @Override
    public void remove(int index) {
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(size - 1);
    }

    @Override
    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                Comparable<T> a = (Comparable<T>) array[j];
                T b = (T) array[j + 1];
                if (a.compareTo(b) > 0) {
                    Object temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (object == array[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {

        return size -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        System.arraycopy(array, 0, result, 0, size);
        return result;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;
            public boolean hasNext() {
                return index < size;
            }
            public T next() {
                return (T) array[index++];
            }
        };
    }
}
