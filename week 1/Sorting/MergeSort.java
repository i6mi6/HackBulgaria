package Sorting;

public class MergeSort {

	public static void main(String[] args) {
		int a[]={5,2,1,4,6,3};
		
		merge(a, 0, a.length-1);
		
		for(int i=0; i<a.length; i++){
			System.out.print(a[i]+" ");
		}

	}
	public static void merge(int[] a, int p, int r){
		if(p<r){
			int q = (p+r)/2;
			merge(a, p, q);
			merge(a, q+1, r);
			mergeSort(a, p, q, r);
		}
	}
	
	public static void mergeSort(int[] a, int p, int q, int r){
		int n1=q-p+1;
		int n2=r-q;
		int[] L = new int[n1+1];
		int[] R = new int[n2+1];
		
		for(int i=0; i<n1; i++){
			L[i]=a[p+i];
		}
		
		for(int i=0; i<n2; i++){
			R[i]=a[q+1+i];
		}
		
		L[n1]=(int)Double.POSITIVE_INFINITY;
		R[n2]=(int)Double.POSITIVE_INFINITY;
		
		int i=0;
		int j=0;
		
		for(int k=p; k<=r; k++){
			if(L[i]<R[j]){
				a[k]=L[i];
				i++;
			}else{
				a[k]=R[j];
				j++;
			}
		}
	}
}
