package optional_setup_binary_search_tree;

public class AbstractTree<E> implements Tree<E> {
    @Override
    public boolean insert(E element) {
        return false;
    }

    @Override
    public void inorder() {
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public void preorder() {
    }

    @Override
    public void postorder() {
    }
}
