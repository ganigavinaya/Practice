package practice;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ImageCompare {
	static int dfs(char[][] g1,char[][] g2,boolean[][] visited, int i,int j){
		if(i>=0 && i<g1.length && j>=0 && j<g1[0].length && !visited[i][j]){
			if(g1[i][j]==g2[i][j]){
				visited[i][j] = true;
				if(g1[i][j]=='0')
					return 2; //dont explore further
				if(dfs(g1,g2,visited,i,j+1)!=0){
					if(dfs(g1,g2,visited,i,j-1)!=0){
						if(dfs(g1,g2,visited,i-1,j)!=0){
							if(dfs(g1,g2,visited,i+1,j)!=0){
								return 1; //cell & its neighbors are same
							}
						}
					}
				}
			}
			visited[i][j] = false;
			return 0; //grid regions not same
		}
		return 1; //array out of bound or visited cell
	}

	// Complete the countMatches function below.
	static int countMatches(List<String> grid1, List<String> grid2) {
		if(grid1.size()==0 || grid2.size()==0)
			return 0;

		char[][] g1 = new char[grid1.size()][grid1.get(0).length()];
		char[][] g2 = new char[grid2.size()][grid2.get(0).length()];

		int k=0;
		for(String s:grid1){
			char[] cArr = s.toCharArray();
			g1[k++] = Arrays.copyOf(cArr,cArr.length);
		}

		k=0;
		for(String s:grid2){
			char[] cArr = s.toCharArray();
			g2[k++] = Arrays.copyOf(cArr,cArr.length);
		}

		boolean[][] visited = new boolean[g1.length][g1[0].length];
		int res = 0;

		for(int i=0;i<g1.length;i++){
			for(int j=0;j<g1[0].length;j++){
				if(!visited[i][j])
					res = dfs(g1,g2,visited,i,j)==1?res+1:res;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		try {

			int grid1Count = Integer.parseInt(bufferedReader.readLine().trim());

			List<String> grid1 = new ArrayList<>();

			IntStream.range(0, grid1Count).forEach(i -> {
				try {
					grid1.add(bufferedReader.readLine());
				} catch (IOException ex) {
					throw new RuntimeException(ex);
				}
			});

			int grid2Count = Integer.parseInt(bufferedReader.readLine().trim());

			List<String> grid2 = new ArrayList<>();

			IntStream.range(0, grid2Count).forEach(i -> {
				try {
					grid2.add(bufferedReader.readLine());
				} catch (IOException ex) {
					throw new RuntimeException(ex);
				}
			});

			int res = countMatches(grid1, grid2);

			System.out.println(res);
		}
		catch(Exception e){
			System.out.println("exception");
		}
	}
}
