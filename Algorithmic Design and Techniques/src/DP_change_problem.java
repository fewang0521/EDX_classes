import java.util.ArrayList;


public class DP_change_problem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> DP_change=new ArrayList();

		int size=950;
		int n=1;
		DP_change.add(0);
		while (n<=size){
			int[] min = {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE};
			int min_result=Integer.MAX_VALUE;
			
			if (n-1>=0){
				min[0]=DP_change.get(n-1);
				min[0]+=1;
			}
			if (n-3>=0){
				min[1]=DP_change.get(n-3);
				min[1]+=1;
			}
			if (n-4>=0){
				min[2]=DP_change.get(n-4);
				min[2]+=1;
			}
			for (int i=0;i<3;i++){
				if (min_result>=min[i]){
					min_result=min[i];
				}
			}
			DP_change.add(min_result);
			n+=1;
			
		}
		
		System.out.println(DP_change.get(size));

	}

}
