package week4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BuildScripts {
	public static int[][] graph;
	public static Map<Integer, String> map;
	public static void main(String[] args) {
		map = new HashMap<Integer, String>();
		Map<String, Integer> map1 = new HashMap<String, Integer>();
		
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		graph= new int[N][N];
		
		for(int i=0; i<N; i++){
			String proj = s.next();
			map.put(i, proj);
			map1.put(proj, i);
		}
		
		int index = map1.get(s.next());
		
		for(int i=0; i<N; i++){
			int M = s.nextInt();
			for(int j=0; j<M;j++){
				graph[i][map1.get(s.next())]=1;
			}
		}
		
		s.close();
		
		DFSVisit(index,0);
	}
	
	public static int DFSVisit(int u, int path){
		if(map.containsKey(u)){
			if(path==map.size()-1){
				System.out.print(map.get(u)+" ");
				return u;
			}
			for(int i=0; i<graph[u].length; i++){
				if(graph[u][i]==1){
					if(DFSVisit(i,path+1)!=-1){
						System.out.print(map.get(u)+" ");
						return u;
					}
				}
			}
		}
		return -1;
	}
}
