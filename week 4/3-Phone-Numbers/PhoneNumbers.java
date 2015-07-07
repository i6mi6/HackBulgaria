package week4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneNumbers {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		int[] people = new int[n];
		int[][] graph = new int[n][n];
		Map<Integer,Integer> numbers = new HashMap<Integer, Integer>();
		
		for(int i=0; i<n; i++){
			people[i]=s.nextInt();
			numbers.put(people[i], i);
		}
		
		for(int i=0; i<n; i++){
			int m = s.nextInt();
			for(int j=0; j<m; j++){
				int k=s.nextInt();
				graph[i][numbers.get(k)]=1;
				graph[numbers.get(k)][i]=1;
			}
		}
		s.close();
		boolean[] visited = new boolean[graph.length];
		System.out.println(count(graph, visited));
		
	}
	
	public static int count(int[][] graph, boolean[] visited){
		int count = 0;
		for(int i=0; i<graph.length; i++){
			if(!visited[i]){
				count++;
				DFSVisit(graph, i, visited);
			}
		}
		return count;
	}
	
	public static void DFSVisit(int[][] graph, int u, boolean[] visited){
		visited[u]=true;
		for(int i=0; i<graph[u].length; i++){
			if(graph[u][i]==1&&!visited[i]){
				visited[i]=true;
				DFSVisit(graph,i,visited);
			}
		}
	}
}
