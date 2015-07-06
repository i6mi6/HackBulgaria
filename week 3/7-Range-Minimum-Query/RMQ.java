package week3;

import java.util.Arrays;

public class RMQ {
	public static int[] elements;
	public static void main(String[] args) {
		int[] initial = {1,7,2,5,8,11,3,-347};
		makeTree(initial);
		
		System.out.println("min: "+min(7, 13));
			//print
		for(int i=0; i<elements.length; i++){
			System.out.print(elements[i]+", ");
		}
		
	}
	
	public static int min(int start, int end){
		int left=start;
		int right=end;

		if(left%2==0){
			if(elements[left]>elements[left/2]){
				left=left+1;
			}
		}
		if(right%2!=0){
			if(elements[right]>elements[(right-2)/2]){
				right=right-1;
			}
		}
		int range = (int)(Math.log(right-left)/Math.log(2));

		while(range>0){
			if(right%2==0){
				right=(right-1)/2;
			}if(left%2!=0){
				left=(left-1)/2;
			}
			range--;
			if(range==0){
				break;
			}
			if((left%2==0&&right%2!=0)){
				if(elements[right]>elements[left]){
					right=(right-2)/2;
				}else{
					left=left/2;
				}
			}
			
		}

		if(elements[right]>elements[left]){
			return elements[left];
		}else{
			return elements[right];
		}
	}
	
	public static void makeTree(int[] initial){
		int size=checkSize(initial.length);
		elements=new int[size*2-1];
		
		//place zeros in the end
		for(int i=0; i<initial.length; i++){
			elements[i+elements.length/2]=initial[i];
		}

		for(int i=elements.length/2-1; i>=0; i--){
			if(elements[i*2+1]>elements[i*2+2]){
				elements[i]=elements[i*2+2];
			}else{
				elements[i]=elements[i*2+1];
			}
		}
	}
	
	public static int checkSize(int size){
		int power=(int)Math.log(size);
		
		while(size>Math.pow(2, power)){
			power+=1;
		}
		size=(int)Math.pow(2, power);
		return size;
	}

}
