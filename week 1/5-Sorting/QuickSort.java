package Sorting;

public class QuickSort {

	public static void main(String[] args) {
		int a[]={5,2,1,4,6,3};
		
		quickSort(a, 0, a.length-1);
		
		for(int i=0; i<a.length; i++){
			System.out.print(a[i]+" ");
		}
	}
	
	public static void quickSort(int[] a, int start, int end){
		int left = start;
		int right = end;
		int pivot = a[(start+end)/2];
		
		while(left<=right){
			while(a[left]<pivot){
				left++;
			}
			
			while(a[right]>pivot){
				right--;
			}
			
			if(left<=right){
				int temp = a[left];
				a[left]=a[right];
				a[right]=temp;
				left++;
				right--;
			}
		}
		
		if(left<end){
			quickSort(a, left, end);
		}
		if(right>start){
			quickSort(a, start, right);
		}
	}
	
}
