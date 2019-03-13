package leetcodePractice;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses93 {
	public static boolean ipValid(String s) {//�ж��ַ����Ƿ�����Ч�ַ���	
		if(s.length()>3||s.isEmpty()||(s.length()>1&&s.charAt(0)=='0')) return false;
		int num = Integer.parseInt(s);
		return num>=0&&num<=255;
	}
	//�ҵĽⷨ
    public static List<String> restoreIpAddresses(String s) {
        List<String> ipCombination = new ArrayList<>();
        if(s == null||s.length()<4) return ipCombination;
        for(int i=1;i<4&&i<s.length();i++) {
        	if(!ipValid(s.substring(0, i))) continue;
        	for(int j=i+1;j<i+4&&j<s.length();j++) {
        		if(!ipValid(s.substring(i, j))) continue;
        		for(int k=j+1;k<j+4&&k<s.length();k++) {
        			if(!ipValid(s.substring(j,k))) continue;
        			if(ipValid(s.substring(k))) {
        				ipCombination.add(s.substring(0,i)+"."+s.substring(i, j)+"."
        						+s.substring(j, k)+"."+s.substring(k));
        			}
        		}
        	}
        }
        return ipCombination;
    }
    //���߽ⷨ
    public static List<String> restoreIpAddresses2(String s) {
        List<String> addresses = new ArrayList<>();
        StringBuilder tempAddress = new StringBuilder();
        doRestore(0, tempAddress, addresses, s);
        return addresses;
    }

    private static void doRestore(int k, StringBuilder tempAddress, List<String> addresses, String s) {
        if (k == 4 || s.length() == 0) {
            if (k == 4 && s.length() == 0) {
                addresses.add(tempAddress.toString());
            }
            return;
        }
        for (int i = 0; i < s.length() && i <= 2; i++) {
            if (i != 0 && s.charAt(0) == '0') {
                break;
            }
            String part = s.substring(0, i + 1);
            if (Integer.valueOf(part) <= 255) {
                if (tempAddress.length() != 0) {
                    part = "." + part;
                }
                tempAddress.append(part);
                doRestore(k + 1, tempAddress, addresses, s.substring(i + 1));
                //ÿ��ݹ�ִ����Ϻ����ò㻹���������û�г��ԣ���Ҫ���Ѿ����Թ��ĸò�Ľ������󣨷���Ҫ������ʱ��ɾ����
                //�ٳ�������������������ֱ���ݹ�����������ӳ����ڷ��ؽ���У������Ǹò����н����ֻ��һ��������
                //����У����´�����һ�������ݻء�
                tempAddress.delete(tempAddress.length() - part.length(), tempAddress.length());

            }
        }
    }
    public static void main(String[] args) {
		String s = "25525511135";
		System.out.println(restoreIpAddresses2(s));
	}
}
