package Solutions.LinkedList;

/**
 * You are given the head of a singly linked-list. The list can be represented as:
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 * 
 * 
 * Solution Strategy used fast & slow pointers. I drew out what the algorithm would look like
 * in the comments below. I used fast,slow,prev,next pointers to rearrange the list in an iterative
 * pattern. The solution was pretty slow but I'm glad I solved this reasonably quick with no outside help.
 * 
 */
public class ReorderList {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        reorderList(head);
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }


/*
s n     p f
1 2 3 4 5 6

s f n     p
1 6 2 3 4 5

    f
  p s n
1 6 2 3 4 5

    s n p f
1 6 2 3 4 5

    s f n p
1 6 2 5 3 4

        s n
1 6 2 5 3 4
*/
    public static void reorderList(ListNode head) {
      
        //Each iteration starts fast&slow at same spot. 
        //prev 1 node before them and next 1 node after them
        ListNode prev = new ListNode();
        ListNode slow = head;
        ListNode next = slow.next;
        ListNode fast = head;
        prev.next = fast;
        
        while(next != null && next.next != null) {
            while(fast.next != null) { //Fast reaches end of list 
                fast = fast.next;
                prev = prev.next;
            }
            //Place (n - i)th after ith node 
            slow.next = fast;
            fast.next = next;
            prev.next = null;
            
            //Set pointers for next iteration
            prev = fast;
            slow = next;
            fast = next;
            next = slow.next;   
        }
          
    }
}