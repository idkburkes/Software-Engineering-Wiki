package Solutions.LinkedList;
import java.util.Arrays;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 * 
 * Solution Pattern is Merge Sort. I split the length k array into single arrays of 1 LinkedList
 * After splitting the array into arrays of length 1, I recursively merged them back together.
 * The time complexity for this is O(nlogn) <- The same as Merge Sort
 * 
 */
public class MergeKLists {
    
    //Main method is for test cases
    public static void main(String[] args) {
        /**
         * Example 1:
         * Input: lists = [[1,4,5],[1,3,4],[2,6]]
         * Output: [1,1,2,3,4,4,5,6]
         * 
         */
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);

        ListNode[] lists = new ListNode[] { list1, list2, list3};
        ListNode merged = mergeKLists(lists);

        //Traverse LinkedList and print to console
        while(merged != null) {
            System.out.print(merged.val + " ");
            merged = merged.next;
        }
    }


    public static ListNode mergeKLists(ListNode[] lists) {
        //Edge Cases
        if(lists == null || lists.length == 0){
            return null;
        } else if(lists.length == 1) {
            return lists[0];
        } 

        //Split into half
        ListNode[] left;
        ListNode[] right;
        if(lists.length == 2) {
             left = new ListNode[] { lists[0]};
             right = new ListNode[] {lists[1] };
                return mergeLists(left, right)[0];
        } else {
            int mid = (lists.length / 2); 
            left = Arrays.copyOfRange(lists, 0, mid + 1);
            right = Arrays.copyOfRange(lists, mid + 1, lists.length);    
        }

        left[0] = mergeKLists(left); //Recursive call on left
        right[0] = mergeKLists(right); //Recursive call on right
        return mergeLists(left, right)[0]; //Merge left and right lists and return the merged list
    }



    public static ListNode[] mergeLists(ListNode[] left, ListNode[] right) {
        ListNode[] merged = new ListNode[1];
        ListNode currentNode = new ListNode(0);
        ListNode head = currentNode;

        //Retrieve lists at index 1 of both arrays
        ListNode l1 = left[0];
        ListNode l2 = right[0];

        //Merge two lists
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

        //Merge remaining nodes after either list is completely traversed
        while(l1 != null) {
            currentNode.next = l1;
            l1 = l1.next;
            currentNode = currentNode.next;
        }
        while(l2 != null ) {
            currentNode.next = l2;
            l2 = l2.next;
            currentNode = currentNode.next;
        }
        //Place merged lists inside this array
        head = head.next;
        merged[0] = head;
        return merged;
    }


}
