package leetcodeDynamicPrograming;

public class BestTimetoBuyandSellStockIII123 {
	//当天买当天卖是允许的
    public int maxProfit(int[] prices) {
    	int n = prices.length;
    	int k = 2;
        int[][] local =new int[n+1][k+1] ;
        int[][] global = new int[n+1][k+1];
        for(int i=1;i<n;i++) {
        	int diff = prices[i] - prices[i-1];
        	for(int j=1;j<=k;j++) {		
        		//取local第i-1天j次交易，然后加上今天的差值（这里因为local[i-1][j]比如包含第i-1天
        		//卖出的交易，所以现在变成第i天卖出，并不会增加交易次数；
        		//global[i-1][j-1]+Math.max(0, diff)为什么不是直接加上diff，因为允许当天买当天卖，
        		//因为global[i-1][j-1]表示i-1天最大收益，因此i-1天不可能是买入，肯定是卖出或者无买卖
        		//若diff大于0，则i-1天买入（本次买入不算在global[i-1][j-1]，而算在下一次），i天卖出
        		local[i][j] = Math.max(local[i-1][j] + diff,global[i-1][j-1]+Math.max(0, diff));
        		global[i][j] = Math.max(local[i][j],global[i-1][j]);
        	}
        }
        return global[n-1][k];
    }
    
    public static void main(String[] args) {
    	BestTimetoBuyandSellStockIII123 test = new BestTimetoBuyandSellStockIII123(); 
    	int[] prices = {3,3,5,0,0,3,1,4};
    	System.out.println(test.maxProfit(prices));
	}
}
