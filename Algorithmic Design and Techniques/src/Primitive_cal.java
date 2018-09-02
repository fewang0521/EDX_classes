import java.util.ArrayList;
import java.util.Collections;


public class Primitive_cal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		ArrayList DP_result=DP_min_operation(98734);
		ArrayList result_arry=step_to_primitive_cal(98734,DP_result);
		System.out.println(result_arry);
		System.out.println(result_arry.size());

	}
	static ArrayList<Integer> step_to_primitive_cal(int input, ArrayList<Integer> DP_arry){
		int int_after_cal=input;
		int min_val_start=DP_arry.get(input);
		ArrayList<Integer> result_arry=new ArrayList();
		result_arry.add(input);
		while (!(int_after_cal==1)){
			if (DP_arry.get(int_after_cal-1)==min_val_start-1){
				int_after_cal-=1;
				min_val_start-=1;
				result_arry.add(int_after_cal);
			}
			else if(int_after_cal%2==0 && DP_arry.get(int_after_cal/3)==min_val_start-1){
				int_after_cal=int_after_cal/2;
				min_val_start-=1;
				result_arry.add(int_after_cal);
			}
			else{
				int_after_cal=int_after_cal/3;
				min_val_start-=1;
				result_arry.add(int_after_cal);
			}
		}
		Collections.reverse(result_arry);
		return result_arry;	
		
	}
	static ArrayList DP_min_operation(int input_integer){
	//multiply by 2 and 3, and add 1 to x.
		ArrayList<Integer> DP_min_cal_arry=new ArrayList();
		int index_n_cal_done=2;
		DP_min_cal_arry.add(0);
		DP_min_cal_arry.add(0);
		int [] val_DP_min=new int[3];
		
		if(input_integer<2){
			return DP_min_cal_arry;
			
		}
		
		while (index_n_cal_done<=input_integer){
			val_DP_min[0]=Integer.MAX_VALUE;
			val_DP_min[1]=Integer.MAX_VALUE;
			val_DP_min[2]=Integer.MAX_VALUE;
			
			if (index_n_cal_done-1>=0){
				val_DP_min[0]=DP_min_cal_arry.get(index_n_cal_done-1);
				val_DP_min[0]+=1;
			}
			if((index_n_cal_done/2>=1)&&(index_n_cal_done%2==0)){
				val_DP_min[1]=DP_min_cal_arry.get(index_n_cal_done/2);
				val_DP_min[1]+=1;
			}
			if((index_n_cal_done/3>=1)&&(index_n_cal_done%3==0)){
				val_DP_min[2]=DP_min_cal_arry.get(index_n_cal_done/3);
				val_DP_min[2]+=1;
			}
			int result_min_val=Integer.MAX_VALUE;
			for (int i=0;i<3;i++){
				if (result_min_val>val_DP_min[i]){
					result_min_val=val_DP_min[i];
				}
								
			}
			DP_min_cal_arry.add(result_min_val);			
			index_n_cal_done+=1;
		}
		
		return DP_min_cal_arry;
	}

}
