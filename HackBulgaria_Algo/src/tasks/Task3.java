package tasks;

import java.util.*;

public class Task3 {
	public static int sum=0;
	public static void main(String[] args) {
		List<Character> l = new ArrayList<Character>();
		
		if(!checkNumbers(l,"{125[12(123)]125}")){
			System.out.println("NO");
		}else{
			System.out.println("Result: "+sum);
		}
		
	}
	
	public static boolean checkNumbers(List<Character> l, String s){
		int factor=1; //multiply decimal by 1/10/100...
		int sum1=0; //sum between ()
		int sum2=0; //sum between []
		for(int i=s.length()-1; i>=0; i--){
			char c=s.charAt(i);
			if(c=='}'||c==']'||c==')'){ 
				if(!addBracket(l, c)){ //check if adding a bracket to the stack fails
					return false;
				}
				factor=1;
				if(c==')'){
					sum1=0;
				}if(c==']'){
					sum2=0;
				}
				
				factor=1;
			}else if(c=='{'||c=='['||c=='('){ 
				if(c=='('){
					if(l.contains(']')){
						sum1*=2;
						sum2+=sum1;
						sum1=0;
						factor=1;
					}else{
						sum+=sum1;
					}
				}
				if(c=='['){
					if(l.contains('}')){
						sum2*=2;
						sum+=sum2;
						sum2=0;
						factor=1;
					}else{
						sum+=sum2;
					}
				}
				if(!removeBracket(l, c)){ //check if removing a bracket from the stack fails
					return false;
				}
				if(l.isEmpty()&&i>0){ //if the stack is empty 
					return false;
				}
			}else{
				if(l.get(l.size()-1)==')'){
					sum1+=((int)c-(int)'0')*factor; //convert to int
					factor*=10;
				}if(l.get(l.size()-1)==']'){
					sum2+=((int)c-(int)'0')*factor;
					factor*=10;
				}if(l.get(l.size()-1)=='}'){
					sum+=((int)c-(int)'0')*factor;
					factor*=10;
				}
			}
		}
		return true;
	}
	
	public static boolean addBracket(List<Character>l, char c){
		if(c=='}'){
			if(!l.contains('}')&&!l.contains(')')&&!l.contains(']')){
				l.add(c);
			}else{
				return false;
			}
		}if(c==']'){
			if(!l.contains(']')&&!l.contains(')')){
				l.add(c);
			}else{
				return false;
			}
		}if(c==')'){
			if(!l.contains(')')&&!l.contains(']')&&l.contains('}')){
				return false;
			}
			else if(!l.contains(')')){
				l.add(c);
			}else{
				return false;
			}
		}

		return true;
	}
	
	public static boolean removeBracket(List<Character>l, char c){
		if(c=='{'){
			if(l.size()>0&&l.get(l.size()-1)=='}'){
				l.remove(l.size()-1);
			}else{
				return false;
			}
		}if(c=='['){
			if(l.size()>0&&l.get(l.size()-1)==']'){
				l.remove(l.size()-1);
			}else{
				return false;
			}
		}if(c=='('){
			if(l.size()>0&&l.get(l.size()-1)==')'){
				l.remove(l.size()-1);
			}else{
				return false;
			}
		}

		return true;
	}
	
}	
