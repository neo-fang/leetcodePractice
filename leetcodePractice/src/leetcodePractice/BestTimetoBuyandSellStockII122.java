package leetcodePractice;

public class BestTimetoBuyandSellStockII122 {
	//作者解法
	/**
	 * ###本题的难点在于：
	 *对于 [a, b, c, d]，如果有 a <= b <= c <= d ，那么最大收益为 d - a。
	 *而 d - a = (d - c) + (c - b) + (b - a) ，因此当访问到一个 prices[i]
	 *且 prices[i] - prices[i-1] > 0，那么就把 prices[i] - prices[i-1] 添加到收益中，
	 *从而在局部最优的情况下也保证全局最优。
	 */
	
	public int maxProfit(int[] prices) {
	    int profit = 0;
	    for (int i = 1; i < prices.length; i++) {
	        if (prices[i] > prices[i - 1]) {//连续递增时不需要考虑买入卖出，因为之中情况下一定是连续递增序列的初始时买入，最后时刻卖出；递减不买不卖。
	            profit += (prices[i] - prices[i - 1]);
	        }
	    }
	    return profit;
	}
}
