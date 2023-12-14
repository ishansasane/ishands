class Node {
    int data;
    Node pre, next;

    public Node(int data) {
        this.data = data;
        this.pre = null;
        this.next = null;
    }
}

public class StackImp {
    Node top;

    public StackImp() {
        top = null;
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top.pre = newNode;
            top = newNode;
        }

    }

    public int pop() {
        int poped = top.data;
        top = top.next;
        if (top != null) {
            top.pre = null;
        }
        return poped;

    }

    public void display() {
        Node current = top;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        StackImp obj=new StackImp();
        obj.insert(11);
        obj.insert(12);
        obj.insert(13);
        obj.insert(14);
        obj.insert(15);

        obj.display();

        System.out.println("Element poped :-"+obj.pop());
        System.out.println("Stack after poped ");
        obj.display();
    }

}
