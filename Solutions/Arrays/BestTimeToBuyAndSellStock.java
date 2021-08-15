package Solutions.Arrays;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith
 * day.
 * 
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a
 * different day in the future to sell that stock.
 * 
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any
 * profit, return 0.
 * 
 * Used Sliding window solution pattern. 
 * 
 * 
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        //Base cases
         if(prices == null || prices.length < 2){
             return 0;
         }
         int maxProfit = 0;
         int left = 0; //Left pointer stays at current smallest value we've found
         for(int right = 0; right < prices.length; right++){
             //if right pointer is less than left pointer update that to new left pointer
             //we can't find a bigger profit any further if we don't update left pointer
             if(prices[right] < prices[left]) left = right;
             //Update if difference of right minus left is max so far
             maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
         }        
         return maxProfit;
     }
}
