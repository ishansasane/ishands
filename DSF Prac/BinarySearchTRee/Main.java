package BinarySearchTRee;

public class Main {
    public static void main(String[] args) {
        BinaryTree btst=new BinaryTree();
        btst.insert(12);
        btst.insert(11);
        btst.insert(13);
        btst.insert(5);
        btst.insert(16);
        btst.inorder();

        btst.delete(13);
        System.out.println("After deletion -\n");
        btst.inorder();
    }
}
