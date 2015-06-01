package tasks;

public class Task1 {

	public static void main(String[] args) {
		findPalindromes("wakaakaw");

	}
	
	public static void findPalindromes(String s){
		int count = 0;
		for(int i=0; i<s.length(); i++){
			String segment = rotate(s,i);
			if(isPalindrome(segment)){
				System.out.println(segment);
				count++;
			}
		}
		if(count==0){
			System.out.println("NONE");
		}
	}
	
	public static boolean isPalindrome(String s){
		if(s.length()==1){
			return true;
		}
		for(int i=0; i<s.length()/2; i++){
			if(s.charAt(i)!=s.charAt(s.length()-i-1)){
				return false;
			}
		}
		return true;
	}
	
	public static String rotate(String s, int index){
		return s.substring(index)+s.substring(0,index);
	}
}
