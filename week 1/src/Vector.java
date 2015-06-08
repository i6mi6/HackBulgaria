
public class Vector<T>{
	public int size;
	public Object[] elements;
	public static final int CAPACITY=10;
	
	public Vector(){
		size=0;
		elements=new Object[CAPACITY];
	}
	
	public static void main(String[] args) {
		Vector<Integer> v = new Vector<Integer>();
		v.add(20);
		v.add(50);
		v.pop();
		v.print();
	}
	
	public void insert(int index, int value){
		if(size+5==elements.length){
			//increaseCapa();
		}
		for(int i=size; i>index; i--){
			elements[i]=elements[i-1];
		}
		elements[index]=value;
		size++;
	}
	
	public void add(int value){
		elements[size++]=value;
	}
	
	public void remove(int index){
		for(int i=index; i<size; i++){
			elements[i]=elements[i+1];
		}
		size--;
	}
	
	public Object get(int index){
		return (T)elements[index];
	}
	
	public Object pop(){
		return (T)elements[--size];
	}
	
	public int size(){
		return size;
	}
	
	public int capacity(){
		return CAPACITY;
	}
	
	public void print(){
		for(int i=0; i<size; i++){
			System.out.print(elements[i]+", ");
		}
	}
	
}
