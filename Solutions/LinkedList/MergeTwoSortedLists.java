package Solutions.LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * 
 * 
 * Merge two sorted linked lists and return it as a sorted list. The list should be made by
 * splicing together the nodes of the first two lists.
 * 
 */
public class MergeTwoSortedLists {
    

    /**
     * This is essentially the merge operation from Merge Sort performed on a LinkedList.
     * Pretty easy stuff
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode currentNode = new ListNode(0);
        ListNode head = currentNode;
        
        //Insert nodes until reach the end of one list
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                currentNode.next = l1;
                l1 = l1.next;
                currentNode = currentNode.next;
            } else {
                currentNode.next = l2;
                l2 = l2.next;
                currentNode = currentNode.next;
            }
        }
        
        //Insert remaining nodes in list not finished traversing
        while(l1 != null) {
            currentNode.next = l1;
            l1 = l1.next;
            currentNode = currentNode.next;
        }
        
         while(l2 != null) {
            currentNode.next = l2;
            l2 = l2.next;
            currentNode = currentNode.next;
        }
        
        return head.next;
    }

}
