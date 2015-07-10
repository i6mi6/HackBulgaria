package week4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Castaway {
	public static int[][] graph;
	public static StringBuilder[] map;
	public static Map<Character, Integer> letters;
	public static void main(String[] args) {
		graph = new int[28][28];
		
		letters = new HashMap<Character, Integer>(); //add consecutively letter harbors to a hashmap storing the index in the graph
		for(int i=0; i<26; i++){
			letters.put((char)(97+i), i+1); //add the letters
		}

		Scanner s = new Scanner(System.in);
		
		int N = s.nextInt();
		int M = s.nextInt();
		
		int sY = s.nextInt();
		int sX = s.nextInt();
		int fY = s.nextInt();
		int fX = s.nextInt();
		
		map = new StringBuilder[N]; //map
		for(int i=0; i<map.length; i++){ 
			map[i]=new StringBuilder();
		}
		
		for(int i=0; i<N; i++){
			map[i].append(s.next().substring(0, M));
		}
		/*map[0].append("...................###...");
		map[1].append("...f######.........#b#...");
		map[2].append(".....##a.................");
		map[3].append("....######...............");
		map[4].append("......................##.");
		map[5].append("....................####c");
		map[6].append("...###......m##....e##...");
		map[7].append("...#g.......##n....###...");
		map[8].append("...###..............###..");
		map[9].append("....................###..");
		map[10].append("....................#d#..");
		map[11].append("....###h###..............");
		map[12].append("....................j####");
		map[13].append("......####l####k....#####");*/
		
		map[sY].setCharAt(sX, '+'); //place start
		map[fY].setCharAt(fX, '-'); //place destination
		letters.put((char)'+',0);
		letters.put((char)'-',graph.length-1);
		
		for(int i=0; i<N; i++){
			System.out.println(map[i]);
		}
		
		int K = s.nextInt();
		
		for(int i=0;i<K;i++){
			String input = s.next();
			String input1 = s.next();

			graph[letters.get(input.charAt(0))][letters.get(input1.charAt(0))]=1;
			graph[letters.get(input1.charAt(0))][letters.get(input.charAt(0))]=1;
		} 
		
		System.out.println("length of shortest path: "+rescue());
		
	}
	
	public static int rescue(){
		traverseMap();
		return BFS(0);
	}
	
	public static void traverseMap(){ //O(N*M)
		for(int y=0; y<map.length; y++){ //call makeConnections for every piece of land 
			for(int x=0; x<map[y].length(); x++){
				if(map[y].charAt(x)!='.'){
					makeConnections(x, y, new ArrayList<Character>());
				}
			}
		}
	}
	
	public static void makeConnections(int x, int y, List<Character> harbors){ //O(N*M)
		if(map[y].charAt(x)!='.'&&map[y].charAt(x)!='#'){ //connect to all harbors found on that island so far
			for(int i=0; i<harbors.size(); i++){
				char harb = harbors.get(i);
				graph[letters.get(harb)][letters.get(map[y].charAt(x))]=1;
				graph[letters.get(map[y].charAt(x))][letters.get(harb)]=1;
			}
			harbors.add(map[y].charAt(x));
		}
		//make it a dot in order to mark it as visited
		map[y].setCharAt(x, '.');
		
		if(x+1<map[y].length()&&map[y].charAt(x+1)!='.'){ //right
			makeConnections(x+1, y, harbors);
		}if(x-1>=0&&map[y].charAt(x-1)!='.'){ //left
			makeConnections(x-1, y, harbors);
		}if(y-1>=0&&map[y-1].charAt(x)!='.'){ //up
			makeConnections(x, y-1, harbors);
		}if(y+1<map.length&&map[y+1].charAt(x)!='.'){ //down
			makeConnections(x, y+1, harbors);
		}
	}
	
	public static int BFS(int u){
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[graph.length];
		int[] parents = new int[graph.length];
		for(int i=0; i< parents.length; i++){
			parents[i]=-1;
		}
		q.add(u);
		visited[u]=true;
		
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
		int path=0;
		int p = graph.length-1; //find the shortest path, starting from end to start, moving back through parents
		//System.out.print("destination");
		while(p!=0){
			if(p==-1){
				System.out.println("NOOooo");
				path=0;
				break;
			}
			path++;
			//System.out.print((char)(p+97-1));
			p=parents[p];
		}

		return path;
	}
	
}
