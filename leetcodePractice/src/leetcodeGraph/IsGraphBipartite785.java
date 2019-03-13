package leetcodeGraph;

public class IsGraphBipartite785 {
	//�ҵĽⷨ1��DFSȾɫ�������ο����Ͻⷨ�����߽ⷨ��ֱ�ӴӶ���0��ʼ��DFS�ķ���Ⱦɫ
	//Ϊʲô��һ��ʼֱ�Ӷ������DFSȾɫ�أ���Ϊ�����Ƿ���ͨͼ���������ж��ͼ��DFS
	//�޷�����
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];//���ж�����ɫ��ʼ��Ϊ0����ʾδȾɫ
         for(int i=0;i<n;i++) {
        	//δ��Ⱦɫʱ������DFS�������Ⱦɫʧ��
        	 if(colors[i]==0&&!dfsDye(graph, 1, i, colors)) {
        		 return false;
        	 }
         }
         return true;
    }
    public boolean dfsDye(int[][] graph,int color,int vertex,int[] colors) {
    	//�ö�����ɫ�뼴��ҪȾ����ɫ��ͬʱ����
    	if(colors[vertex]!=0) return colors[vertex] == color;
    	colors[vertex] = color;
    	for(int otherVertex:graph[vertex]) {//�ݹ鿼��ýڵ������ڵ��Ƿ����
    		if(!dfsDye(graph, -1*color, otherVertex, colors)) return false;
    	}
    	return true;
    }
    
    //�ҵĽⷨ2�����鼯�������ο����Ͻⷨ
    public boolean isBipartite2(int[][] graph) {
    	int n = graph.length;
    	int[] root  = new int[n];
    	for(int i=0;i<n;i++) root[i] = i;//����root���飬��ʼ��ÿ���ڵ��ڶ������鼯�У��Լ���root���Լ�
    	for(int i=0;i<n;i++) {
    		if(graph[i].length==0) continue;//�ýڵ�Ϊ�����ڵ�
    		int x = find(i, root);
    		int y = find(graph[i][0], root);
    		if(x==y) return false;
    		//��i���ھӽڵ���ѡ��һ����Ϊ�ھӽڵ�ĸ����ϲ��ھӽڵ�Ϊһ�����鼯
    		for(int j=1;j<graph[i].length;j++) {
    			int curRoot = find(graph[i][j], root);
    			if(curRoot == x) return false;
    			root[curRoot] = y;//�����ھӽڵ����в��鼯��ӵ���yΪ����ڵ�Ĳ��鼯��
    		}
    	}
    	return true;
    }
  //���鼯�е�find���������ҹ����н�·�������еĽڵ�ֱ�����ӵ�ͷ�ڵ��ϣ����Ͳ���ʱ��
    public int find(int x,int[] root) {
    	if(x!=root[x]) return root[x] = find(root[x], root); 
		return root[x];
	}
}



