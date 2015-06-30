package week3;

import java.util.*;

public class Median {
	public static List<Integer> list;
	
	public static void main(String[] args) {
		list = new ArrayList<Integer>();
		System.out.println("insert 5: " + insert(5));
		System.out.println("insert 6: " + insert(6));
		System.out.println("insert 7: " + insert(7));
		System.out.println("insert 4: " + insert(4));
		System.out.println("insert 3: " + insert(3));
		System.out.println("insert 10: " + insert(10));
		System.out.println("insert 20: " + insert(20));
		System.out.println("insert 30: " + insert(30));
		System.out.println("insert 40: " + insert(40));
		System.out.println("insert 50: " + insert(50));
	}
	
	public static int insert(int number){ //O(n)
		int i=list.size();
		while(i>0&&list.get(i-1)>number){ //O(n)
			i--;
		}
		
		list.add(i,number);
		return list.get(list.size()/2);
	}

}
