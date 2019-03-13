package leetcodeDynamicPrograming;

public class BestTimetoBuyandSellStockwithTransactionFee714 {
	//错误：当prices = {1, 3, 2, 8, 4, 9};fee = 2;时，错误
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int i;
        int j;
        int profit=0;
        for(i=0;i<n;i++) {
        	for(j=i+1;j<n;j++) {
        		if(prices[j]<prices[i]) break;
        	}
        	if(prices[j-1]-prices[i]-fee>0) {
        		profit+=prices[j-1]-prices[i]-fee;
        		i = j;
        	}
        }
        return profit;
    }
    
    //网上解法
    public int maxProfit2(int[] prices, int fee) {
    	int n = prices.length;
    	int[] sold = new int[n];
    	int[] hold = new int[n];
    	hold[0] = -prices[0];//初始化一定不能少，有些时候可以直接使用默认值，若不等于默认值时，一定要初始化
    	for(int i=1;i<n;i++) {
    		sold[i] = Math.max(hold[i-1]+prices[i]-fee, sold[i-1]);
    		hold[i] = Math.max(sold[i-1]-prices[i], hold[i-1]);
    	}
    	return sold[n-1];
    }
    public static void main(String[] args) {
		BestTimetoBuyandSellStockwithTransactionFee714 test = new BestTimetoBuyandSellStockwithTransactionFee714();
		int[] prices = {1, 3, 2, 8, 4, 9};
		int fee = 2;
		System.out.println(test.maxProfit2(prices, fee));
	}
}
