package lesson_12_collection_framework.optional_setup_binary_search_tree;

public class TreeNode<E> {
    protected E element;
    protected TreeNode<E> left;
    protected TreeNode<E> right;
    public TreeNode(E element){
        this.element = element;
    }
}
