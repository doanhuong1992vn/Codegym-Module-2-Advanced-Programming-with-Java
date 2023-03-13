package optional_setup_binary_search_tree;

public interface Tree<E> {
    boolean insert(E element);
    void inorder();
    int getSize();
    void postorder();
    void preorder();
}
