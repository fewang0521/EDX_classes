import java.util.ArrayList;


public class Maximum_number_of_prize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> Prize_arr = new ArrayList();
		int input=182414564;
		cal_prize(0,input,Prize_arr);
		System.out.println(Prize_arr);
		System.out.println(Prize_arr.size());

	}
	static void cal_prize(int last, int remain, ArrayList<Integer> Prize_list){
		while (remain -(last +1)>last){
			Prize_list.add(last+1);
			remain = remain -(last+1);
			last= last+1;
		}
		Prize_list.add(remain);
		return ;
		
		/* Due to stack over flow denied way
		if ((remain -(last +1))<=last){
			Prize_list.add(remain);
			return ;
		}
		Prize_list.add(last+1);
		remain = remain -(last+1);
		cal_prize(last+1, remain, Prize_list);
		return ;*/
	}

}