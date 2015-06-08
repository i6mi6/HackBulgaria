
public class Node<T>{
		public Node<T> prev;
		public Node<T> next;
		public T content;
		
		public Node(){}
		
		public Node(T c, Node<T> n){
			content = c;
			next = n;
		}
		
		public Node(T c, Node<T> p, Node<T> n){
			content = c;
			next = n;
			prev = p;
		}
		
	}
