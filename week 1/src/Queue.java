
public class Queue<T> {
	public int size;
	public Node<T> first;
	public Node<T> last;
	
	public Queue(){
		size=0;		
		
	}
	
	public static void main(String[] args) {
		Queue<Integer> q = new Queue<Integer>();
		q.push(6);
		q.push(5);
		q.push(53);
		//q.pop();
		q.print();
	}
	
	public void push(T value){
		Node n = new Node(value, null);
		if(last==null){
			first=n;
			last=n;
		}else{
			last.next=n;
		}
		last=n;
		size++;
	}
	
	public T pop(){
		T el = first.content;
		first=first.next;
		size--;
		
		return el;
	}
	
	public T peek(){
		return first.content;
	}
	
	public int size(){
		return size;
	}
	
	public void print(){
		Node<T> current = first;
		while(current!=null){
			System.out.print(current.content+", ");
			current = current.next;
		}
	}
	
}
