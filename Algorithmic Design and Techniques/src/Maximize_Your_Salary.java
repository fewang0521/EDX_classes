import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import jdk.internal.org.objectweb.asm.tree.InsnList;

import com.mysql.jdbc.StringUtils;


public class Maximize_Your_Salary {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		ArrayList<Integer> input_arry=new ArrayList();
		Scanner scanner = new Scanner(new FileInputStream("C:/Users/fewan/OneDrive/����/GitHub/EDX_classes/3_6_largest_number.in"));
		scanner.nextInt();
		while (scanner.hasNext()){
			input_arry.add(scanner.nextInt());
		}
		Collections.sort(input_arry);
		Max_mize_order_array(input_arry);

	}
	static void Max_mize_order_array(ArrayList<Integer> input_arry){
		int size_arr=input_arry.size();
		ArrayList<Integer> refined_input_arry=new ArrayList();
		ArrayList<Integer> result_arry=new ArrayList();
		
		for (int i=0;i<size_arr;i++){
			if (input_arry.get(i)<10){
				refined_input_arry.add(100*input_arry.get(i)+10*input_arry.get(i)+input_arry.get(i));
			}
			else if(input_arry.get(i)<100){
				refined_input_arry.add(10*input_arry.get(i)+input_arry.get(i)%10);
			}
			else {
				refined_input_arry.add(input_arry.get(i));
			}
			
		}
		while (!input_arry.isEmpty()){
			int size_refined_input=refined_input_arry.size();
			int MaxDigit=Integer.MIN_VALUE;
			int MaxDigit_index=0;
			for (int i=0;i<size_refined_input;i++){
				if (refined_input_arry.get(i)>MaxDigit){
					MaxDigit=refined_input_arry.get(i);
					MaxDigit_index=i;
				}
				
			}
			result_arry.add(input_arry.get(MaxDigit_index));
			input_arry.remove(input_arry.get(MaxDigit_index));
			refined_input_arry.remove(refined_input_arry.get(MaxDigit_index));
		}
		//System.out.println(result_arry);
		StringBuilder strbul1 = new StringBuilder();
		for (int i=0;i<result_arry.size();i++){
			strbul1.append(result_arry.get(i));
		}
		strbul1.toString();
		System.out.println(strbul1);

		return ;
	}

}
