
/**
 *  Given an input string s, reverse the order of the words.
 * A word is defined as a sequence of non-space characters. The words in s will be
 * separated by at least one space.
 * 
 *  Return a string of the words in reverse order concatenated by a single space.
 * 
 * Note that s may contain leading or trailing spaces or multiple spaces between two
 * words. The returned string should only have a single space separating the words. Do not
 * include any extra spaces.
 * 
 * MAIN STRATEGY - Sliding Window
 * Sliding Window seems to be a common solution pattern for problems dealing with strings
 *      Solution - Reverse entire string
 *               - Use start and end pointers to determine content of current word
 *               - Once identified end of word, reverse that individual word
 *               - Loop i pointer goes through entire string once and doesn't increment start or end if whitespace 
 * 
 */


public class ReverseWordsInAString {
    
public static void main(String[] args) {
    String input = "a good   example";
    System.out.print(reverseString(input));
}

//reverse portion of string
public static char[] reverseChars(char[] arr, int start, int end) {
        while(end >= start){
            char temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    return arr;
}

/**
 * Reverse entire string
 * @param s
 * @return
 */
public static String reverseString(String s) {
if(s == null) {
    return null;
} else if(s.length() == 1) {
    return s;
}

//Convert to char array
char[] arr = s.toCharArray();
String reverse = "";

arr = reverseChars(arr, 0, arr.length - 1); //revese entire string 
int start = 0;
int end = 0;

//use pointers to determine where individual words are
for(int i = 0; i < arr.length; i++) {
if(arr[i] != ' ') { //if current index is a char place it at correct position
arr[end++] = arr[i];
} else { //if whitespace, determine if its the end of word or whitespace we skip
if(i > 0 && arr[i - 1] != ' ') { //at end of word
    //reverse word
    arr = reverseChars(arr, start, end - 1);
    arr[end++] = ' '; //add space after word
    start = end;
}
}


}

//reverse the last word if no white space at end
    if(arr[end - 1] == ' ') {
        reverse = String.valueOf(arr).substring(0, end - 1);
    } else {
        arr = reverseChars(arr, start, end - 1);
        reverse = String.valueOf(arr).substring(0, end);
    }

return reverse;
}


}
