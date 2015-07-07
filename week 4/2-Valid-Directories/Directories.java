package week4;

public class Directories {

	public static void main(String[] args) {
		int[][] graph = {{0,1,0,1,0,2},
				 		 {0,0,2,0,0,0},
				 		 {0,0,0,0,0,0},
				 		 {0,0,0,0,2,0},
				 		 {0,0,0,0,0,0},
				 		 {0,0,0,0,0,0}};
		boolean[] visited = new boolean[6];
		isValid(graph, visited);

	}
	
	public static boolean isValid(int[][] graph, boolean[] visited){
		for(int i=0; i<graph.length; i++){ //scan all vertices
			if(!visited[i]){
				if(!DFSVisit(graph, i, visited)){ //pass it to the recursion if it's not visited
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean DFSVisit(int[][] graph, int u, boolean[] visited){
		visited[u]=true;
		for(int i=0; i<graph[u].length; i++){ //scan all adjacent to u
			if(graph[u][i]==1&&graph[i][u]==1){ //if u is a folder and contains folder i, and i contains u, blow
				System.out.println("mutual parents broken at "+i);
				return false;
			}
			if(graph[u][i]==1&&!visited[i]){ //if not visited folder, visit it
				DFSVisit(graph,i,visited);
			}else if(graph[u][i]==2&&!visited[i]){ //if it's a file
				visited[i]=true;
				for(int j=0; j<graph[i].length; j++){ //files do not have adjacent vertices (apart from parent)
					if(graph[i][j]!=0){
						System.out.println("file broken at "+i);
						return false;
					}
				}
			}
		}
		
		return true;
	}

}
