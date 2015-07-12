package week5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class PowerSupply {
	public static int[][] graph;
	public static Set<Integer> set;
	public static final int inf = (int)Double.POSITIVE_INFINITY;
	public static void main(String[] args) {
		set = new HashSet<Integer>();
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		graph=new int[N][N];
		
		for(int k=0;k<N; k++){
			for(int j=0;j<N;j++){
				graph[k][j]=inf;
			}
		}

		for(int i=0; i<N; i++){
			int one = s.nextInt();
			int two = s.nextInt();
			int len = s.nextInt();
			set.add(one);
			set.add(two);
			graph[one][two]=len;
			graph[two][one]=len;
		}
		
		s.close();
		
		System.out.println(MST());
		
	}
	
	public static int MST(){
		List<Integer> vertices = new ArrayList<Integer>();
		int index = 0;
		for(int i=0; i<set.size(); i++){
			if(set.contains(i)){
				index = i;
				break;
			}
		}
		vertices.add(index);
		int length=0;
		
		while(vertices.size()<set.size()){
			int cheapest = 0;
			for(int i=0; i<vertices.size();i++){
				for(int j=0; j<graph[vertices.get(i)].length;j++){
					if(graph[index][cheapest]>graph[vertices.get(i)][j]){
						cheapest = j;
						index = vertices.get(i);
					}
				}
			}
			length+=graph[index][cheapest];
			graph[index][cheapest]=inf;
			graph[cheapest][index]=inf;
			vertices.add(cheapest);
		}
		return length;
	}


}
