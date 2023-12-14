package Heapg;

public class BinaryHeap {
    int array[];
    int sizeOfTree;

    public BinaryHeap(int size) {
        array = new int[size + 1];
        this.sizeOfTree = 0;
        System.out.println("Heap has been created");
    }

    public boolean isEmpty() {
        return (sizeOfTree == 0);
    }

    public Integer peek() {
        if (isEmpty()) {
            System.out.println("Heap is empty");
            return null;
        }
        return array[1];
    }

    public int sizeOFHeap() {
        return sizeOfTree;
    }

    public void levelOrder() {
        for (int i = 1; i <= sizeOfTree; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    // Heapify for Insert
    public void heapifyBottomToTop(int index, String heapType) {
        int parent = index / 2;
        if (index <= 1) {
            return;
        }
        if ("min".equals(heapType)) {
            if (array[index] < array[parent]) {
                int temp = array[index];
                array[index] = array[parent];
                array[parent] = temp;
            }
        } else if ("max".equals(heapType)) {
            if (array[index] > array[parent]) {
                int temp = array[index];
                array[index] = array[parent];
                array[parent] = temp;
            }
        }
        heapifyBottomToTop(parent, heapType);
    }

    public void insert(int value, String heapType) {
        if (sizeOfTree + 1 < array.length) {
            array[sizeOfTree + 1] = value;
            sizeOfTree++;
            heapifyBottomToTop(sizeOfTree, heapType);
            System.out.println("Value is inserted");
        } else {
            System.out.println("Heap is full. Cannot insert value.");
        }
    }

    // Heapify top to bottom
    public void heapifyTopToBottom(int index, String heapType) {
        int left = index * 2;
        int right = index * 2 + 1;

        // Check if left child exists
        if (sizeOfTree < left) {
            return;
        }

        int swapChild = -1; // Initialize to an invalid value

        if ("min".equals(heapType)) {
            // Check if only left child exists
            if (sizeOfTree == left) {
                if (array[index] > array[left]) {
                    // Swap values if needed
                    int temp = array[index];
                    array[index] = array[left];
                    array[left] = temp;
                }
                return;
            } else {
                // Determine which child is smaller
                if (array[left] < array[right]) {
                    swapChild = left;
                } else {
                    swapChild = right;
                }
            }
        } else if ("max".equals(heapType)) {
            // Implementation for max-heap (similar to min-heap logic)
            // You may need to modify this part based on your specific requirements.
            if (sizeOfTree == left) {
                if (array[index] < array[left]) {
                    int temp = array[index];
                    array[index] = array[left];
                    array[left] = temp;
                }
                return;
            } else {
                if (array[left] > array[right]) {
                    swapChild = left;
                } else {
                    swapChild = right;
                }
            }
        } else {
            // Handle invalid heapType (neither "min" nor "max")
            System.out.println("Invalid heapType");
            return;
        }

        // Swap with the smaller (or larger) child if needed
        if (array[index] > array[swapChild]) {
            int temp = array[index];
            array[index] = array[swapChild];
            array[swapChild] = temp;

            // Recursively call heapifyTopToBottom on the swapped child
            heapifyTopToBottom(swapChild, heapType);
        }
    }

    public int extractHead(String heapType) {
        if (isEmpty()) {
            return -1;
        } else {
            int extractedValue = array[1];
            array[1] = array[sizeOfTree];
            sizeOfTree--;
            heapifyTopToBottom(1, heapType);
            return extractedValue;
        }
    }
}
