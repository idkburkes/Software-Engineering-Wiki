
/**
 * Given a string s, return the longest palindromic substring in s.
 * 
 * 
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
