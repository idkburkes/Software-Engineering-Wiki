import java.util.HashSet;



/**
 * 
 * Solution pattern is called "Sliding Window"
 * Increment two pointers as we search for the longest substring
 * Since values have to be unique, it is useful to use a HashSet.
 * Whenever second pointer finds a new value we add it to the set.
 * If second pointer finds duplicate, we remove it from the set and increment the first pointer
 * The substring between the first pointer and second pointer is the new max substring
 * Since we're adding and removing values from the set, the size of the set is used to determine the
 * maximum length of any substring that we've found
 * Once the second pointer reaches the end of the string we've searched all possible max-length substrings. 
 * 
 * 
 * This solution pattern is very simple and can probably translate to solving many different problems.
 * 
 */
class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {

        System.out.print(lengthOfLongestSubstring("pwwkew"));

    }

    
    public static int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        HashSet<Character> set = new HashSet();
        int max = 0;
        while(j < s.length()) {
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }
}