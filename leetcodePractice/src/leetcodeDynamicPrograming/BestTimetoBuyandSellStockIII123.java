package leetcodeDynamicPrograming;

public class BestTimetoBuyandSellStockIII123 {
	//�����������������
    public int maxProfit(int[] prices) {
    	int n = prices.length;
    	int k = 2;
        int[][] local =new int[n+1][k+1] ;
        int[][] global = new int[n+1][k+1];
        for(int i=1;i<n;i++) {
        	int diff = prices[i] - prices[i-1];
        	for(int j=1;j<=k;j++) {		
        		//ȡlocal��i-1��j�ν��ף�Ȼ����Ͻ���Ĳ�ֵ��������Ϊlocal[i-1][j]���������i-1��
        		//�����Ľ��ף��������ڱ�ɵ�i�����������������ӽ��״�����
        		//global[i-1][j-1]+Math.max(0, diff)Ϊʲô����ֱ�Ӽ���diff����Ϊ��������������
        		//��Ϊglobal[i-1][j-1]��ʾi-1��������棬���i-1�첻���������룬�϶�����������������
        		//��diff����0����i-1�����루�������벻����global[i-1][j-1]����������һ�Σ���i������
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
