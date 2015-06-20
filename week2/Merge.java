package week2;

import java.util.*;

public class Merge {
	public static PriorityQueue<Node> queue; //using a queue instead of a heap
	public static class Node {
		public int value;
		public Node next;
		
		public Node(int v, Node n){
			value=v;
			next=n;
		}
	}
	
	
	public static void main(String[] args) {
		List<Node> lists = new ArrayList<Node>();
		Node n = new Node(23,null);
		Node n1 = new Node(6,n);
		Node n2 = new Node(-31,n1);
		
		Node a = new Node(58,null);
		Node a1 = new Node(4,a);
		Node a2 = new Node(-3,a1);
		
		Node b = new Node(100,null);
		Node b1 = new Node(1,b);
		Node b2 = new Node(-64,b1);
		
		lists.add(a2);
		lists.add(b2);
		lists.add(n2);
			
			//using comparator to arrange the queue by node value
		queue = new PriorityQueue<Node>(lists.size(), new Comparator<Node>(){
			public int compare(Node n1, Node n2) {
				if(n1.value>n2.value){
					return 1;
				}else if(n1.value<n2.value){
					return -1;
				}else{
					return 0;
				}
			}});
			
			//test
		Node node = merge(lists);
		while(node!=null){
			System.out.print(node.value+", ");
			node=node.next;
		}
	}
	
	public static Node merge(List<Node> lists) {
		Node head = new Node(0, null);
		Node result = head;
			//populate the queue
		for(int i=0; i<lists.size(); i++){
			queue.add(lists.get(i));
		}
		
		while(!queue.isEmpty()){
			head.next=deleteMin();
			head=head.next;
		}
		
		return result.next;
	}
	
	public static Node deleteMin(){
		Node n = queue.poll();
		if(n.next!=null){
			queue.offer(n.next);
		}
		return n;
	}

}
