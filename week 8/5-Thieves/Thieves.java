package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Thieves {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(s.nextToken());
		int capacity = Integer.parseInt(s.nextToken());
		
		int[][] items = new int[n][2];
		for(int i=0; i<n; i++){
			s = new StringTokenizer(br.readLine());
			items[i][0]=Integer.parseInt(s.nextToken());
			items[i][1]=Integer.parseInt(s.nextToken());
		}

		find(items,capacity);
	}

	public static void find(int[][] items, int capacity){
		int[][] v = new int[items.length+1][capacity];
		int[][] keep = new int[items.length+1][capacity];
		
		for(int i=1; i<items.length+1; i++){
			for(int j=0; j<capacity; j++){
				if(items[i-1][0]>j+1){
					v[i][j]=v[i-1][j];
				}else{
					int remainingWeight = j-items[i-1][0];
					if(remainingWeight>0){
						v[i][j]=Math.max(items[i-1][1]+v[i-1][remainingWeight],v[i-1][j]);
					}else{
						v[i][j]=Math.max(items[i-1][1],v[i-1][j]);
					}
					if(v[i][j]!=v[i-1][j]){
						keep[i][j]=1;
					}
				}
			}
		}
		System.out.println(scan(items, keep, capacity));
	}
	public static int scan(int[][] items, int[][] keep, int capacity){
		int maxValue=0;
		for(int i=keep.length-1; i>0; i--){
			if(keep[i][capacity-1]==1){
				maxValue+=items[i-1][1];
				capacity-=items[i-1][0];
			}
		}
		return maxValue;
	}
}
