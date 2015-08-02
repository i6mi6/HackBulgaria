package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NeedleHaystack {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		kmp(br.readLine(),br.readLine());

	}
	
	public static void kmp(String text, String pattern){
		int[] table = kmpPrefix(pattern);
		int q=0;
		
		for(int i=0; i<text.length(); i++){
			while(q>0&&pattern.charAt(q)!=text.charAt(i)){
				q=table[q];
			}
			if(pattern.charAt(q)==text.charAt(i)){
				q++;
			}
			if(q==pattern.length()){
				System.out.println("Match found at index "+(i-pattern.length()+1));
				q=table[q-1];
			}
		}
	}
	
	public static int[] kmpPrefix(String pattern){
		int[] table = new int[pattern.length()];
		table[0]=0;
		int k=0;
		
		for(int q=1; q<pattern.length(); q++){
			while(k>0&&pattern.charAt(k)!=pattern.charAt(q)){
				k=table[k];
			}
			if(pattern.charAt(k)==pattern.charAt(q)){
				k++;
			}
			table[q]=k;
		}
		
		return table;
	}
	
}
