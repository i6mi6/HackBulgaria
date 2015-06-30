package heap;

import java.util.Arrays;

public class Heap {
	public int heapSize;
	public int[] elements;
	public static int left(int i){
		return 2*i+1;
	}
	public static int right(int i){
		return 2*i+2;
	}
	public static int parent(int i){
		return (i-1)/2;
	}
	
	public Heap(int[] els){
		elements=els;
	}
	
	public static void main(String[] args) {
		int[] a = {5,12,876,2,6,1,-23,144};
		
		Heap h = new Heap(a);
		h.buildMinHeap();
		h.insertMin(-233);
		h.extractMin();
		
		h.print();
	}
	
	public void minHeapify(int[] a, int i){
		int left=left(i);
		int right = right(i);
		int smallest;
		if(left<heapSize&&a[i]>a[left]){
			smallest=left;
		}else{
			smallest = i;
		}
		if(right<heapSize&&a[smallest]>a[right]){
			smallest=right;
		}
		if(smallest!=i){
			int temp = a[i];
			a[i]=a[smallest];
			a[smallest]=temp;
			minHeapify(a,smallest);
		}
		
	}
	
	public void maxHeapify(int[] a, int i){
		int left=left(i);
		int right = right(i);
		int biggest;
		if(left<heapSize&&a[i]<a[left]){
			biggest=left;
		}else{
			biggest = i;
		}
		if(right<heapSize&&a[biggest]<a[right]){
			biggest=right;
		}
		if(biggest!=i){
			int temp = a[i];
			a[i]=a[biggest];
			a[biggest]=temp;
			maxHeapify(a,biggest);
		}
		
	}
	
	public void buildMaxHeap(){
		heapSize=elements.length;
		
		for(int i=elements.length/2; i>=0; i--){
			maxHeapify(elements, i);
		}
	}
	
	public void buildMinHeap(){
		heapSize=elements.length;
		
		for(int i=elements.length/2; i>=0; i--){
			minHeapify(elements, i);
		}
	}
	
	public int extractMin(){
		int min = elements[0];
		elements[0]=elements[heapSize-1];
		elements[heapSize-1]=min;
		heapSize--;
		minHeapify(elements, 0);
		
		//elements=Arrays.copyOf(elements, elements.length-1);
		return min;
	}
	
	public int extractMax(){
		int min = elements[0];
		elements[0]=elements[heapSize-1];
		elements[heapSize-1]=min;
		heapSize--;
		maxHeapify(elements, 0);
		
		//elements=Arrays.copyOf(elements, elements.length-1);
		return min;
	}
	
	public void insertMin(int k){
		if(heapSize+5>=elements.length){
			elements=Arrays.copyOf(elements, elements.length*2);
		}
		increaseMinKey(heapSize, k);
		heapSize++;
	}
	
	public void insertMax(int k){
		if(heapSize+5>=elements.length){
			elements=Arrays.copyOf(elements, elements.length*2);
		}
		increaseMaxKey(heapSize, k);
		heapSize++;
	}
	
	public void increaseMaxKey(int i, int key){
		elements[i]=key;
		while(i>=0&&elements[i]>elements[parent(i)]){
			int temp = elements[i];
			elements[i]=elements[parent(i)];
			elements[parent(i)]=temp;
			i=parent(i);
		}
		
	}
	
	public void increaseMinKey(int i, int key){
		elements[i]=key;
		while(i>=0&&elements[i]<elements[parent(i)]){
			int temp = elements[i];
			elements[i]=elements[parent(i)];
			elements[parent(i)]=temp;
			i=parent(i);
		}
		
	}
	
	public boolean isEmpty(){
		if(heapSize>0){
			return false;
		}
		return true;
	}
	
	public void print(){
		for(int i=0; i<heapSize; i++){
			System.out.print(elements[i]+", ");
		}
	}
}
