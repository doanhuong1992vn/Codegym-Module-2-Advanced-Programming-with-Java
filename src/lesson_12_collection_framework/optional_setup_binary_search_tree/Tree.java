package lesson_12_collection_framework.optional_setup_binary_search_tree;

public interface Tree<E> {
    void insert(E element);
    void inorder();
    int getSize();
    void postorder();
    void preorder();
}
