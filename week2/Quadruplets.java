package week2;

import java.util.*;

public class Quadruplets {

	public static void main(String[] args) {
		System.out.print(zeroQuadrupletsCount(new int[]{5, 3, 4}, new int[]{-2, -1, 6}, new int[]{-1, -2, 4}, new int[]{-1, -2, 7}));

	}
	public static int zeroQuadrupletsCount(int[] a, int[] b, int[] c, int[] d) {
		int count = 0;
		Map<Integer, Integer> sums1 = new HashMap<Integer, Integer>();
		
		for(int i=0; i<a.length;i++){ //add sums of the first two vectors to a map
			for(int j = 0; j<b.length; j++){
				if(sums1.get(a[i]+b[j])==null){
					sums1.put(a[i]+b[j], 1);
				}else{
					sums1.put(a[i]+b[j], sums1.get(a[i]+b[j])+1);
				}
				
			}
		}
		
		for(int i=0; i<c.length;i++){ //check if sums of the last two vectors added to some map sum = 0
			for(int j = 0; j<d.length; j++){
				if(sums1.get(-(c[i]+d[j]))!=null){
					count+=sums1.get(-(c[i]+d[j]));
				}
			}
		}

		return count;
	}
}
