package week3;

import java.util.*;

public class BandwidthManager { 
	public static TreeMap<Integer, String> router; //could have used priority queue, but a class Protocol is needed to store payload and priority

	public static enum Packages{
		ICMP(1), UDP(2), RTM(3), IGMP(4), //enum to store protocols' priorities
		DNS(5), TCP(6);

		int priority;
		
		Packages(int i){
			priority = i;
		}
		
		public int value(){
			return priority;
		}
	}
	
	public static void main(String[] args) {
		router = new TreeMap<Integer, String>();
		
		rcv("UDP", "udp.....");
		rcv("TCP", "tcp.....");
		rcv("ICMP", "imcp....");
		
		System.out.println(send());
		System.out.println(send());
		
		rcv("DNS", "dns ....");
		System.out.println(send());

		System.out.println(router);
	}
	
	public static void rcv(String protocol, String payload){ //O(n)
		router.put(Packages.valueOf(protocol).value(), payload);
	}
	  
	public static String send(){ //O(1)
		String payload = router.get(router.firstKey());
		router.remove(router.firstKey());
		return payload;
	}

}
