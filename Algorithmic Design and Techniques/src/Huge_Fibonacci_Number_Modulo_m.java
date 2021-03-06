
import java.util.*;

public class Huge_Fibonacci_Number_Modulo_m  {
	private static long getFibonacciHugeNaive(long n, long m) {
		if (n <= 1)
			return n;

		long previous = 0;
		long current  = 1;
		int flag_zero=0;
		int flag_one=0;
		long flag_zero_count=0;
		long flag_one_count=0;
		long one=1;
		List<Long> ints= new ArrayList<Long>();
		ints.add((long) 0);
		ints.add((long) 1);

		for (long i = 0; i < n - 1; ++i) {
			if (flag_zero==1 & flag_one==1){
				if (flag_one_count-flag_zero_count==1){
					break;
				}
				else if (flag_one_count-flag_zero_count==-1){
					flag_one=0;
				}
				else{
					flag_zero=0;
					flag_one=0;
				}
			}

			long tmp_previous = previous;
			previous = current;
			current = tmp_previous + current;
			ints.add(current%m);
			if (current%m==0){
				flag_zero=1;
				flag_zero_count=i;
			}
			else if (current%m==1){
				flag_one=1;
				flag_one_count=i;
			}
			current=current%m;


		}
		if (n<m){
			return ints.get(ints.size()-1);
		}
		
		long last_index=ints.size()-2;
		long remain=n%last_index;
		System.out.println(ints);
		return ints.get((int) remain);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextLong();
		long m = scanner.nextLong();
		System.out.println(getFibonacciHugeNaive(n, m));
	}
}


