import java.util.Hashtable;


public class Max_value_of_arith_exp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static int[] MaxandMin(int a, int b){
		Hashtable<String, Integer> Max=new Hashtable<String, Integer>();
		Hashtable<String, Integer> Min=new Hashtable<String, Integer>();
		String str_a= Integer.toString(a);
		String str_b= Integer.toString(b);
		int[] result_int = new int[2];
		
		if (Max.contains(str_a+","+str_b)==true){
			result_int[0]=Min.get(str_a+","+str_b);
			result_int[1]=Min.get(str_a+","+str_b);
			return result_int;
		}
		
		
		return ;
		
	}

}
