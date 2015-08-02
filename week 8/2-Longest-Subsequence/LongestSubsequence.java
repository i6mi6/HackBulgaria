package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestSubsequence {
	private static int[] numbers;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		numbers = new int[n];
		
		for(int i=0; i<n; i++){
			numbers[i]=Integer.parseInt(st.nextToken());
		}
		
		LIS(numbers);
		
	}
	
	public static void LIS(int[] d){
		String[] paths = new String[d.length];
		int[] sizes = new int[d.length];
		
		for(int i=0; i<d.length; i++){
			sizes[i]=1;
			paths[i]=d[i]+" ";
		}
		
		int maxLength = 1;
		
		for(int i=1; i<d.length; i++){
			for(int j=0; j<i; j++){
				if(d[j]<d[i]&&sizes[i]<sizes[j]+1){
					sizes[i]=sizes[j]+1;
					paths[i]=paths[j]+d[i]+" ";
					
					if(maxLength<sizes[i]){
						maxLength=sizes[i];
					}
				}
			}
		}
		System.out.print(maxLength);
		System.out.println();
		for(int i=0; i<d.length; i++){
			if(sizes[i]==maxLength){
				System.out.print(paths[i]);
			}
		}
		
		
		
	}
	
	
}
