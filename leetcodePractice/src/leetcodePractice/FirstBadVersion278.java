package leetcodePractice;

public class FirstBadVersion278 {
	public int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        int m = (l+r)/2;
        while(l<r) {
        	if(isBadVersion(m)) {
        		r = m;
        	}else {
        		l = m + 1;
        	}
        	m = (l+r)/2;
        }
        return l;
    }
	
	/*
	public int firstBadVersion(int n) {
    int l = 1, h = n;
    while (l < h) {
        int mid = l + (h - l) / 2;
        if (isBadVersion(mid)) {
            h = mid;
        } else {
            l = mid + 1;
        }
    }
    return l;
}
	 * */
	boolean isBadVersion(int version) {
		return version>=3;
	}
}
