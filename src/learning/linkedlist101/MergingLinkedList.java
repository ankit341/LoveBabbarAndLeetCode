package learning.linkedlist101;


public class MergingLinkedList {
    public static void main(String[] args) {
        Node<Integer> headNode = new Node<>(14);
        int size = 5;
        Node<Integer> traverseNode = headNode;

        int counter = 0;
        while (counter < size) {
            int data = 14;
            traverseNode.next = new Node<>(++data);
            counter++;
        }

        Node<Integer> headNode2 = new Node<>(81);
        counter = 0;
        traverseNode = headNode2;

        while (counter < size) {
            int data = 81;
            traverseNode.next = new Node<>(++data);
            counter++;
        }

        System.out.println();

    }
}
