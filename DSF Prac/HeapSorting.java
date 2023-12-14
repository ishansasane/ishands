public class HeapSorting {
    // Class for performing Heap Sort

    public void sort(int a[]) {
        // Method to perform Heap Sort on an array

        int n = a.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(a, n, i);

        // Extract elements from the heap one by one
        for (int i = n - 1; i >= 0; i--) {
            // Swap the root (maximum element) with the last element
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;

            // Call heapify on the reduced heap
            heapify(a, i, 0);
        }
    }

    void heapify(int a[], int n, int i) {
        // Heapify function to maintain the max heap property

        int largest = i;
        int l = 2 * i + 1; // Left child index
        int r = 2 * i + 2; // Right child index

        if (l < n && a[l] > a[largest])
            largest = l;

        if (r < n && a[r] > a[largest])
            largest = r;

        if (largest != i) {
            // Swap a[i] and a[largest]
            int swap = a[i];
            a[i] = a[largest];
            a[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(a, n, largest);
        }
    }

    static void printArray(int a[]) {
        // Utility method to print an array
        int n = a.length;
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");

        System.out.println();
    }

    public static void main(String args[]) {
        // Main method for testing Heap Sort

        int a[] = { 1, 12, 9, 5, 6, 10 };
        int n = a.length;

        HeapSorting heapSort = new HeapSorting(); // Create an instance of HeapSorting

        heapSort.sort(a); // Call the sort method to perform Heap Sort
        System.out.println("Sorted array:");
        printArray(a); // Print the sorted array
    }
}
