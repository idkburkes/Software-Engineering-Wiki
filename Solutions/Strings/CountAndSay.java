

/**
 * 
 * Follow-up question to this <-- What do we do if the input is coming from a stream
 * 
 *  Time/Space complexity?
 * 
 * 
 */

class CountAndSay {

    public String countAndSay(int n) {
        
        // Validate Input
        if(n <= 0) return "";

        // Base Case
        StringBuilder cur = new StringBuilder("1");
        StringBuilder prev;
        int count;
        char say;
        
        // Perform n iterations of algorithm
        for(int i = 1; i < n; i++) {
            prev = cur;
            cur = new StringBuilder();
            count = 1;
            say = prev.charAt(0);
            int length = prev.length();
            // Append values based on previous iteration
            for(int j = 1; j < length; j++) {
                if(prev.charAt(j) != say) {
                    // Found new number. Append count and say to current string
                    cur.append(count);
                    cur.append(say);
                    count = 1;
                    say = prev.charAt(j);
                } else {
                    // Found a repeating number
                    count++;
                }
            }
            cur.append(count);
            cur.append(say);  
        }
        
        return cur.toString();
    }


    
}