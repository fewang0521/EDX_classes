import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Binary_Search {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner file_input = new Scanner(new FileInputStream("C:/Users/fewan/OneDrive/¹®¼­/GitHub/EDX_classes/4_1_binary_search.in"));
		Scanner Line_input= new Scanner(file_input.nextLine());
		int n_a = Line_input.nextInt();
		int[] input_a=new int[n_a];
		int index=0;
		while (Line_input.hasNext()){
			input_a[index]=Line_input.nextInt();
			index=index+1;
		}
		Line_input=new Scanner(file_input.nextLine());
		int n_b=Line_input.nextInt();
		int[] input_b=new int[n_b];
		index=0;
		while (Line_input.hasNext()){
			input_b[index]=Line_input.nextInt();
			index=index+1;
		}
		int[] result_search=new int[n_b];
		int result_n=0;
		for (int i=0;i<n_b;i++){
			result_search[i]=binary_search(input_b[i],input_a,0,input_a.length-1);
			if (result_search[i]!=-1){
				result_n=result_n+1;
			}
		
		}
		System.out.println(result_n);
		


	}
	static int binary_search(int key, int[] input, int low, int high){
		int low_point=low;
		int high_point = high;
		int middle_index=Math.round(((low_point+high_point)/2));
		//when high-low=1 
		if (high_point-low_point==1){
			if (input[high_point]==key){
				return high_point;
			}
			else if (input[low_point]==key){
				return low_point;
			}
			else{
				return -1;
			}
		}
		
		if (input[middle_index]==key){
			return middle_index;
		}
		else if(input[middle_index]<key){
			low_point=middle_index;
			return binary_search(key,input,low_point,high_point);
		}
		else {
			high_point=middle_index;
			return binary_search(key,input,low_point,high_point);
		}	

		
	}

}
