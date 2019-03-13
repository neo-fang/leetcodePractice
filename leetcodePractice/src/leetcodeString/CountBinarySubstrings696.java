package leetcodeString;

public class CountBinarySubstrings696 {
	//�ҵĽⷨ�����ڴ����ظ������������������ȵļ����ظ������ж���ÿ��Ԫ��Ϊ��ͷ���Ӵ��Ƿ��������
    public int countBinarySubstrings(String s) {
    	int cnt = 0;
        for(int i=0;i<s.length();i++) {
        	if(validNum(s, i)) cnt++;
        }
        return cnt;
    }
    public boolean validNum(String s,int left) {
    	int n = s.length();
    	int right = left+1;
    	while(right<n&&s.charAt(right)==s.charAt(right-1)) right++;
    	int len = right - left;
    	int i=0;
    	for(;right<n&&i<len;i++,right++) {
    		if(s.charAt(right)==s.charAt(left)) return false;
    	}
    	return i==len;
	}
    
    public static void main(String[] args) {
		String s = "10101";
		CountBinarySubstrings696 test = new CountBinarySubstrings696();
		System.out.println(test.countBinarySubstrings(s));
	}
}
