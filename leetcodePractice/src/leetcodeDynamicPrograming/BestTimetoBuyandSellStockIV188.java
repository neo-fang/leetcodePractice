package leetcodeDynamicPrograming;

public class BestTimetoBuyandSellStockIV188 {
    public int maxProfit(int k, int[] prices) {
    	//�����������������
    	int n = prices.length;
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
    //�ռ��Ż�
    public int maxProfit2(int k, int[] prices) {
    	//�����������������
    	int n = prices.length;
    	//��k>=nʱ��k��û�������ˣ������˻�Ϊ��������棬û��������������
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

