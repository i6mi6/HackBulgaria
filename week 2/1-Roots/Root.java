package week2;

import java.util.Scanner;

public class Root {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.printf("%.5f", findRoot(s.nextInt()));
	}

	public static double findRoot(int n){
		double low = 0;
		double high = n;
		double mid = (high-low)/2;
		while(Math.abs(mid*mid-n)>0.00001){
			if(mid*mid<=n){
				low=mid;
				mid = low + (high-low)/2;
			}else{
				high=mid;
				mid = (high-low)/2;
			}
		}
		return mid;
	}
}
