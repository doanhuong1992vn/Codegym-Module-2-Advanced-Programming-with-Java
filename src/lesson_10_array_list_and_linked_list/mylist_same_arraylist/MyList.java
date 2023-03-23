package lesson_10_array_list_and_linked_list.mylist_same_arraylist;

import java.util.Arrays;


public class MyList<E> {
    // Mảng chứa các phần tử trong danh sách
    private Object[] elements;
    // Số lượng phần tử hiện có trong danh sách
    private int size;
    // Số lượng phần tử mặc định được cấp phát ban đầu khi khởi tạo đối tượng
    private static final int DEFAULT_CAPACITY = 10;

    // Khởi tạo một danh sách rỗng với kích thước ban đầu là DEFAULT_CAPACITY
    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    // Khởi tạo một danh sách rỗng với kích thước ban đầu được chỉ định
    public MyList(int initialCapacity) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Invalid initial capacity: " + initialCapacity);
        elements = new Object[initialCapacity];
    }

    // Thêm một phần tử vào vị trí chỉ định trong danh sách
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        ensureCapacity(size + 1);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    // Xóa phần tử tại vị trí chỉ định trong danh sách
    public E remove(int index) {
        rangeCheck(index);
        E oldValue = (E) elements[index];
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        elements[--size] = null;
        return oldValue;
    }

    // Trả về số lượng phần tử đang có trong danh sách
    public int size() {
        return size;
    }
    // Clone:

    // Kiểm tra xem danh sách có chứa phần tử chỉ định hay không
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    // Trả về vị trí đầu tiên của phần tử được chỉ định trong danh sách
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++)
                if (elements[i] == null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (o.equals(elements[i]))
                    return i;
        }
        return -1;
    }

    // Thêm một phần tử vào cuối danh sách
    public boolean add(E e) {
        ensureCapacity(size + 1);
        elements[size++] = e;
        return true;
    }

    public void ensureCapacity(int minCapacity) {
        int currentCapacity = elements.length;
        if (minCapacity > currentCapacity) {
            int newCapacity = currentCapacity + (currentCapacity >> 1);
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    // Trả về phần tử tại vị trí chỉ định trong danh sách
    public E get(int index) {
        rangeCheck(index);
        return (E) elements[index];
    }

    // Xóa tất cả các phần tử khỏi danh sách
    public void clear() {
        Arrays.fill(elements, 0, size, null);
        size = 0;
    }

    // Kiểm tra xem danh sách có phần tử hay không
    public boolean isEmpty() {
        return size == 0;
    }

    // Trả về vị trí cuối cùng của phần tử được chỉ định trong danh sách
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size - 1; i >= 0; i--)
                if (elements[i] == null)
                    return i;
        } else {
            for (int i = size - 1; i >= 0; i--)
                if (o.equals(elements[i]))
                    return i;
        }
        return -1;
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    // set 1 phần tử được chỉ định vào vị trí được chỉ định trong danh sách
    public E set(int index, E element) {
        rangeCheck(index);
        E oldValue = (E) elements[index];
        elements[index] = element;
        return oldValue;
    }

    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    // Xóa một phần tử được chỉ định trong danh sách
    public boolean remove(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    fastRemove(i);
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) {
                    fastRemove(i);
                    return true;
                }
            }
        }
        return false;
    }

    private void fastRemove(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        elements[--size] = null;
    }

}