import java.util.*;

public class Least_Common_Multiple {
	private static long lcm_naive(int a, int b) {
		
		long GCD_a_b=GCD(a,b);
		
		return (long) a * b/GCD_a_b;
	}
	public static long GCD(long a, long b){
		long big;
		long small;
		if (a>b){
			big=a;
			small=b;
		}
		else{
			big=b;
			small=a;
		}
		long remain=big%small;
		if (remain==0){
			return small;
		}
		else if (remain==1){
			return 1;
		}
		return GCD(small,remain);
	}

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		System.out.println(lcm_naive(a, b));
	}
}
