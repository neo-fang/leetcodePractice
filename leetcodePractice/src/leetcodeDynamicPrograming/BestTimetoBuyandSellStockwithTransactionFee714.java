package leetcodeDynamicPrograming;

public class BestTimetoBuyandSellStockwithTransactionFee714 {
	//���󣺵�prices = {1, 3, 2, 8, 4, 9};fee = 2;ʱ������
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
    
    //���Ͻⷨ
    public int maxProfit2(int[] prices, int fee) {
    	int n = prices.length;
    	int[] sold = new int[n];
    	int[] hold = new int[n];
    	hold[0] = -prices[0];//��ʼ��һ�������٣���Щʱ�����ֱ��ʹ��Ĭ��ֵ����������Ĭ��ֵʱ��һ��Ҫ��ʼ��
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
