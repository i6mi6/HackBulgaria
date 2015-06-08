
public class Stack<T> {
	public int size;
	public Node<T> top;
	
	public Stack(){
		size=0;
		
	}
	
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(6);
		s.push(5);
		s.push(53);
		s.pop();
		s.print();
		

	}
	
	public void push(T value){
		Node<T> n = new Node<T>(value, top);
		top = n;
		size++;
	}
	
	public T pop(){
		T el = top.content;
		top=top.next;
		size--;
		
		return el;
	}
	
	public T peek(){
		return top.content;
	}
	
	public int size(){
		return size;
	}
	
	public void print(){
		Node<T> current = top;
		while(current!=null){
			System.out.print(current.content+", ");
			current = current.next;
		}
	}
	
	public class Node<T>{
		public Node<T> next;
		public T content;
		
		public Node(T c, Node<T> n){
			content = c;
			next = n;
		}
		
	}

}
