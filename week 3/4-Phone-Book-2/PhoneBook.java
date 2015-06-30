package week3;

import java.util.*;

public class PhoneBook {
	public static Map<String, Integer> phoneBook;
	 public static class Contact {
		 public String name;
		 public int number;
		 
		 public Contact(String name, int number){
			 this.name=name;
			 this.number=number;
		 }
	}
	
	public static void main(String[] args) {
		phoneBook = new TreeMap<String, Integer>();
		insert(new Contact("alexander",20));
		insert(new Contact("veselina",20));
		lookup("alexander");
		list();
		//remove("alexander");
	}

	public static void insert(Contact contact){ //O(n) (often O(1), depends on input and hashing)
		phoneBook.put(contact.name, contact.number);
	}

	public static void lookup(String name){ //O(1)
		 if(!phoneBook.containsKey(name)){
			 System.out.println(name+"'s number NOT FOUND!"); 
		 }else{
			 System.out.println(name+"'s number: "+phoneBook.get(name));
		 }
		
	}

	public static void list() {	//O(n)
		for(String key : phoneBook.keySet()){ 
			System.out.println(key+": "+phoneBook.get(key));
		}
	}

	public static void remove(String name) {	//O(n) (often O(1))
		  phoneBook.remove(name);
	}	

}
