
public class Queue<T> {
	public static final int CAPACITY=10;
	public static int size;
	public static int head;
	public static int tail;
	public Object[] elements;

	public Queue(){
		size=0;
		tail=0;
		head=0;
		elements = new Object[CAPACITY];
	}
	
	public static void main(String[] args) {
		Queue<Integer> q = new Queue<Integer>();
		q.push(10);
		q.push(20);
		//q.pop();
		System.out.println(q.elements[head]);
	}
	
	public void push(T value){
		elements[tail]=value;
		if(tail==CAPACITY){ //if head == tail, queue overflow, increaseCapa() 
			tail=0;
		}else{
			tail++;
		}
		size++;
	}
	
	public T pop(){
		T front=(T)elements[head];
		if(head+1==CAPACITY){ 
			head=0;
		}else{
			head++;
		}
		size--;
		return front;
	}
	
	public T peek(){
		return (T)elements[head];
	}
	
	public int size(){
		return size;
	}
	
	public void print(){
		for(int i=0; i<size; i++){
			System.out.print(elements[i]+", ");
		}
	}
	
}
