package leetcodeGraph;

import java.util.Arrays;

public class RedundantConnection684 {
    public int[] findRedundantConnection(int[][] edges) {
        int m = edges.length;
        //找到顶点数
        int n = 0;
        for(int i=0;i<m;i++) {
        	n = Math.max(n, edges[i][1]);
        }
        int[] root = new int[n+1];
        for(int i=1;i<=n;i++) root[i] = i;//建立n个并查集
        for(int i=0;i<m;i++) {
        	int x = find(root, edges[i][0]);
        	int y = find(root, edges[i][1]);
        	if(x==y) return edges[i];
        	root[y] = x;
        }
        return null;
    }
    public int find(int[] root,int x) {
		if(x!=root[x]) return root[x] = find(root, root[x]);
		return root[x];
	}
    public static void main(String[] args) {
		int[][] edges = {{1,3},{3,4},{1,5},{3,5},{2,3}};
		RedundantConnection684 test = new RedundantConnection684();
		System.out.println(Arrays.toString(test.findRedundantConnection(edges)));
	}
}
