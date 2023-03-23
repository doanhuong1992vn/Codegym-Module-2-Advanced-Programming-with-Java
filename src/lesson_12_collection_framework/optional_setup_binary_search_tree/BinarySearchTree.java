package lesson_12_collection_framework.optional_setup_binary_search_tree;

import java.util.Objects;

public class BinarySearchTree<E extends Comparable<E>> extends AbstractTree<E> {
    protected TreeNode<E> root;
    protected TreeNode<E> parent;
    protected TreeNode<E> current;
    protected int size = 0;

    public BinarySearchTree() {
    }

    protected TreeNode<E> createNewNode(E element) {
        return new TreeNode<>(element);
    }

    @Override
    public void insert(E element) {
        if (root == null) {
            root = createNewNode(element);
        } else {
            parent = null;
            current = root;
            while (current != null) {
                if (element.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (element.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else {
                    return;
                }
            }
            if (element.compareTo(parent.element) < 0) {
                parent.left = createNewNode(element);
            } else {
                parent.right = createNewNode(element);
            }
        }
        size++;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void inorder() {
        inorder(root);
    }

    private void inorder(TreeNode<E> root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.element + " ");
        inorder(root.right);
    }

    @Override
    public void postorder() {
        postorder(root);
    }

    private void postorder(TreeNode<E> root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.element + " ");
    }

    @Override
    public void preorder() {
        preorder(root);
    }

    private void preorder(TreeNode<E> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.element + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public boolean contains(E element) {
        return search(element, root);
    }

    private boolean search(E element, TreeNode<E> root) {
        current = root;
        if (element.compareTo(current.element) == 0) {
            return true;
        } else if (element.compareTo(current.element) < 0) {
            while (current.left != null) {
                parent = current;
                current = current.left;
                if (search(element, current)) {
                    return true;
                }
            }
            return false;
        } else {
            while (current.right != null) {
                parent = current;
                current = current.right;
                if (search(element, current)) {
                    return true;
                }
            }
            return false;
        }
    }

    public void remove(E element) {
        if (contains(element)) {
            if (current == parent.left) {
                if (current.left == null && current.right == null) {
                    parent.left = null;
                } else if (current.left == null || current.right == null) {
                    parent.left = Objects.requireNonNullElseGet(current.left, () -> current.right);
                } else {
                    TreeNode<E> successor = getLeftMostOfCurrentRight(current, current.right);
                    parent.left = successor;
                    successor.left = current.left;
                    successor.right = current.right;
                }
            } else {
                if (current.left == null && current.right == null) {
                    parent.right = null;
                } else if (current.left == null || current.right == null) {
                    parent.right = Objects.requireNonNullElseGet(current.left, () -> current.right);
                } else {
                    TreeNode<E> successor = getLeftMostOfCurrentRight(current, current.right);
                    parent.right = successor;
                    successor.left = current.left;
                    successor.right = current.right;
                }
            }
            size--;
        } else {
            System.out.println(element + " is NOT in tree!");
        }
    }

    private TreeNode<E> getLeftMostOfCurrentRight(TreeNode<E> current, TreeNode<E> right) {
        TreeNode<E> parentOfSuccessor = current;
        TreeNode<E> successor = right;
        while (successor.left != null) {
            parentOfSuccessor = successor;
            successor = successor.left;
        }
        if (successor == parentOfSuccessor.right) {
            if (successor.right != null) {
                parentOfSuccessor.right = successor.right;
            } else {
                parentOfSuccessor.right = null;
            }
        } else {
            parentOfSuccessor.left = successor.right;
        }
        return successor;
    }
}
