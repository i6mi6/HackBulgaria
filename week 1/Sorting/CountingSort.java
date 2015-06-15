package Sorting;

public class CountingSort {
	
	public static void main(String[] args) {
		int a[]={5,2,1,4,6,3};
		
		a=counting(a, 6);
		
		for(int i=0; i<a.length; i++){
			System.out.print(a[i]+" ");
		}
	}
	public static int[] counting(int[] a, int k){
		int[] c = new int[k+1];
		int[] b = new int[a.length];
		
		for(int i=0; i<a.length; i++){
			c[a[i]]++;
		}
		
		for(int j=1; j<=k; j++){
			c[j]+=c[j-1];
		}
		
		for(int p=a.length-1; p>=0; p--){
			b[--c[a[p]]]=a[p];
			c[a[p]]--;
		}
		return b;
	}
}
