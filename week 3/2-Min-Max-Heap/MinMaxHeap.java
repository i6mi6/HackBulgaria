package binary;

public class MinMaxHeap {
	public static void main(String[] args) {
		Node b4 = new Node(2);
		Node b3 = new Node(1);
		Node b2 = new Node(4);
		Node b1 = new Node(3);
		
		Node a2 = new Node(8,b3,b4);
		Node a1 = new Node(6,b1,b2);
		
		Node root = new Node(5, a1, a2);
		
		System.out.println(isMinMax(root));

	}
	
	public static boolean isMinMax(Node root) {
		return scan(root, 1);
	}
	
	public static boolean scan(Node n, int level){ //O(n)
		if(n.left==null&&n.right==null){ //let's suppose it's a full heap, where each node has 0 or 2 children
			return true;
		}
		if(level%2==0){
			if(n.left.value<n.value&&n.right.value<n.value){
				return true&&scan(n.left,level+1)&&scan(n.right,level+1);
			}else{
				return false;
			}
		}else{
			if(n.left.value>n.value&&n.right.value>n.value){
				return true&&scan(n.left,level+1)&&scan(n.right,level+1);
			}else{
				return false;
			}
		}
	}
}
