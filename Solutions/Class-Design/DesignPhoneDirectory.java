import java.util.Queue;
import java.util.Set;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.BitSet;


/** 
 * 
 * https://leetcode.com/problems/design-phone-directory/submissions/
 * 
 * Considerations - ask these questions up front
 * 
 *  Do we need the directory to allocate numbers in a specific order? or is randomly allocated fine? 
 * 
 * 
 */

public class DesignPhoneDirectory {

 /** Queue and Set implementation (easy)
        This is bad for space considerations
        Space complexity is O(N) because we pre-populate a Queue with n integers
        Time complexity is O(1) in allocate and release */

     class PhoneDirectory {

        private Queue<Integer> availableNums;
        private Set<Integer> allocated;
        private final int MAX_NUM;
        
        public PhoneDirectory(int maxNumbers) {
            MAX_NUM = maxNumbers;
             allocated = new HashSet<>();
            
            // Pre-process available numbers
            this.availableNums = new LinkedList<>();
            for(int i = 0; i < maxNumbers; i++) {
                availableNums.offer(i);
            }
              
        }
        
        public int get() {
            // No number is available
            if(availableNums.isEmpty()) return -1;
            
            //Allocate the new phone number
            int newNum = availableNums.poll();
            allocated.add(newNum);
            
            return newNum;
            
        }
        
        // Returns true if number is available and false otherwise
        public boolean check(int number) {
            return !allocated.contains(number);
        }
        
        public void release(int number) {
            // Validate input
            if(number < 0 || number >= MAX_NUM 
               || !allocated.contains(number)) return;
            
            allocated.remove(number);
            availableNums.offer(number);
            
        }
    }


    /**   Single Set Implementation
     * 
     * Here's an exmaple of the space heavy solution but with only one set
     * We can use this if we don't need to worry about having the allocated numbers in order
     * 
     */
    class PhoneDirectory2 {

        private Set<Integer> available;
        private final int MAX_NUM;

        public PhoneDirectory2(int maxNumber) {
            MAX_NUM = maxNumber;
            this.available = new HashSet<>();

            // Pre-populate Set with all available numbers within range
            for(int i = 0; i < maxNumber; i++) {
                available.add(i);
            }


        }

        public int get() {
            // No numbers availalbe
            if(available.isEmpty()) return -1;

            // Allocate new number 
            int newNum = available.iterator().next();
            available.remove(newNum);

            return newNum;
        }

        // Return true if number is available
        public boolean check(int number) {
            return available.contains(number);
        }

        public void release(int number) {
            //Validate input
            if(number < 0 || number >= MAX_NUM 
                || available.contains(number)) return;

            available.add(number);
        }
    }

    /** 
     * BitSet approach
     * 
     * Space Complexity O(n) <- I'd say the asymptotic space complexity is still technically O(n)
     *      but storing n bit flags is much more space efficient than storing n integers in a Set/Queue
     * 
     * Worst Case Time Complexity O(n) 
     *      Happens if we have to linear search entire BitSet or boolean[] for next available id
     */
    class PhoneDirectory3 {

        private BitSet bitSet;
        private int nextAvailable;
        private final int MAX_NUM;

        public PhoneDirectory3(int maxNumbers) {
            this.bitSet = new BitSet(maxNumbers);
            this.MAX_NUM = maxNumbers;
            this.nextAvailable = 0;

        }
        
        public int get() {
            if(nextAvailable == MAX_NUM) return -1;

            // Allocate phone number
            int newNum = nextAvailable;
            bitSet.set(newNum);

            // Set next number that will be allocated
            nextAvailable = bitSet.nextClearBit(newNum);
            return newNum;
        }
        
        // Returns true if bit flag is 0 i.e. number is available
        public boolean check(int number) {
            //Validate Input
            if(number < 0 || number >= MAX_NUM) return false;

            return !bitSet.get(number);
        }
        
        public void release(int number) {
            
            // Input validation
            if(number < 0 || number >= MAX_NUM) return;

            if(bitSet.get(number)) {
                bitSet.clear(number);
                nextAvailable = Math.min(number, nextAvailable);
            }

        }
    }

}