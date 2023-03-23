package lesson_12_collection_framework.optional_setup_binary_search_tree;

public class TestBST {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(15);
        tree.insert(5);
        tree.insert(16);
        tree.insert(12);
        tree.insert(20);
        tree.insert(3);
        tree.insert(10);
        tree.insert(6);
        tree.insert(13);
        tree.insert(7);
        tree.insert(18);
        tree.insert(23);
        //traverse tree
        tree.remove(12);
        System.out.println("Inorder (sorted): ");
        tree.inorder();
        System.out.println("\nThe number of nodes is: " + tree.getSize());
        System.out.println("Postorder (sorted): ");
        tree.postorder();
        System.out.println("\nPreorder (sorted): ");
        tree.preorder();
        System.out.println();
        if(tree.contains(9)){
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
