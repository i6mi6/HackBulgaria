package week2;

import heap.Heap;

public class KMin {

	public static void main(String[] args) {
		KMin k = new KMin();
		int[] a = {5,12,876,2,6,1,-23,144};
		
		System.out.println(k.kMin(a, 3));
		
	}
	
	public int kMin(int[] a, int k){ //O[(n+k)lgn]
		if(k>a.length||k<1){
			return 0;
		}
		
		Heap h = new Heap(a);
		h.buildMinHeap(); //O(nlgn)
		
		int kMin=h.extractMin(); 
		
		for(int i=0; i<k-1; i++){ //O(klgn)
			kMin=h.extractMin();
		}
		
		return kMin;
	}

}
