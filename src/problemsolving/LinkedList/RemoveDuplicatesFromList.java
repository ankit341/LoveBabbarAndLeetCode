package problemsolving.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesFromList {

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }


    public ListNode deleteDuplicates(ListNode head) {
        ListNode tempNode = new ListNode(105);
        ListNode currentNode = tempNode;
        ListNode headClone = head;
        Map<Integer, Integer> valuesCount = new HashMap<Integer, Integer>();

        while (head != null) {
            if(valuesCount.containsKey(head.val)) {
                valuesCount.put(head.val, valuesCount.get(head.val) + 1);
            } else {
                valuesCount.put(head.val, 1);
            }
            head = head.next;
        }

        while (headClone != null) {
            if (valuesCount.get(headClone.val) == 1) {
                currentNode.next = headClone;
                currentNode = currentNode.next;
            }
            headClone = headClone.next;
        }

        return tempNode.next;
    }
}
