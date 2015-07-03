package week3;

import binary.IndexedTree;

public class BirthdayRanges {
	public static IndexedTree birthdays;
	public static void main(String[] args) {
		int[] bds = new int[366];		//contains all days of the year (index - day, value - number of people who have birthdays on that day)
		bds[5]=2;  //2 people on day 5
		bds[10]=1;
		bds[6]=1;
		bds[7]=1; 
		bds[3]=1;
		bds[4]=1;
		bds[11]=1; //1 on day 11
		bds[21]=1;
		bds[300]=1; 
		bds[15]=1;

		birthdays = new IndexedTree(bds);
		add(8, 3);
		remove(8, 2);
		
		//birthdays.print();
		
		System.out.println(count(7,11));

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







