package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Change {
	private static int[] coins = {1,2,5,10,20,50,100};
	private static long[][] sum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		sum = new long[n+1][7];
		System.out.println(findPermutations(n,coins.length-1));

	}
	public static long findPermutations(int n, int index){
		if(n<0||index < 0){
			return 0;
		}
		
		if(n==0||n==1){
			return 1;
		}
		
		if(sum[n][index]!=0){
			return sum[n][index];
		}
		
		sum[n][index]+=findPermutations(n-coins[index], index);
		sum[n][index]+=findPermutations(n, index-1);
		
		return sum[n][index];
	}
}
