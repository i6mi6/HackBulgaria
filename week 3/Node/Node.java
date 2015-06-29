package binary;

class Node{
	public int value;
	public Node left;
	public Node right;
	
	Node(){
		value=0;
	}
	
	Node(int v){
		value=v;
	}
	
	Node(int v, Node l, Node r){
		value=v;
		left=l;
		right=r;
	}
}
