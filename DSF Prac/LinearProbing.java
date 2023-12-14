public class LinearProbing {
    int currentSize, maxSize;
    String[] keys;
    String[] values;

    public LinearProbing(int capacity) {
        currentSize = 0;
        maxSize = capacity;
        keys = new String[capacity];
        values = new String[capacity];
    }

    public void makeEmpty() {
        currentSize = 0;
        keys = new String[currentSize];
        values = new String[currentSize];
    }

    public int getSize() {
        return currentSize;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean isFull() {
        return currentSize == maxSize;
    }

    public int hash(String k) {
        // Simple hash function, you may want to improve this
        return Math.abs(k.hashCode()) % maxSize;
    }

    public void insert(String k, String v) {
        if (isFull()) {
            System.out.println("Hash table is full. Cannot insert more elements.");
            return;
        }

        int index = hash(k);

        while (keys[index] != null) {
            // Linear probing: move to the next slot
            index = (index + 1) % maxSize;
        }

        keys[index] = k;
        values[index] = v;
        currentSize++;
    }

    public static void main(String[] args) {
        LinearProbing hashTable = new LinearProbing(10);

        hashTable.insert("1", "value1");
        hashTable.insert("2", "value2");
        hashTable.insert("3", "value3");

        // Print the current state of the hash table
        for (int i = 0; i < hashTable.maxSize; i++) {
            System.out.println("Index " + i + ": " + hashTable.keys[i] + " -> " + hashTable.values[i]);
        }
    }
}
