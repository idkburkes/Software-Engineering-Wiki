package Solutions.LinkedList;

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its
 * head.
 * 
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * 
 * Input: head = [1], n = 1
 * Output: []
 * 
 * Input: head = [1,2], n = 1
 * Output: [1]
 * 
 * Solution Strategy is fast and slow pointers
 * 
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //Edges Cases
        if(n == 0 || head == null) {
            return head;
        }
        //Algorithm uses fast&slow pointer method
        ListNode slow = head;
        ListNode fast = head;

        //Start fast pointer with N nodes between slow and fast
        //When fast pointer reaches end, slow pointer will be placed before the node that needs to be skipped
        for(int i = 0; i < n + 1; i++) {
            if(fast != null) { //If deals with if n == length of list.
                fast = fast.next;
            } else { 
                head = head.next; //Remove 1st node
            }   
        }
        //Increment fast&slow together until fast reaches end
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        //Skip Nth node if present
        if(slow.next != null){
             slow.next = slow.next.next;
        }
       
        return head; 
    }
}