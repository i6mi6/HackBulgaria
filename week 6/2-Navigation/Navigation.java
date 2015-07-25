package week6;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Navigation {
	public static final int inf = (int)Double.POSITIVE_INFINITY;
	public static int[][] graph;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int s = sc.nextInt()-1;
		int c = sc.nextInt()-1;
		graph = new int[n][n];
		
		for(int k=0; k<m; k++){
			int i = sc.nextInt()-1;
			int j = sc.nextInt()-1;
			graph[i][j]=sc.nextInt();
			graph[j][i]=graph[i][j];
		}
		Dijkstra(s, c);


	}
	
	public static void Dijkstra(int start, int end){
		int[] parent = new int[graph.length];
		int[] distance = new int[graph.length];
		Queue<Vertex> q = new PriorityQueue<Vertex>();
		boolean[] visited = new boolean[graph.length];
		for(int i = 0 ; i<distance.length; i++){
			distance[i]=inf;
		}
		
		q.add(new Vertex(start, 0));
		distance[start]=0;
		visited[start]=true;

		int current;
		
		while(!q.isEmpty()){
			current=q.poll().id;
			q.clear();
			visited[current]=true;
			
			for(int i=0; i<graph[current].length; i++){
				if(!visited[i]){
					if(graph[current][i]>0&&!visited[i]&&distance[i]>distance[current]+graph[current][i]){
						distance[i]=distance[current]+graph[current][i];					
						parent[i]=current;
					}
					q.add(new Vertex(i, distance[i]));
				}
				
			}
			
			
		}
		int n = parent.length;
		List<Integer> junctions = new ArrayList<Integer>();
		junctions.add(end);
		int vertex=end;
		while(vertex!=start){
			junctions.add(parent[vertex]);
			vertex=parent[vertex];
		}
		
		for(int i=junctions.size()-1; i>=0;i--){
			System.out.print(junctions.get(i)+1+" ");
		}
		System.out.println();
		System.out.println(distance[end]);
		
			
	}
	public static class Vertex implements Comparable<Vertex>{
		public int id;
		public int distance;
		
		public Vertex(){
		}
		public Vertex(int i, int d){
			id=i;
			distance=d;
		}
		public int compareTo(Vertex v) {
			return distance-v.distance;
		}

	}
}
