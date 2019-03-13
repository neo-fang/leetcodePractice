package leetcodeDynamicPrograming;

public class WiggleSubsequence376 {
	//��Ʊ�ⷨ1��https://leetcode.com/problems/wiggle-subsequence/solution/
	//���ͣ�up[i]��ʾ��iԪ��Ϊ����������Ϊ���һ��Ԫ�ص���ڶ����г���,ͬ��down[i]���һ��Ԫ��Ϊ�½��ص������
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int[] up = new int[nums.length];
        int[] down = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {//��ǰԪ�ش���nums[j]ʱ�����Ե�ǰԪ��Ϊ�����ص�����г���Ϊ��Ԫ��jΪ�½��صĳ��ȼ�1
                    up[i] = Math.max(up[i],down[j] + 1);
                } else if (nums[i] < nums[j]) {//ͬ�����ʱ���ֲ���
                    down[i] = Math.max(down[i],up[j] + 1);
                }
            }
        }
        return 1 + Math.max(down[nums.length - 1], up[nums.length - 1]);
    }
    //��Ʊ�ⷨ2
    public int wiggleMaxLength2(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int[] up = new int[nums.length];
        int[] down = new int[nums.length];
        up[0] = down[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up[i] = down[i - 1] + 1;
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                down[i] = up[i - 1] + 1;
                up[i] = up[i - 1];
            } else {
                down[i] = down[i - 1];
                up[i] = up[i - 1];
            }
        }
        return Math.max(down[nums.length - 1], up[nums.length - 1]);
    }
}
