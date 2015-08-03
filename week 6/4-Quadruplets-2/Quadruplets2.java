package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Quadruplets2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		int[] b = new int[n];
		int[] c = new int[n];
		int[] d = new int[n];
		
		StringTokenizer s = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++){
			a[i]=Integer.parseInt(s.nextToken());
		}
		s = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++){
			b[i]=Integer.parseInt(s.nextToken());
		}
		s = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++){
			c[i]=Integer.parseInt(s.nextToken());
		}
		s = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++){
			d[i]=Integer.parseInt(s.nextToken());
		}

		System.out.print(zeroQuadrupletsCount(a, b, c, d));
	
		
	}
	public static int zeroQuadrupletsCount(int[] a, int[] b, int[] c, int[] d) {
		int count = 0;
		Map<Integer, Integer> sums1 = new HashMap<Integer, Integer>();
		
		for(int i=0; i<a.length;i++){
			for(int j = 0; j<b.length; j++){
				if(sums1.get(a[i]+b[j])==null){
					sums1.put(a[i]+b[j], 1);
				}else{
					sums1.put(a[i]+b[j], sums1.get(a[i]+b[j])+1);
				}
				
			}
		}
		
		for(int i=0; i<c.length;i++){
			for(int j = 0; j<d.length; j++){
				if(sums1.get(-(c[i]+d[j]))!=null){
					count+=sums1.get(-(c[i]+d[j]));
				}
			}
		}

		return count;
	}
}
