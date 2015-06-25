package week2;

import java.util.*;

public class PhoneBook {
	
	
	public static void main(String[] args) {
		List<Contact> phoneBook = new ArrayList<Contact>();
		Contact a = new Contact();
		a.name="Alexander";
		a.number=10;
		Contact b = new Contact();
		b.name="Veselina";
		b.number=15;
		phoneBook.add(a);
		phoneBook.add(b);
		
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(10);
		numbers.add(1);
		numbers.add(15);
		
		System.out.print(lookupNames(phoneBook, numbers));
	}
	
	public static List<String> lookupNames(List<Contact> phoneBook, List<Integer> numbers) {
		List<String> names = new ArrayList<String>();
		Map<Integer, String> m = new HashMap<Integer, String>();
		
		for(int i=0; i<phoneBook.size(); i++){
			m.put(phoneBook.get(i).number, phoneBook.get(i).name);
		}
		
		for(int i=0; i<numbers.size(); i++){
			if(m.get(numbers.get(i))!=null){
				names.add(m.get(numbers.get(i)));
			}
		}
		
		return names;  
    }
	
	public static class Contact{
	   
		public String name;
	    public int number;
	    
	}
	
}
