package week6;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class KIntersect {
	private static Map<Integer, Integer> elements;
	private static int[][] lists;
	public static void main(String[] args) {
		elements = new HashMap<Integer,Integer>();
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		lists = new int[n][n];
		
		for(int i=0; i<n; i++){
			int m=s.nextInt();
			lists[i]=new int[m];
			for(int j=0; j<m; j++){
				int entry = s.nextInt();
				if(elements.containsKey(entry)){
					elements.put(entry, elements.get(entry)+1);
				}else{
					elements.put(entry, 1);
				}
				lists[i][j]=entry;
			}
		}
		
		intersect(lists);
	}
	
	public static void intersect(int[][] lists){
		Set<Entry<Integer,Integer>> result = elements.entrySet();
		for(Entry e:result){
			if((Integer)e.getValue()==lists.length){
				System.out.println(e.getKey());
			}
		}
	}
	
	

}
