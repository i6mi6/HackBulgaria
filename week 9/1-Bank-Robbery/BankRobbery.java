package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BankRobbery {
	public static int[][] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		graph = new int[n][n];
		
		for(int i=0; i<m; i++){
			st = new StringTokenizer(br.readLine());
			int k=Integer.parseInt(st.nextToken())-1;
			int q=Integer.parseInt(st.nextToken())-1;
			graph[k][q]=1;
			graph[q][k]=1;
		}
		st = new StringTokenizer(br.readLine());
		int b = Integer.parseInt(st.nextToken())-1;
		int p = Integer.parseInt(st.nextToken())-1;
		int h = Integer.parseInt(st.nextToken())-1;
		
		List<Integer> path=BFS(b, h); //get junctions from B to H
		
		//for all junctions in the path from P to <i-th junction in path> run BFS
		int fastest=BFS(p, b).size(); //from P to B
		for(int i=0; i<path.size(); i++){
			int time=BFS(p,path.get(i)).size();
			if(time<fastest){
				fastest=time;
			}
		}
		
		System.out.println(fastest-path.size());
		
	}
	
	public static List<Integer> BFS(int start, int end){
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[graph.length];
		int[] parents = new int[graph.length];
		for(int i=0; i< parents.length; i++){
			parents[i]=-1;
		}
		q.add(start);
		visited[start]=true;
		
		while(!q.isEmpty()){
			int v = q.poll();
			for(int i=0; i<graph[v].length; i++){
				if(graph[v][i]==1&&!visited[i]){
					visited[i]=true;
					parents[i]=v;
					q.add(i);
				}
			}
		}
		ArrayList<Integer> path = new ArrayList<Integer>();
		int p = end; //find the shortest path, starting from end to start, moving back through parents
		while(p!=start){
			//System.out.println(p+1);
			if(p==-1){
				System.out.println("no path from "+(start+1)+" to "+(end+1));
				break;
			}
			path.add(p);
			p=parents[p];
		}
		//System.out.println(start+1);
		//System.out.println("-----");
		
		return path;
	}
}
