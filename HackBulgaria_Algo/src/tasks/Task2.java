package tasks;

public class Task2 {

	public static void main(String[] args) {
		String s = "o?uin uw?stutnfwat?~413~orwa? thfuisnnrsiu";		
		decrypt(s);
	}
	
	public static void decrypt(String s){
		s=s.substring(s.length()/2)+s.substring(0,s.length()/2); //bring back halves
		
		
		int aLength=0; //get alphabet length
		int factor=1;
		int index1=0;
		for(index1=0; s.charAt(index1)!='~'; index1++){
			aLength=aLength*factor+((int)s.charAt(index1)-(int)'0');
			factor*=10;
		}
		
		String alphabet=""; //get alphabet
		int index2=index1+aLength+1;
		for(int i=index1+1; i<=index1+aLength; i++){ 
			alphabet+=s.charAt(i);
		}
		
		int kLength=0; //get key length
		factor=1;
		int index3=0;
		for(int i=s.length()-1; s.charAt(i)!='~'; i--, index3=i){
			kLength+=((int)s.charAt(i)-(int)'0')*factor;
			factor*=10;
		}
		index3-=kLength;
		
		String key="";
		for(int k=index3; s.charAt(k)!='~'; k++){
			key+=s.charAt(k);
		}
		
		String message=""; //get message
		for(int j=index2;j<index3; j++){
			message+=s.charAt(j);
		}
		
		
		String repeatedKey=key; //get reapeated key with alphabet length
		while(repeatedKey.length()<=message.length()){
			repeatedKey+=repeatedKey;
		}
		
		repeatedKey = repeatedKey.substring(0,message.length());
		
		String result="";
		for(int i=0; i<repeatedKey.length(); i++){
			result+=alphabet.charAt((aLength+alphabet.indexOf(message.charAt(i))-alphabet.indexOf(repeatedKey.charAt(i)))%aLength);
		}
				
		/*System.out.println(message);
		System.out.println(aLength);
		System.out.println(kLength);
		System.out.println(alphabet);
		System.out.println(repeatedKey);
		System.out.println(key);*/
		
		System.out.println(result);
	}
}
