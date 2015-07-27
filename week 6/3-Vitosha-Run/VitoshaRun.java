package week6;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class VitoshaRun {
	public static final int inf = (int)Double.POSITIVE_INFINITY;
	public static int[][] graph;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		graph = new int[n][n];
		int startRow = s.nextInt();
		int startCol = s.nextInt();
		int endRow = s.nextInt();
		int endCol = s.nextInt();
		
		for(int i=0; i<n; i++){
			for(int j=0;j<n;j++){
				graph[i][j]=s.nextInt();
			}
		}
		
		Dijkstra(startRow,startCol,endRow,endCol);

	}
	
	public static void Dijkstra(int startRow, int startCol, int endRow, int endCol){
		int[] distance = new int[graph.length*graph.length];
		Queue<Vertex> q = new PriorityQueue<Vertex>();
		boolean[] visited = new boolean[graph.length*graph.length];
		for(int i = 0 ; i<distance.length; i++){
			distance[i]=inf;
		}
		
		q.add(new Vertex(startRow, startCol, 0));
		distance[startRow*graph.length+startCol]=0;
		visited[startRow*graph.length+startCol]=true;

		int current;

		while(!q.isEmpty()){
			int row = q.peek().row;
			int col = q.peek().col;
			current=row*graph.length+col;
			q.poll();
			q.clear();
			visited[current]=true;
	
			for(int i=0; i<distance.length; i++){
				if(!visited[i]){
					int colI=i%graph.length;
					int rowI=(i-colI)/graph.length;
					if((i==current-graph.length||(i==current-1&&row!=0)||(i==current-graph.length-1&&row!=0)||(i==current-graph.length+1&&row!=graph.length-1)||(i==current+graph.length-1&&row!=0)||
							(i==current+graph.length+1&&row!=graph.length-1)||(i==current+1&&row!=graph.length-1)||i==current+graph.length)&&distance[i]>distance[current]+Math.abs(graph[row][col]-graph[rowI][colI])){
						distance[i]=distance[current]+Math.abs(graph[row][col]-graph[rowI][colI])+1;
					}

					q.add(new Vertex(rowI,colI, distance[i]));
				}
				
			}
			
			
		}

		System.out.print(distance[endRow*graph.length+endCol]);
			
	}
	
	/*public static int[][] mapToGraph(int[][] map){
		int[][] graph = new int[map.length*map.length][map.length*map.length];
		for(int i=0; i<map.length; i++){
			
		}
		
		return null;
	}*/
	
	public static class Vertex implements Comparable<Vertex>{
		public int row;
		public int col;
		public int distance;
		
		public Vertex(){
		}
		public Vertex(int r, int c, int d){
			row = r;
			col = c;
			distance=d;
		}
		public int compareTo(Vertex v) {
			return distance-v.distance;
		}

	}
}
