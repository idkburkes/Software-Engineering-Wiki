import java.util.Queue;
import java.util.LinkedList;
import java.util.Deque;

class HitCounter {

    private Queue<Integer> hits;
    
    
    public HitCounter() {
        this.hits = new LinkedList<>();
    }
    
    public void hit(int timestamp) {
        // Store all timestamps in Queue for First-in-First-out structure
        this.hits.offer(timestamp);
    }
    
    public int getHits(int timestamp) {
        
       
        while(!hits.isEmpty()) {
            // Check time that has elapsed since oldest hit
             int diff = timestamp - hits.peek();
            if(diff >= 300) {
                // Continue to remove old timestamps until we reach first hit within the last 300 seconds
                hits.remove();
            } else break;
        }
     
        // The amount of valid hits will correspond to size of Queue
        return hits.size();
        
    }

}


/**
 * 
 *  Optimization for receiving hits with the same timestamp is storing each hit with
 *  the amount of matching timestamps. We must use a deque so we can increment count for
 *  new hits at end but we can also remove hits from the front that are timed-out.
 * 
 *  When we remove timed out hits it's important to remember that we have to decrement the
 *  total variable by the amount of times that this timestamp was present. 
 * 
 */
class HitCounterPairs {

    private int total;
    // Deque stores pairs of [timestamp, count]
    private Deque<int[]> hits;


    public HitCounterPairs() {
        this.hits = new LinkedList<int[]>();
        this.total = 0;
    }
    
    public void hit(int timestamp) {
        
        if(hits.size() == 0 || hits.getLast()[0] != timestamp) {
            // Add new timestamp
            hits.add(new int[] { timestamp, 1});

        } else {
            // Increment hit for existing timestamp
            int newCount = hits.getLast()[1];
            hits.removeLast();
            hits.add(new int[] {timestamp, newCount + 1});
            total++;
        }
        
    }
    
    public int getHits(int timestamp) {
        
        if(hits.size() == 0) return 0;

        // Remove all timestamps from front of deque that are timed-out
        while(!hits.isEmpty()) {
            int diff = timestamp - hits.getFirst()[0];

            // Time difference greater than 300 means hit is timed out
            if(diff >= 300) {
                int hitCount = hits.getFirst()[1];
                hits.removeFirst();
                total -= hitCount;

            } else break; // Finding hit within time range means all remaining hits in deque are valid
        }

        return total;
    }



}