import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Majority_Element {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> input=new ArrayList<Integer>();
		Scanner input_sc=new Scanner(new FileInputStream("C:/Users/fewan/OneDrive/����/GitHub/EDX_classes/4_2_majority_element.in"));
		input_sc.nextInt();
		while (input_sc.hasNext()){
			input.add(input_sc.nextInt());
		}

		
		Majority input_majority=new Majority(0, input);
		System.out.println(get_Majority(sep(input_majority).left,sep(input_majority).right).Majority_entity);
	}
	static Seperate_major sep(Majority input){
		float size=input.array.size();
		Majority left=new Majority(0,new ArrayList<Integer>());
		Majority right=new Majority(0,new ArrayList<Integer>());
		for (int i=0;i<Math.round(size/2);i++){
			left.array.add(input.array.get(i));
		}
		for (int i=Math.round(size/2);i<size;i++){
			right.array.add(input.array.get(i));
		}
		
		if (size<8){
			return new Seperate_major(check_majority_under_3(left),check_majority_under_3(right));
		}
		else{
			
			Seperate_major sep_left=sep(left);
			Seperate_major sep_right=sep(right);
			Majority left_new=get_Majority(sep_left.left,sep_left.right);
			Majority right_new=get_Majority(sep_right.left,sep_right.right);
			return new Seperate_major(left_new, right_new);
		}
	}
	
	static Majority check_majority_under_3(Majority input){
		int check=0;
		Integer index=null;
		Integer result_max=Integer.MIN_VALUE;
		Integer temp_max=Integer.MIN_VALUE;
		for (int i=0;i<input.array.size();i++){
			check=input.array.get(i);
			temp_max=0;
			for (int j=0;j<input.array.size();j++){
				if (check==input.array.get(j)){
					temp_max=temp_max+1;
				}
			}
			if (result_max<=temp_max){
				result_max=temp_max;
				index=input.array.get(i);
			}
		}
		if (result_max>=Math.round((float)(input.array.size())/2)){
			return new Majority(index,input.array);
		}
		return new Majority(0,input.array);
	}
	
	static Majority get_Majority(Majority left, Majority right){
		//recursive_limit_condition
		int left_maj_entity=left.Majority_entity;
		int right_maj_entity=right.Majority_entity;
		ArrayList<Integer> left_arry=left.array;
		ArrayList<Integer> right_arry=right.array;
		
		int result_maj_entity=0;
		ArrayList<Integer> result_arry=new ArrayList<Integer>();
		for (int i=0;i<left.array.size();i++){
			result_arry.add(left_arry.get(i));
		}
		for (int i=0;i<right.array.size();i++){
			result_arry.add(right_arry.get(i));
		}
		
		if (left_maj_entity==0 && right_maj_entity==0){
			result_maj_entity=0;
			return new Majority(result_maj_entity,result_arry);
		}
		else if(left_maj_entity==right_maj_entity){
			result_maj_entity=left_maj_entity;
			return new Majority(result_maj_entity,result_arry);
		}
		else{
			if (result_arry.size()/2<=count_n(left_maj_entity,result_arry)){
				result_maj_entity=left_maj_entity;
				return new Majority(result_maj_entity,result_arry);
			}
			if (result_arry.size()/2<=count_n(right_maj_entity,result_arry)){
				result_maj_entity=right_maj_entity;
				return new Majority(result_maj_entity,result_arry);
			}
			
			return new Majority(result_maj_entity,result_arry);
		}
		
	}
	static int count_n(int input, ArrayList<Integer> input_arr){
		int count=0;
		for (int i=0;i<input_arr.size();i++){
			if (input==input_arr.get(i)){
				count=count+1;
			}
		}
		
		return count;
	}
	
	
	

}
class Majority{
	int Majority_entity=0;
	ArrayList<Integer> array=new ArrayList();
	
	public Majority(int input_entity, ArrayList<Integer> input_arry){
		this.Majority_entity=input_entity;
		this.array=(ArrayList<Integer>) input_arry.clone();
	}
	
}
class Seperate_major{
	Majority left=new Majority(0, new ArrayList<Integer>());
	Majority right=new Majority(0, new ArrayList<Integer>());
	public Seperate_major(Majority left_m, Majority right_m){
		this.left=left_m;
		this.right=right_m;
	}
}

