package week3;

import java.util.*;
import binary.IndexedTree;

public class BirthdayRanges {
	public static IndexedTree birthdays;
	public static List<Integer> list;
	
	public static void main(String[] args) {
		list = new ArrayList<Integer>();
		list.add(5);
		list.add(10);
		list.add(6);
		list.add(7);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(11);
		list.add(21);
		list.add(300);
		list.add(15);

		birthdays = new IndexedTree(convert(list)); 
		
		add(8, 3);
		remove(8, 2);
		
		//birthdays.print();
		
		System.out.println(count(7,11));

	}
	
	public static int[] convert(List<Integer> list){ //we pass an array to the index tree (where index of array = day, value = number of people who have 
		int[] bds = new int[366];					//a birthday on that day)
		for(int i=0; i<list.size(); i++){
			bds[list.get(i)]++;
		}
		return bds;
	}
	
	public static void add(int day, int numberOfPeople) { //O(lgn)
		birthdays.updateTree(day+birthdays.elements.length/2, numberOfPeople);
	}

	public static void remove(int day, int numberOfPeople) {
		if(birthdays.elements[day+birthdays.elements.length/2]-numberOfPeople<0){
			birthdays.updateTree(day+birthdays.elements.length/2, 0);
		}else{
			numberOfPeople=birthdays.elements[day+birthdays.elements.length/2]-numberOfPeople;
			birthdays.updateTree(day+birthdays.elements.length/2, numberOfPeople);
		}
	}

	public static int count(int startDay, int endDay) {
		return calc(startDay+birthdays.elements.length/2, endDay+birthdays.elements.length/2); //convert start and end to
	}																							    // start and end in the last level of the heap
	
	public static int calc(int start, int end){
		if(start>end){
			return 0;
		}
		if(start==end){
			return birthdays.elements[start];
		}
		
		int sum=0;
		if(start%2==0){
			sum+=birthdays.elements[start];
			start++;
		}
		if(end%2!=0){
			sum+=birthdays.elements[end];
			end--;
		}
		sum+=getSum(start,end);
		return sum;
	}
	
	public static int getSum(int start, int end){
		if(end<start){
			return 0;
		}
		int leftParent = (start-1)/2;
		int rightParent = (end-1)/2;
		int levels = (int) Math.log(end-start+1);
		int i=1;

		while(i<=levels&&leftParent!=rightParent){ //O(lgn)
			leftParent=(leftParent-1)/2;
			rightParent=(rightParent-1)/2;
			i++;
		}
		
		if(leftParent!=rightParent){
			int mid = (start+end)/2;
			return calc(start, mid)+calc(mid+1, end); //O(lg^2n)
		}
		
		return birthdays.elements[rightParent];
	}
	
}







