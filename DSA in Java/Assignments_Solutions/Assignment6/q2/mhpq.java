import java.util.ArrayList;

public class mhpq {

    private ArrayList<Integer> heap;

    public mhpq() {
        heap = new ArrayList<>();
    }

    public void insert(int value) {
        heap.add(value);
        int current = heap.size() - 1;

        while (current > 0) {
            int parent = (current - 1) / 2;

            if (heap.get(current) <= heap.get(parent)) {
                break;
            }

            int temp = heap.get(current);
            heap.set(current, heap.get(parent));
            heap.set(parent, temp);

            current = parent;
        }
    }

    public int extractMax() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        int max = heap.get(0);
        int lastElement = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, lastElement);
            maxheapify(0);
        }

        return max;
    }

    private void maxheapify(int i) {
        int size = heap.size();
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && heap.get(left) > heap.get(largest)) {
            largest = left;
        }
        if (right < size && heap.get(right) > heap.get(largest)) {
            largest = right;
        }
        if (largest != i) {
            int temp = heap.get(i);
            heap.set(i, heap.get(largest));
            heap.set(largest, temp);

            maxheapify(largest);
        }
    }

    public static void main(String[] args) {
        mhpq pq = new mhpq();

        pq.insert(10);
        pq.insert(20);
        pq.insert(15);

        System.out.println("Extracted max: " + pq.extractMax());
        System.out.println("Extracted max: " + pq.extractMax());
        System.out.println("Extracted max: " + pq.extractMax());
    }
}
