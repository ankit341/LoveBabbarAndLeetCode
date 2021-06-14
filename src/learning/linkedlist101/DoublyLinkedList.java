package learning.linkedlist101;

import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T> {
    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    private class Node<T> {
        T data;
        Node<T> previous, next;

        public Node(T data, Node<T> previous, Node<T> next) {
            this.data = data;
            this.previous = previous;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data.toString() +
                    '}';
        }
    }

    public void clear() {
        Node<T> traverse = this.head;
        while (traverse != null) {
            Node<T> next = traverse.next;
            traverse.previous = null;
            traverse.next = null;
            traverse = next;
        }
        head = tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(T element) {
        if (isEmpty()) {
            head = tail = new Node<T>(element, null, null);
        } else {
            head.previous = new Node<T>(element, null, head);
            head = head.previous;
        }
        size++;
    }

    public void addLast(T element) {
        if (isEmpty()) {
            tail = head = new Node<T>(element, null, null);
        } else {
            tail.next = new Node<T>(element, tail, null);
            tail = tail.next;
        }
    }

    public T peekFirst() {
        if (isEmpty())
            throw  new RuntimeException("The list is empty");
        return head.data;
    }

    public T peekLast() {
        if (isEmpty())
            throw new RuntimeException("The list is empty");
        return tail.data;
    }

    public void add(T element) {
        addLast(element);
    }

    public T removeFirst() {
        if (isEmpty())
            throw new RuntimeException("The list is empty");

        T data = head.data;
        head = head.next;
        size--;

        if (isEmpty()) tail = null;

        else head.previous = null;

        return data;
    }

    public T removeLast() {
        if (isEmpty())
            throw new RuntimeException("The list is empty");

        T data = tail.data;
        tail = tail.previous;
        size--;

        if (isEmpty()) head = null;

        else tail.next = null;

        return data;
    }

    public T remove(Node<T> node) {
        if (node.next == null) removeLast();
        if (node.previous == null) removeFirst();

        node.previous.next = node.next;
        node.next.previous = node.previous;

        T data = node.data;

        node.data = null;
        node.previous = node.next = node =  null;

        size--;
        return data;
    }

    public T removeAtIndex(int index) {
        if (index < 0 || index > size) throw new IllegalArgumentException("Please specify a correct index");

        int i;
        Node<T> traverse;
        if (index < size/2) {
            for (i = 0, traverse = head; i != index; i++) {
                traverse = traverse.next;
            }
        } else {
            for (i = size - 1, traverse = tail; i != index; i--) {
                traverse = traverse.previous;
            }
        }

        return remove(traverse);
    }

    public int indexOfElement(T element) {
        int index = 0;
        Node<T> traverse;

        if (element == null) {
            for (traverse = head; traverse != null; traverse = traverse.next, index++) {
                if (traverse.data == null)
                    return index;
            }
        } else {
            for (traverse = head; traverse != null; traverse = traverse.next, index++) {
                if (traverse.data == element)
                    return index;
            }
        }
        return -1;
    }

    public boolean contains(T element) {
        return indexOfElement(element) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> traverse = head;
            @Override
            public boolean hasNext() {
                return traverse != null;
            }

            @Override
            public T next() {
                T data = traverse.data;
                traverse = traverse.next;
                return data;
            }
        };
    }
}
