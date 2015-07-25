package week6;

import heap.Heap;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

import week6.Dijkstra.Vertex;

public class LowCostFlights {
	public static final int inf = (int)Double.POSITIVE_INFINITY;
	public static int[][] graph;/* = {{0,9,0,3,2,0,0,0},
								   {0,0,7,2,0,0,9,0},
								   {7,0,0,0,0,7,7,0},
								   {0,2,0,0,0,0,0,0},
								   {0,0,0,0,0,0,5,0},
								   {0,3,0,0,0,0,0,0},
								   {0,0,0,0,0,0,0,0},
								   {0,0,0,0,0,4,0,0}};*/
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		graph = new int[n][n];
		
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				graph[i][j]=s.nextInt();
			}
		}
		
		int m = s.nextInt();
		
		while(m>0){
			Dijkstra(s.nextInt(), s.nextInt());
			m--;
		}

	}
	
	public static void Dijkstra(int start, int end){
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
					}
					q.add(new Vertex(i, distance[i]));
				}
				
			}
			
			
		}
		if(distance[end]>0){
			System.out.println(distance[end]);
		}else{
			System.out.println("NO WAY");
		}
		
			
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
