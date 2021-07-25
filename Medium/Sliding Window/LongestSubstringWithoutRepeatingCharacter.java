import java.util.HashSet;

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