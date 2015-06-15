package Sorting;

public class SelectionSort {
	public static void main(String[] args) {
		int a[]={5,2,1,4,6,3};
		
		selectionSort(a);
		
		for(int i=0; i<a.length; i++){
			System.out.print(a[i]+" ");
		}
	}
	public static void selectionSort(int[] a){
		for(int i=0; i<a.length-1; i++){
			int smallest=i;
			for(int j=i+1; j<a.length; j++){
				if(a[smallest]>a[j]){
					smallest=j;
				}
			}
			int temp = a[i];
			a[i]=a[smallest];
			a[smallest]=temp;
		}
	}

}
