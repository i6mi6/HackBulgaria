package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LongestCommonSubstring {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		LCS(br.readLine(), br.readLine());
	}
	
	public static void LCS(String one, String two){
		int n = one.length();
		int m = two.length();
		int[][] l = new int[n+1][m+1];
		int longest=0;
		String common = new String();
		
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(one.charAt(i)==two.charAt(j)){
					int v = l[i][j]+1;
					l[i+1][j+1]=v;
					if(v>longest){
						longest=v;
						common="";
					}
					if(v==longest){
						for(int k=i-v+1; k<i+1; k++){
							common+=one.charAt(k);
						}
					}
				}
			}
		}
		System.out.print(common);
	}

}








