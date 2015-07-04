package week3;

public class JumpingSoldiers {
	public static int inversions=0;
	public static void main(String[] args) {
		int k=3;
		int n=3;
		int soldiers[][] = new int[k][n];
		soldiers[0]=new int[]{1,2,3};
		soldiers[1]=new int[]{2,1,3};
		soldiers[2]=new int[]{3,2,1};
		
		System.out.println(find(soldiers));
	}
	
	public static int find(int[][] soldiers){ //O(knlgn)
		int max=0;
		int index=-1;
		for(int i=0; i<soldiers.length; i++){
			merge(soldiers[i], 0, soldiers[i].length-1); //O(knlgn)
			if(max<inversions){
				max = inversions;
				index = i;
			}
			inversions = 0;
		}
		return index;
	}
	
	public static void merge(int[] a, int p, int r){ 
		if(p<r){
			int q=(p+r)/2;
			merge(a, p, q);
			merge(a, q+1, r);
			mergeSort(a, p, q, r);
		}
	}
	public static void mergeSort(int[] a, int p, int q, int r){
		int n1 = q-p+1;
		int n2 = r-q;
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
				inversions+=L.length-1-i;
				j++;
			}
		}
	}
	
	
	
}



