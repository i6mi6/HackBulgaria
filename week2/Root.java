package week2;

public class Root {

	public static void main(String[] args) {
		System.out.println(findRoot(9));
	}

	public static float findRoot(int n){
		float low = 0;
		float high = n;
		while(high-low>0.00001){
			float mid = (low+high)/2;
			if(mid*mid<=n){
				low=mid;
			}else{
				high=mid;
			}
		}
		return low+0.00001f;
	}
}
