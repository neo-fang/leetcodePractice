package leetcodePractice;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses93 {
	public static boolean ipValid(String s) {//判断字符串是否是有效字符串	
		if(s.length()>3||s.isEmpty()||(s.length()>1&&s.charAt(0)=='0')) return false;
		int num = Integer.parseInt(s);
		return num>=0&&num<=255;
	}
	//我的解法
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
    //作者解法
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
                //每层递归执行完毕后，若该层还有其他结果没有尝试，需要将已经尝试过的该层的结果保存后（符合要求条件时）删除，
                //再尝试其他结果，否则会出现本层递归多个结果的连接出现在返回结果中，而不是该层所有结果中只有一个出现在
                //结果中，导致错误，这一步就是溯回。
                tempAddress.delete(tempAddress.length() - part.length(), tempAddress.length());

            }
        }
    }
    public static void main(String[] args) {
		String s = "25525511135";
		System.out.println(restoreIpAddresses2(s));
	}
}
