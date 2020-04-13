package practice;

import java.util.Arrays;

public class FriendCircles {

	int[] parent;
	int find(int x) {
		if(parent[x]==-1)
			return x;
		return find(parent[x]);
	}
	void union(int i,int j) {
		int parentI = find(i);
		int parentJ = find(j);
		if(parentI!=parentJ)
			parent[parentJ]=parentI;
	}
	
	public int findCircleNum(int[][] M) {
		parent = new int[M.length];
		Arrays.fill(parent, -1);
				
		for(int i=0;i<M.length;i++) {
			for(int j=i+1;j<M[0].length;j++) {
				if(M[i][j]==1) {
					union(i,j);
				}
			}
		}
		
		int count = 0;
		for(int x:parent) {
			if(x==-1)
				count++;
		}
		
        return count;
    }

	public static void main(String[] args) {
		FriendCircles fc = new FriendCircles();
		fc.findCircleNum(new int[][] {{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1}});
	}

}
