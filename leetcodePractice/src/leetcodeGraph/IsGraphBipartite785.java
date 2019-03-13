package leetcodeGraph;

public class IsGraphBipartite785 {
	//我的解法1（DFS染色法）：参考网上解法和作者解法，直接从顶点0开始用DFS的方法染色
	//为什么不一开始直接对其进行DFS染色呢，因为可能是非联通图，即可能有多个图，DFS
	//无法处理
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];//所有顶点颜色初始化为0，表示未染色
         for(int i=0;i<n;i++) {
        	//未被染色时，调用DFS对其进行染色失败
        	 if(colors[i]==0&&!dfsDye(graph, 1, i, colors)) {
        		 return false;
        	 }
         }
         return true;
    }
    public boolean dfsDye(int[][] graph,int color,int vertex,int[] colors) {
    	//该顶点颜色与即将要染的颜色相同时合理
    	if(colors[vertex]!=0) return colors[vertex] == color;
    	colors[vertex] = color;
    	for(int otherVertex:graph[vertex]) {//递归考察该节点其他节点是否合理
    		if(!dfsDye(graph, -1*color, otherVertex, colors)) return false;
    	}
    	return true;
    }
    
    //我的解法2（并查集法）：参考网上解法
    public boolean isBipartite2(int[][] graph) {
    	int n = graph.length;
    	int[] root  = new int[n];
    	for(int i=0;i<n;i++) root[i] = i;//建立root数组，初始化每个节点在独立并查集中，自己的root是自己
    	for(int i=0;i<n;i++) {
    		if(graph[i].length==0) continue;//该节点为孤立节点
    		int x = find(i, root);
    		int y = find(graph[i][0], root);
    		if(x==y) return false;
    		//从i的邻居节点中选择一个作为邻居节点的根，合并邻居节点为一个并查集
    		for(int j=1;j<graph[i].length;j++) {
    			int curRoot = find(graph[i][j], root);
    			if(curRoot == x) return false;
    			root[curRoot] = y;//将该邻居节点所有并查集添加到以y为代表节点的并查集上
    		}
    	}
    	return true;
    }
  //并查集中的find方法，查找过程中将路径中所有的节点直接连接到头节点上，降低查找时间
    public int find(int x,int[] root) {
    	if(x!=root[x]) return root[x] = find(root[x], root); 
		return root[x];
	}
}



