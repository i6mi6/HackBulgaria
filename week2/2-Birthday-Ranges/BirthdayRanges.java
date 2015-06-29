package week2;

import java.util.*;

public class BirthdayRanges {
	  public static class Pair {
	    public int start;
	    public int end;
	    
	    public Pair(int s, int e){
	    	start=s;
	    	end=e;
	    }
	    
	  }
	  
	  public static void main(String[] args) {
			int[] a={5, 10, 6, 7, 3, 4, 5, 11, 21, 300, 15};
			List<Integer> br = new ArrayList<Integer>();
			
			for(int i=0; i<a.length; i++){
				br.add(a[i]);
			}
			
			List<Pair> ranges = new ArrayList<Pair>();
			ranges.add(new Pair(4,9));
			ranges.add(new Pair(6,7));
			ranges.add(new Pair(200,225));
			ranges.add(new Pair(300,365));
			
			List<Integer> result = birthdaysCount(br, ranges);
			
			for(int i=0; i<result.size(); i++){
				System.out.print(result.get(i)+" ");
			}
		}
	  
	  public static List<Integer> birthdaysCount(List<Integer> birthdays, List<Pair> ranges) { //O(n+k)=O(n)
		  int[] days = new int[366];
		  
		  for(int i=0; i<birthdays.size(); i++){ //O(n)
			  days[birthdays.get(i)]++;
		  }
		  List<Integer> result = new ArrayList<Integer>();
		  
		  for(int i=0; i<ranges.size(); i++){ //O(k)
			  result.add(0);
		  }
		  
		  for(int i=0; i<ranges.size(); i++){ //O(k)
			  for(int j=ranges.get(i).start; j<=ranges.get(i).end; j++){ //~constant (max 365)
				  result.set(i,  result.get(i)+days[j]);
			  }
		  }
		  
		  return result;
	  }
	}
