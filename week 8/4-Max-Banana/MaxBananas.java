package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxBananas {
	public static int[][] sum;
	public static int[][] matrix;
	public static int maxBananas=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(br.readLine());

			sum = new int[n][n];
			matrix = new int[n][n];
			
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					matrix[i][j]=(int)(Math.random()*199+1);
				}
			}
			
			for(int i=0; i<n; i++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++){
					matrix[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			sum[n-1][0]=matrix[n-1][0];
			System.out.println(findMaxBananas(n-1,0));

	}
	
	public static int findMaxBananas(int x, int y){
		if(x<0){
			return 0;
		}
		if(y>=matrix.length){
			return 0;
		}
		
		if(sum[y][x]!=0){
			return sum[y][x];
		}
		
		int left = findMaxBananas(x-1,y);
		int bottom = findMaxBananas(x, y+1);
		
		left += matrix[y][x];
		bottom += matrix[y][x];
		
		sum[y][x]=Math.max(left, bottom);

		return sum[y][x];
	}

}
