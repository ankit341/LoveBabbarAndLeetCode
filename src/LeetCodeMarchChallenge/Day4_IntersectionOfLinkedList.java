package LeetCodeMarchChallenge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day4_IntersectionOfLinkedList {
      public class ListNode {
          int val;
          ListNode next;
           ListNode(int x) {
             val = x;
             next = null;
         }
     }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> listOfElementAlreadyVisited = new HashSet<>();

        while (headA != null) {
            listOfElementAlreadyVisited.add(headA);
            headA = headA.next;
        }

        while (headB != null)
        {
            if (listOfElementAlreadyVisited.contains(headB))
                return headB;
            headB = headB.next;
        }

        return null;
    }

    public ListNode getIntersectionsUsingConstantSpace(ListNode headA, ListNode headB) {
          int lengthOfListA = 0;
          int lengthOfListB = 0;
          ListNode headAClone = headA;
          ListNode headBClone = headB;

          while (headA != null) {
              lengthOfListA++;
              headA = headA.next;
          }

          while (headB != null) {
              lengthOfListB++;
              headB = headB.next;
          }

          int differenceOfLength = Math.abs(lengthOfListA - lengthOfListB);

          ListNode longerList = lengthOfListA > lengthOfListB ? headAClone : headBClone;
          ListNode shorterList = lengthOfListB > lengthOfListA ? headAClone : headBClone;

          while (differenceOfLength > 0) {
              longerList = longerList.next;
              differenceOfLength--;
          }

          while (longerList != null) {
              if (longerList == shorterList)
                  return longerList;
              longerList = longerList.next;
              shorterList = shorterList.next;
          }

          return null;
    }

    public static ListNode getIntersectionOfLinkedList(ListNode headA, ListNode headB) {
          ListNode p1 = headA;
          ListNode p2 = headB;

          while (p1 != p2) {
              p1 = p1 == null ? headB : p1.next;
              p2 = p2 == null ? headA : p2.next;

          }
          return p1;
    }
}
