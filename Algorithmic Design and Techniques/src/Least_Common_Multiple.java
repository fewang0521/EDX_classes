import java.util.*;

public class Least_Common_Multiple {
	private static long lcm_naive(int a, int b) {
		
		int GCD_a_b=GCD(a,b);
		long quot_a=a/GCD_a_b;
		long quot_b=b/GCD_a_b;
		
		return (long) quot_a * quot_b*GCD_a_b;
	}
	public static int GCD(int a, int b){
		int big;
		int small;
		if (a>b){
			big=a;
			small=b;
		}
		else{
			big=b;
			small=a;
		}
		int remain=big%small;
		if (remain==0){
			return small;
		}
		return GCD(b,remain);
	}

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();

		System.out.println(lcm_naive(a, b));
	}
}