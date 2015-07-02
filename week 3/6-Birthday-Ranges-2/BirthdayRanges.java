package week3;

import binary.IndexedTree;

public class BirthdayRanges {
	public static IndexedTree birthdays;
	public static void main(String[] args) {
		int[] bds = new int[366];
		
		bds[0]=2;
		bds[1]=1;
		bds[3]=4;
		birthdays = new IndexedTree(bds);
		
		System.out.println(count(0,365));
	}
	
	public static void add(int day, int numberOfPeople) {
		birthdays.elements[birthdays.elements.length/2+day]+=numberOfPeople;
	}

	public static void remove(int day, int numberOfPeople) {

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







