class Node {
    int data;
    Node pre, next;

    public Node(int data) {
        this.data = data;
        this.pre = null;
        this.next = null;
    }
}
public class QueueImp {
    Node head,tail;
    public QueueImp(){
        head=null;
        tail=null;
    }
    public void enqueue(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            tail=newNode;
        }else{
            newNode.pre=tail;
            tail.next=newNode;
            tail=newNode;
        }
    }
    public int dequeue(){
        int poped=head.data;
        head=head.next;
        if(head!=null){
            head.pre=null;
        }
        return poped;
    }
    public void display(){
        Node newNode=head;
        while (newNode!=null) {
            System.out.println(newNode.data);
            newNode=newNode.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        QueueImp obj=new QueueImp();
        obj.enqueue(1);
        obj.enqueue(2);
        obj.enqueue(3);
        obj.enqueue(4);
        obj.enqueue(5);

        obj.display();

        System.out.println("Deleted Element -"+obj.dequeue());
        System.out.println("\n");
        obj.display();
    }
}
