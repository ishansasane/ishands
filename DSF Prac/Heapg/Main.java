package Heapg;

public class Main {

    public static void main(String[] args) {
        BinaryHeap obj=new BinaryHeap(5);
        obj.insert(10, "min");
        obj.insert(5, "min");
        obj.insert(15, "min");
        obj.insert(1, "min");
        obj.levelOrder();
        obj.extractHead("min");
        obj.levelOrder();
    }
}
