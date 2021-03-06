import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Max_revenue_ad {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(new FileInputStream("C:/Users/fewan/OneDrive/����/GitHub/EDX_classes/3_3_dot_product20180216.in"));
		
		int num_ad=0;
		ArrayList<Integer> profit_per_click =new ArrayList();
		ArrayList<Integer> Ave_click_per_day =new ArrayList();
		Scanner input_row=new Scanner(input.nextLine());
		num_ad=input_row.nextInt();
		input_row=new Scanner(input.nextLine());
		while (input_row.hasNext()){
			profit_per_click.add(input_row.nextInt());
		}
		input_row=new Scanner(input.nextLine());
		while (input_row.hasNext()){
			Ave_click_per_day.add(input_row.nextInt());
		}
		Collections.sort(profit_per_click);
		Collections.reverse(profit_per_click);
		Collections.sort(Ave_click_per_day);
		Collections.reverse(Ave_click_per_day);
		
		System.out.println(cal_max(profit_per_click, Ave_click_per_day,num_ad));
	
		

	}
	static float cal_max(ArrayList<Integer> profit_arr, ArrayList<Integer> Ave_cli_arr, int num){
		if (num==0){
			return 0;
		}
		
		float product_profit_click=0;
		product_profit_click=(float) profit_arr.get(0)*(float) Ave_cli_arr.get(0);
		profit_arr.remove(0);
		Ave_cli_arr.remove(0);
		
		return product_profit_click+cal_max(profit_arr,Ave_cli_arr, num-1);
	}

}
