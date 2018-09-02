import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Number_of_Inversion {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Merge input_left=new Merge(new ArrayList() ,0);
		Scanner input=new Scanner(new FileInputStream("C:/Users/fewan/OneDrive/¹®¼­/GitHub/EDX_classes/4_4_inversions.in"));
		input.nextInt();
		while (input.hasNext()){
			input_left.arry.add(input.nextInt());
		}
		
		Merge result=num_of_inversion(seperate_arry(input_left).left.arry,seperate_arry(input_left).right.arry,seperate_arry(input_left).left.number_of_inversion,seperate_arry(input_left).right.number_of_inversion);
		System.out.println(result.arry);
		System.out.println(result.number_of_inversion);
		/*ArrayList<Integer> input_right=new ArrayList();
		input_right.add(2);
		input_right.add(7);
		input_right.add(9);
		Merge merge_result=new Merge(null, 0);
		merge_result=num_of_inversion(input_left,input_right,0,0);

		System.out.println(merge_result.arry);
		Seperate result= new Seperate(null, null);
		result=seperate_arry(num_of_inversion(input_left,input_right,0,0).arry);
		System.out.println(result.Arry_left);
		System.out.println(result.Arry_right);*/

		
		
	}	
	
	static Seperate seperate_arry (Merge input){
		int size= input.arry.size();
		int middle_point=Math.round(size/2);
		
		Merge left= new Merge(new ArrayList(), 0);
		Merge right= new Merge(new ArrayList(), 0);
				
		if (size==2){
			left.arry.add(input.arry.get(0));
			right.arry.add(input.arry.get(1));
			return new Seperate(left, right);
		}
		else if(size==1){
			left.arry.add(input.arry.get(0));
			right.arry=null;
			return new Seperate(left, right);
		}
		else {
			for (int i=0;i<middle_point;i++){
				left.arry.add(input.arry.get(i));
			}
			for (int i=middle_point;i<size;i++){
				right.arry.add(input.arry.get(i));
			}
			
			Seperate s_a=seperate_arry(left);
			Seperate s_b=seperate_arry(right);
			Merge r_a=num_of_inversion(s_a.left.arry,s_a.right.arry,s_a.left.number_of_inversion,s_a.right.number_of_inversion);
			Merge r_b=num_of_inversion(s_b.left.arry,s_b.right.arry,s_b.left.number_of_inversion,s_b.right.number_of_inversion);
			return new Seperate(r_a,r_b);
		}
		
	}
	
	static Merge num_of_inversion(ArrayList<Integer> input_left,ArrayList<Integer> input_right, int inversion_left, int inversion_right){

		ArrayList<Integer> result_arry= new ArrayList();
		if (input_left==null){
			Merge result =new Merge(input_right, 0);
			return result;
		}
		else if(input_right==null){
			Merge result =new Merge(input_left, 0);
			return result;
		}
				

		int input_left_size=input_left.size();
		int input_right_size=input_right.size();
		int inversion_total=0;
		int index_left=0;
		int index_right=0;
		while (!(input_left_size==index_left&&input_right_size==index_right)){
			if(index_left==input_left_size||index_right==input_right_size){
				if (index_left==input_left_size){
					result_arry.add(input_right.get(index_right));
					index_right=index_right+1;
				}
				else if (index_right==input_right_size){
					result_arry.add(input_left.get(index_left));
					index_left=index_left+1;
				}
			}
			else{
				if (input_left.get(index_left)<=input_right.get(index_right)){
					result_arry.add(input_left.get(index_left));
					index_left=index_left+1;	
				}
				else {
					result_arry.add(input_right.get(index_right));
					index_right=index_right+1;
					inversion_total=inversion_total+(input_left_size-index_left);
					
				}
			}
		}
		inversion_total=inversion_total+inversion_left+inversion_right;

		Merge result =new Merge(result_arry, inversion_total);
		return result;
	}


}
class Merge{
	ArrayList<Integer> arry=new ArrayList();
	int number_of_inversion;

	public Merge(ArrayList<Integer> input, int num_inversion){
		this.arry=input;
		this.number_of_inversion=num_inversion;
	}
}

class Seperate{
	Merge left=new Merge(new ArrayList(), 0);
	Merge right=new Merge(new ArrayList(), 0);
	
	
	public Seperate(Merge left, Merge right){
		this.left=left;
		this.left.number_of_inversion=left.number_of_inversion;
		this.right=right;
		this.right.number_of_inversion=right.number_of_inversion;
	}
}