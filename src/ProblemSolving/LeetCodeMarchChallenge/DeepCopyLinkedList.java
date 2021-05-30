package ProblemSolving.LeetCodeMarchChallenge;

import java.util.HashMap;
import java.util.Map;

public class DeepCopyLinkedList {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        Node tempNode = new Node(0);
        Node currentNode = tempNode;
        Node headClone = head;
        Map<Integer, Node> mapForNewListForRandomPointers = new HashMap<>();
        Map<Integer, Integer> mapForNewListForRandomPointersNumber = new HashMap<>();

        while (head != null) {
            currentNode.next = new Node(head.val);
            mapForNewListForRandomPointers.put(head.val, currentNode);
            currentNode = currentNode.next;
            if (head.random != null) {
                mapForNewListForRandomPointersNumber.put(head.val, head.random.val);
            }
            head = head.next;
        }

        currentNode = tempNode.next;
        while (headClone != null) {
            if (headClone.random == null) {
                currentNode.random = null;
            } else {
                int randomValue = mapForNewListForRandomPointersNumber.get(headClone.val);
                currentNode.random = mapForNewListForRandomPointers.get(randomValue);
            }
            currentNode = currentNode.next;
            headClone = headClone.next;
        }

        return tempNode.next;
    }

    public static void main(String[] args) {
        Map<Integer, Node> mapForNewListForRandomPointers = new HashMap<>();
        System.out.println(mapForNewListForRandomPointers.toString());
    }
}
