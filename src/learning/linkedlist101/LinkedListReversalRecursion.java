package learning.linkedlist101;

class ListNode {
    int data;
    ListNode next;
}

public class LinkedListReversalRecursion {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}

/**
 * Node reverse(Node head){
 * 	Node currentNode = head;
 * 	Node prevNode = null;
 *
 * 	while(currentNode != null){
 * 		Node nextNode = currentNode.next;
 * 		currentNode.next = prevNode;
 * 		prevNode = currentNode;
 * 		currentNode = nextNode;
 *        }
 * }
 *
 * 1 -> 2 -> 3 -> 4 -> 5
 *
 * 1 -> head = 1 , head.next = 2  , head.next.next= 2, p ->
 * 2 -> head = 1 , head.next = 2  , head.next.next= 2, p ->
 * 3 -> head = 1 , head.next = 2  , head.next.next= 2, p ->
 * 4 -> head = 1 , head.next = 2  , head.next.next= 2, p ->
 * 5 -> head = 5 , head.next = 2  , head.next.next= 2, p -> null
 */