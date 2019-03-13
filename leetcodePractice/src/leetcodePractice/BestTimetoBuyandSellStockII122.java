package leetcodePractice;

public class BestTimetoBuyandSellStockII122 {
	//���߽ⷨ
	/**
	 * ###������ѵ����ڣ�
	 *���� [a, b, c, d]������� a <= b <= c <= d ����ô�������Ϊ d - a��
	 *�� d - a = (d - c) + (c - b) + (b - a) ����˵����ʵ�һ�� prices[i]
	 *�� prices[i] - prices[i-1] > 0����ô�Ͱ� prices[i] - prices[i-1] ��ӵ������У�
	 *�Ӷ��ھֲ����ŵ������Ҳ��֤ȫ�����š�
	 */
	
	public int maxProfit(int[] prices) {
	    int profit = 0;
	    for (int i = 1; i < prices.length; i++) {
	        if (prices[i] > prices[i - 1]) {//��������ʱ����Ҫ����������������Ϊ֮�������һ���������������еĳ�ʼʱ���룬���ʱ���������ݼ���������
	            profit += (prices[i] - prices[i - 1]);
	        }
	    }
	    return profit;
	}
}
