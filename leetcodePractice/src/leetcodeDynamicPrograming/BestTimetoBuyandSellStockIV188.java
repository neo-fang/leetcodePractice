package leetcodeDynamicPrograming;

public class BestTimetoBuyandSellStockIV188 {
    public int maxProfit(int k, int[] prices) {
    	//当天买当天卖是允许的
    	int n = prices.length;
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
    //空间优化
    public int maxProfit2(int k, int[] prices) {
    	//当天买当天卖是允许的
    	int n = prices.length;
    	//当k>=n时，k就没有意义了，该题退化为求最大收益，没有买卖次数限制
    	if(k>=n) {
    		int profit = 0;
    		for(int i=1;i<n;i++) {
    			int diff = prices[i] - prices[i-1];
    			if(diff>0) {
    				profit+=diff;
    			}
    		}
    		return profit;
    	}
    	//k<n
        int[] local =new int[k+1] ;
        int[] global = new int[k+1];
        for(int i=1;i<n;i++) {
        	int diff = prices[i] - prices[i-1];
        	for(int j=k;j>0;j--) {		
        		local[j] = Math.max(local[j] + diff,global[j-1]+Math.max(0, diff));
        		global[j] = Math.max(local[j],global[j]);
        	}
        }
        return global[k];
    }
    
    public static void main(String[] args) {
    	BestTimetoBuyandSellStockIV188 test = new BestTimetoBuyandSellStockIV188();
		int[] prices = {2,4,1,3,5,2};
		System.out.println(test.maxProfit2(6, prices));
	}
 }

