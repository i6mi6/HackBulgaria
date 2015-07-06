package week4;

import java.util.*;

public class Coffee {

	public static void main(String[] args) {
		int[][] graph = {{0,1,0,1,0,0},
						 {1,0,1,0,0,0},
						 {0,1,0,0,1,0},
						 {1,0,0,0,0,0},
						 {0,0,1,0,0,1},
						 {0,0,0,0,1,0}};
		int[] stores = {0,0,1,0,0,1};
		System.out.println(find(graph, stores, 0));
		
	}
	
	public static int find(int[][] graph, int[] stores, int start){
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] vertices = new boolean[graph.length];
		vertices[start]=true;
		q.add(start);
		
		while(!q.isEmpty()){
			int v = q.poll();
			
			for(int i=0; i<graph[v].length; i++){
				if(graph[v][i]==1){ //if v is linked to i
					if(vertices[i]==false){ //and i is not visited
						if(stores[i]==1){ //is that a coffee store?
							return i;
						}
						q.add(i);
						System.out.println(i+" added");
						vertices[i]=true;
					}
					
				}
			}
			
		}
		return -1;
	}

}
