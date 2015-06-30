package week2;

public class HeapSort {
	public static int heapSize;
	
	public static int left(int i){
		return 2*i+1;
	}
	public static int right(int i){
		return 2*i+2;
	}
	
	
	public static void main(String[] args) {
		int[] A = {85,66,5,11,6,-11,1};
		sort(A);
		for(int i=0; i<A.length; i++){
			System.out.print(A[i]+" ");
		}
	}
	
	public static void maxHeapify(int[] a, int i){
		int best;
		
		if(left(i)<heapSize&&a[i]<a[left(i)]){
			best=left(i);
		}else{
			best=i;
		}
		
		if(right(i)<heapSize&&a[best]<a[right(i)]){
			best=right(i);
		}
		
		if(best!=i){
			int temp = a[best];
			a[best]=a[i];
			a[i]=temp;
			maxHeapify(a, best);
		}
		
	}
	
	public static void buildMaxHeap(int[] a){
		heapSize=a.length;
		
		for(int i=heapSize/2; i>=0; i--){
			maxHeapify(a, i);			
		}
	}
	
	public static void sort(int[] a){
		buildMaxHeap(a);
		
		for(int i=heapSize-1; i>0; i--){
			int temp = a[i];
			a[i]=a[0];
			a[0]=temp;
			heapSize--;
			maxHeapify(a,0);
		}
	}
	
}
