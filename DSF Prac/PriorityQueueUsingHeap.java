public class PriorityQueueUsingHeap {

    public static class MinHeap {
        private int[] heap;
        private int size;
        private int capacity;

        public MinHeap(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            this.heap = new int[capacity];
        }

        private int parent(int i) {
            return (i - 1) / 2;
        }

        private int leftChild(int i) {
            return 2 * i + 1;
        }

        private int rightChild(int i) {
            return 2 * i + 2;
        }

        private void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }

        public void insert(int value) {
            if (size == capacity) {
                System.out.println("Priority queue is full. Cannot insert more elements.");
                return;
            }

            size++;
            int i = size - 1;
            heap[i] = value;

            // Fix the min-heap property by swapping with parent if necessary
            while (i > 0 && heap[parent(i)] > heap[i]) {
                swap(i, parent(i));
                i = parent(i);
            }
        }

        public int extractMin() {
            if (size <= 0) {
                System.out.println("Priority queue is empty. Cannot extract minimum element.");
                return -1; // Assuming -1 as a sentinel value for an empty queue
            }

            if (size == 1) {
                size--;
                return heap[0];
            }

            int root = heap[0];
            heap[0] = heap[size - 1];
            size--;

            // Fix the min-heap property by heapifying down
            heapifyDown(0);

            return root;
        }

        private void heapifyDown(int i) {
            int left = leftChild(i);
            int right = rightChild(i);
            int smallest = i;

            // Compare with left child
            if (left < size && heap[left] < heap[smallest]) {
                smallest = left;
            }

            // Compare with right child
            if (right < size && heap[right] < heap[smallest]) {
                smallest = right;
            }

            // If the smallest is not the current node, swap and continue heapifying down
            if (smallest != i) {
                swap(i, smallest);
                heapifyDown(smallest);
            }
        }
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);

        minHeap.insert(4);
        minHeap.insert(2);
        minHeap.insert(8);
        minHeap.insert(1);

        System.out.println("Priority Queue Elements:");
        while (minHeap.size > 0) {
            System.out.println(minHeap.extractMin());
        }
    }
}
