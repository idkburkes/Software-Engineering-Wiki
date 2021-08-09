
/**
 * Given a string s, return the longest palindromic substring in s.
 * 
 * Example 1                          | Example 3 
 * Input: s = "babad"                 | Input: s = "a"
 * Output: "bab"                      | Output: "a"
 * Note: "aba" is also a valid answer.| 
 *                                    |
 * Example 2                          |Example 4
 * Input: s = "cbbd"                  |Input: s = "ac"
 * Output: "bb"                       |Output: "a"
 * 
 * 
 * Solution Pattern: Dynamic Programming 
 * I used a Dynamic Programming approach by using an auxiliary matrix 
 * to store if certain substrings were already determined to be palindromes.
 * All substrings of length 1 are pre-processed in the dp matrix as palindromes.
 * All substrings of length 2 are pre-processed as palindromes if both chars are the same
 * All substrings of length >= 3 are designated as palindromes of the starting and ending chars
 * are the same AND the substrings from index, start + 1 to end -1 has already been evaluated as
 * a palindrome.
 * 
 * 1 = Palindrome, 0 = Not Palindrome
 * Pre-processing matrix for substrings of length 1 as palindromes, involes fill
 * indices (0,0), (1,1), (2,2) .... (9,9) with the value of 1
 * 
 *     0  1  2  3  4  5  6  7  8  9
 *    _____________________________
 *  0|__|__|__|__|__|__|__|__|__|__|
 *  1|__|__|__|__|__|__|__|__|__|__|
 *  2|__|__|__|__|__|__|__|__|__|__|
 *  3|__|__|__|__|__|__|__|__|__|__|
 *  4|__|__|__|__|__|__|__|__|__|__|
 *  5|__|__|__|__|__|__|__|__|__|__|
 *  6|__|__|__|__|__|__|__|__|__|__|
 *  7|__|__|__|__|__|__|__|__|__|__|
 * 
 */


public class LongestPalindromicSubstring {
    
public static void main(String[] args) {

    String input = "ac";
    System.out.print(longestPalindrome(input));

}


public static String longestPalindrome(String s) {
    //Edge cases
    if(s == null || s.isEmpty()) {
        return "";
    } else if (s.length() == 1) {
        return s;
    } else if (s.length() == 2 && s.charAt(0) == s.charAt(1)) {
        return s;
    }

    int[][] dp = new int[s.length()][s.length()];
    String longest = "";
    int max = 0;
    //pre-process dp array for substrings length 1
    for(int i = 0; i < s.length(); i++) {
        dp[i][i] = 1; //Every substring length 1 is a palindrome
        if(1 > max) { //only assign longest substring for first char
            longest = s.substring(i,i + 1); 
            max = 1;
        } 
    }
    //pre-process dp array for substrings length 2
    for(int i = 0; i < s.length() - 1; i++){
        if(s.charAt(i) == s.charAt(i+1)) {
            dp[i][i+1] = 1; //Every substring length 2 is a palindrome if both chars are the same
            if(2 > max) {  //only assign longest for first length 2 palindrome
                longest = s.substring(i, i + 2);
                max = 2;
            }
        }
    }

    //For length >= 3 substrings, it is a palindrome if border chars are the same
    //and the inside substring is also a palindrome
    for(int k = 2; k < s.length(); k++) { //For each length substring
        for(int start = 0; start < s.length() - k; start++) {
            int end = start + k;
            if(s.charAt(start) == s.charAt(end) && dp[start + 1][end - 1] == 1) {
                dp[start][end] = 1;
                if(k + 1 > max){ //only assign longest for first length (K+1) palindrome
                    longest = s.substring(start, end + 1);
                    max = k + 1;
                }
            }
        }
    }

    return longest;
}


}
