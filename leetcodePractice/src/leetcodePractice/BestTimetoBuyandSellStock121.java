package leetcodePractice;

public class BestTimetoBuyandSellStock121 {
    public static int maxProfit(int[] prices) {
    	if(prices == null||prices.length == 0)  return 0;
    	int minCurrent = prices[0];
        int maxProfit = 0;
        for(int i = 1;i<prices.length;i++) {
        	minCurrent = minCurrent<=prices[i]?minCurrent:prices[i];
        	maxProfit = Math.max(maxProfit, prices[i]-minCurrent);
        }
        return maxProfit;
    }
    
    public static void main(String[] args) {
		int[] prices = {7,6,4,3,1};
		System.out.println(maxProfit(prices));
	}
}
