import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

/**
 * 
 * Solution Pattern: Backtracking (DFS with pruning)
 * 
 * Given a string containing digits from 2-9 inclusive, return all possible letter 
 * combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 * 
 */



class LetterCombinationsOfAPhoneNumber {

    List<String> combinations = new ArrayList<>();
    private Map<Character, String> letters = Map.of(
        '2', "abc", '3', "def", '4', "ghi", '5', "jkl", 
        '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");

    public static void main(String[] args) {

        String digits = "23";
        LetterCombinationsOfAPhoneNumber solve = new LetterCombinationsOfAPhoneNumber();
        for(String str : solve.letterCombinations(digits)) {
            System.out.println(str);
        }

    }


        public  List<String> letterCombinations(String digits) {
        
            // Handle case where digits is empty string
            if(digits == null || digits.isEmpty()) {
                return combinations;
            }

           // Init path starting from 0 index
           StringBuilder path = new StringBuilder();
            backtrack(0, digits, path);
            return combinations;
        }



        private void backtrack(int index, String digits, StringBuilder path) {
            
            // Handle backtracking if current letter path is same length as digits entered
            if(path.length() == digits.length()) {
                combinations.add(path.toString());
                return; //Backtrack
            }
            
            // Add all 3 possible chars to current path and recursive call on next index
            for(char c : letters.get(digits.charAt(index)).toCharArray()) {
                path.append(c);

                backtrack(index + 1, digits, path);

            // After reaching end of path backtrack by removing last char from char
            path.deleteCharAt(path.length() - 1);
            }

           
        }

    


    
}