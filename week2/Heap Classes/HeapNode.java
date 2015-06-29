package heap;

import java.util.Arrays;

import week2.Node;

public class HeapNode {
	public int heapSize;
	public Node[] elements;
	public static int left(int i){
		return 2*i+1;
	}
	public static int right(int i){
		return 2*i+2;
	}
	public static int parent(int i){
		return (i-1)/2;
	}
	
	public HeapNode(Node[] els){
		elements=els;
	}
	
	public static void main(String[] args) {
		//int[] a = {5,12,876,2,6,1,-23,144};
		Node[] a = {new Node(20,null), new Node(7,null), new Node(4,null), new Node(-23,null)};
		
		HeapNode h = new HeapNode(a);
		h.buildMinHeap();
		h.insertMin(new Node(-233,null));
		h.extractMin();
		
		h.print();
	}
	
	public void minHeapify(Node[] a, int i){
		int left=left(i);
		int right = right(i);
		int smallest;
		if(left<heapSize&&a[i].value>a[left].value){
			smallest=left;
		}else{
			smallest = i;
		}
		if(right<heapSize&&a[smallest].value>a[right].value){
			smallest=right;
		}
		if(smallest!=i){
			Node temp = a[i];
			a[i]=a[smallest];
			a[smallest]=temp;
			minHeapify(a,smallest);
		}
		
	}
	
	public void maxHeapify(Node[] a, int i){
		int left=left(i);
		int right = right(i);
		int biggest;
		if(left<heapSize&&a[i].value<a[left].value){
			biggest=left;
		}else{
			biggest = i;
		}
		if(right<heapSize&&a[biggest].value<a[right].value){
			biggest=right;
		}
		if(biggest!=i){
			Node temp = a[i];
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
	
	public Node extractMin(){
		Node min = elements[0];
		elements[0]=elements[heapSize-1];
		elements[heapSize-1]=min;
		heapSize--;
		minHeapify(elements, 0);
		
		//elements=Arrays.copyOf(elements, elements.length-1);
		return min;
	}
	
	public Node extractMax(){
		Node min = elements[0];
		elements[0]=elements[heapSize-1];
		elements[heapSize-1]=min;
		heapSize--;
		maxHeapify(elements, 0);
		
		//elements=Arrays.copyOf(elements, elements.length-1);
		return min;
	}
	
	public void insertMin(Node k){
		if(heapSize+5>=elements.length){
			elements=Arrays.copyOf(elements, elements.length*2);
		}
		increaseMinKey(heapSize, k);
		heapSize++;
	}
	
	public void insertMax(Node k){
		if(heapSize+5>=elements.length){
			elements=Arrays.copyOf(elements, elements.length*2);
		}
		increaseMaxKey(heapSize, k);
		heapSize++;
	}
	
	public void increaseMaxKey(int i, Node key){
		elements[i]=key;
		while(i>=0&&elements[i].value>elements[parent(i)].value){
			Node temp = elements[i];
			elements[i]=elements[parent(i)];
			elements[parent(i)]=temp;
			i=parent(i);
		}
		
	}
	
	public void increaseMinKey(int i, Node key){
		elements[i]=key;
		while(i>=0&&elements[i].value<elements[parent(i)].value){
			Node temp = elements[i];
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
			System.out.print(elements[i].value+", ");
		}
	}
}
