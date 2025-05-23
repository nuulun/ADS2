package ADS;

public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> list;

    public MyMinHeap() {
        list = new MyArrayList<>();
    }

    public T getMin() {
        return list.getFirst();
    }



    public void insert(T item) {
        list.add(item);
        traversUp(list.size() - 1);
    }

    public T extractMin() {
        if (empty()) return null;

        T min = list.get(0);
        T last = list.get(list.size() - 1);
        list.set(0, last);
        list.remove(list.size() - 1);
        heapifyDown(0);

        return min;
    }



    public boolean empty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }



    private void traversUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            T current = list.get(index);
            T parentValue = list.get(parent);
            if (current.compareTo(parentValue) < 0) {
                list.set(index, parentValue);
                list.set(parent, current);
                index = parent;
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int index) {
        int size = list.size();
        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < size && list.get(left).compareTo(list.get(smallest)) < 0) {
                smallest = left;
            }
            if (right < size && list.get(right).compareTo(list.get(smallest)) < 0) {
                smallest = right;
            }

            if (smallest != index) {
                T temp = list.get(index);
                list.set(index, list.get(smallest));
                list.set(smallest, temp);
                index = smallest;
            } else {
                break;
            }
        }
    }
}