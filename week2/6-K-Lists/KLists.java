package week2;

import heap.Heap;
import heap.HeapNode;
import java.util.*;

public class KLists {
	public static void main(String[] args) {
		Node n1 = new Node(20,null);
		Node n2 = new Node(7,n1);
		Node n3 = new Node(4,n2);
		Node n4 = new Node(-23,n3);
		
		Node b1 = new Node(30,null);
		Node b2 = new Node(11,b1);
		Node b3 = new Node(6,b2);
		Node b4 = new Node(-3,b3);
		
		Node a1 = new Node(100,null);
		Node a2 = new Node(41,a1);
		Node a3 = new Node(2,a2);
		Node a4 = new Node(-1,a3);
		
		List<Node> lists = new ArrayList<Node>();
		lists.add(n4);
		lists.add(b4);
		lists.add(a4);
		
		Node merged = merge(lists);
		merged.print();
	}
	
	public static Node merge(List<Node> lists) { //O(nlgn)
		Node[] roots = new Node[lists.size()];
		for(int i=0; i<lists.size(); i++){ //O(n)
			roots[i]=lists.get(i);
		}
		
		HeapNode h = new HeapNode(roots);
		h.buildMinHeap(); //O(nlgn)
		
		Node root=null;
		Node current;
		
		while(!h.isEmpty()){ //O(nlgn)
			current=h.extractMin();
			if(current.next!=null){
				h.insertMin(current.next);
			}
			current.next=root;
			root=current;
			
		}
		
		return root;
	 }

}
