
public class Get_numb_of_changes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input_coins={1,2,5};
		int input_money=5;
		System.out.println(get_change(input_money,input_coins));
		
		
	}
	
	public static int get_change(int money, int[] coins){
		if (coins.length==1){
			if (money%coins[0]==0){
			return 1;
			}
			else {
				return 0;
			}
		}
		int[] new_coins=new int[coins.length-1];
		for (int i=1;i<coins.length;i++){
			new_coins[i-1]=coins[i];
		}
		int total_result=0;
		int quotient =money/coins[0];
		int num_of_for;
		num_of_for=quotient;
		
		for (int i=0;i<quotient+1;i++){
			total_result=total_result+get_change(money-i*coins[0],new_coins);
		}
		
		return total_result;
		
	}

}
