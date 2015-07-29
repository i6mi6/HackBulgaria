package week6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RandSet {
	private ArrayList<Integer>[] elements;
	private int CAPACITY=10;
	private int numberOfElements=0;
	
	public static void main(String[] args) {
		RandSet set = new RandSet();
		Scanner s = new Scanner(System.in);
		int n=s.nextInt();
		StringBuilder command = new StringBuilder();
		
		while(n>0){
			command.append(s.next());
			if(command.toString().equals("random")){
				set.random();
			}else{
				set.commands(command.toString(), s.nextInt());
			}
			command.setLength(0);
			n--;
		}
	}
	
	public RandSet(){
		elements = new ArrayList[CAPACITY];
		for(int i=0; i<CAPACITY; i++){
			elements[i] = new ArrayList<Integer>();
		}
	}
	
	private int hashFunctionMultiplication(int key){
		double A = 0.6180339887d;
		return (int)(((key*A)%1)*CAPACITY);
	}
	
	private void insert(int value){
		if(numberOfElements+2>CAPACITY){ //increase capacity at some point
			increaseCapacity();
		}
		int key = hashFunctionMultiplication(value); //hash the key
		if(!contains(value)){
			elements[key].add(value);
			numberOfElements++;
		}
		
	}
	
	private void remove(int value){
		if(contains(value)){
			int key = hashFunctionMultiplication(value);
			for(int i=0; i<elements[key].size(); i++){
				if(elements[key].get(i)==value){
					elements[key].remove(i);
				}
			}
		}
	}
	
	public boolean contains(int value){
		int key = hashFunctionMultiplication(value);
		if(elements[key]!=null){
			for(int i=0; i<elements[key].size(); i++){
				if(elements[key].get(i)==value){
					return true;
				}
			}
		}
		return false;
	}
	
	public void random(){
		if(numberOfElements>0){
			int i = (int) (Math.random()*CAPACITY);
			while(!contains(i)){
				i = (int) (Math.random()*CAPACITY);
				System.out.println(i);
			}
		}
	}
	
	private void increaseCapacity(){
		int oldLength = elements.length;
		CAPACITY = elements.length+elements.length/2;
		elements = Arrays.copyOf(elements, CAPACITY);
		for(int i=oldLength; i<CAPACITY; i++){
			elements[i] = new ArrayList<Integer>();
		}
	}
	
	
	public void print(){
		for(ArrayList<Integer> list:elements){
			for(int el:list){
				System.out.print(el+", ");
			}
			System.out.println();
		}
	}
	
	public void commands(String cmd, int value){
		switch(cmd){
			case "insert": insert(value);break;
			case "remove": remove(value);break;
			case "contains": System.out.print(contains(value));
		}
	}

}
