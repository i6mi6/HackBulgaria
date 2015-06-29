package binary;

public class BST {
	public Node root;
	
	public boolean checkBST(Node n){
		if(n.left==null&&n.right==null){
			return true;
		}else if(n.left==null){
			if(n.right.value>n.value){
				return true&&checkBST(n.right);
			}else{
				return false;
			}
		}else if(n.right==null){
			if(n.left.value<n.value){
				return true&&checkBST(n.left);
			}else{
				return false;
			}
		}
		
		if(n.left.value<n.value&&n.right.value>n.value){
			return checkBST(n.left)&&checkBST(n.right);
		}else{
			return false;
		}
	}
	
	public static void main(String[] args){
		BST b = new BST();
		b.root=new Node(20, new Node(10),new Node(30));
			//bad definitions ahead
		b.root.left.left=new Node(4); 
		b.root.left.right=new Node(100);
		
		b.root.right.left=new Node(6);
		//b.root.right.right=new Node(32);
		
		System.out.println(b.checkBST(b.root));
	}
}
