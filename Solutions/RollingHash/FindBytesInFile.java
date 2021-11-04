import java.util.Arrays;

class FindBytesInFile {


/**
 *  Inefficient solution
 *  Simple substring match
 * 
 */

    public boolean containsBytes(byte[] pattern, byte[] text) {
        //Validate Inputs
        if(pattern == null && text == null) return true;

        if(pattern != null && text == null) return false;

        if(text.length < pattern.length) return false;
        
        // Inefficient solution of checking every substring of pattern length
        for(int start = 0; start < text.length - pattern.length; start++) {
                int shift = 0;
                while(shift < pattern.length && pattern[shift] == text[start + shift]){
                    shift++;
                } 

                if(shift == pattern.length) {
                    return true;
                }

        }

        return false;
    }




    /** 
     * Solution using a given Rolling Hash Function
     * 
     */


    public boolean containsBytesRollingHash(byte[] pattern, byte[] text) {
            
        //Validate Input
        if(pattern == null || text == null) {
            return false;
        }

        if(text.length < pattern.length) {
            return false;
        }

        // Use Hash function on initial bytes of text
        byte[] initialBytes = Arrays.copyOfRange(text, 0, pattern.length);
        RollingHash hashFunc = new RollingHash(initialBytes);

        // Use hash function on pattern
        long patternHash = hashFunc.hash(pattern);

        // Compare hash of pattern to each hash of substring of pattern length
        // Only check individual bytes if hash matches pattern
        for(int start = 0; start < text.length - pattern.length; start++) {
                int shift = 0;
                if(patternHash == hashFunc.currentHashVal) {
                    while(shift < pattern.length && pattern[0] == text[start + shift]) {
                        shift++;
                    }
                }

                // Hash matched and all bytes are matching the pattern
                if(shift == pattern.length) return true;

                // If no match found for this window recompute the hash value for next iteration
                hashFunc.recompute(text[start], text[start + pattern.length]);
        }
            // Pattern not found if entire text is traversed with no match
            return false;
    }


    /**  Skeleton of class that implements RollingHash function */
    class RollingHash {

        public long currentHashVal;

        public RollingHash(byte[] initialBytes) {
            this.currentHashVal = hash(initialBytes);
        }

        // Calculates hash 
        public long hash(byte[] bytes) { return 0;}

        // Recomputes new hash after sliding byte window
        // Updates currentHashVal 
        public void recompute(byte removed, byte incoming) {}



    }

}