package Solutions.LinkedList;
/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * 
 *  * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * 
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        //Edge cases
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode prev = null; //Prev of first node is null
        
        while(head != null) {
            ListNode nextNode = head.next; //Pointer for next node
            head.next = prev; //Set next of current node to previous node
            prev = head; //Set the value of prev to current node 
            head = nextNode; //Set current node to next node
        }
        
        return prev; //Prev ends at the new start of LinkedList
    }


}