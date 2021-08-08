

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class SortList {

    
    public static void main(String[] args) {
        // [-1,5,3,4,0]
        ListNode head = new ListNode(-1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);

        ListNode sorted = sortList(head);
        while(sorted != null) {
            System.out.print(sorted.val + " ");
            sorted = sorted.next;
        }

    }

     //Split LinkedList in half by using 2 pointer technique
    public static ListNode sortList(ListNode head) {
        //Edge cases
        if(head == null || head.next == null) { //Single value or null
            return head;
        }
        
        //Left half will be from head to slow, right half will be from slow + 1 to fast
        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = head;
       
        //Increment slow pointer by 1, fast pointer by 2. When fast pointer is at end slow pointer is at mid point
        while(fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        //Split into 2 separate lists
        temp.next = null;
        
     //Recursive calls on both halves
     ListNode left = sortList(head);
     ListNode right = sortList(slow);

     //Merge two halves 
     return merge(left, right);
    }


    public static ListNode merge(ListNode L1, ListNode L2) {
        ListNode sorted = new ListNode(0);
        ListNode currentNode = sorted;
        
        //Merge into sorted order
        while(L1 != null && L2 != null) {
            if(L1.val < L2.val) {
                currentNode.next = L1;
                currentNode = currentNode.next;
                L1 = L1.next;
            } else {
                currentNode.next = L2;
                currentNode = currentNode.next;
                L2 = L2.next;
            }
        }
        //Finish L1 LinkedList if not all values added to sorted
        while(L1 != null) {
            currentNode.next = L1;
            L1 = L1.next;
            currentNode = currentNode.next;
        }
        //Finish L2 LinkedList if not all values added to sorted
        while(L2 != null) {
            currentNode.next = L2;
            L2 = L2.next;
            currentNode = currentNode.next;
        }

        return sorted.next;
    }


}