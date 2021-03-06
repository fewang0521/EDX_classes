import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;


public class Maximum_Value_of_the_Loot {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		//input and set arryas
		Scanner scanner = new Scanner(new FileInputStream("C:/Users/fewan/OneDrive/����/GitHub/EDX_classes/3_2_loot.in"));
		int n =scanner.nextInt();
		int W = scanner.nextInt();
		ArrayList<Integer> item_v= new ArrayList();
		ArrayList<Integer> item_w= new ArrayList();
		while (scanner.hasNext()){
			item_v.add(scanner.nextInt());
			item_w.add(scanner.nextInt());
		}
		
		ArrayList<Float> frac_value= new ArrayList();
		for (int i=0;i<n;i++){
			frac_value.add(((float) item_v.get(i)/(float) item_w.get(i)));
		}
		ArrayList<Float> frac_value_sorted= new ArrayList();
		frac_value_sorted=(ArrayList<Float>) frac_value.clone();
		Collections.sort(frac_value_sorted);
		Collections.reverse(frac_value_sorted);
		
		//Sort input array
		ArrayList<Integer> item_v_sorted= new ArrayList();
		ArrayList<Integer> item_w_sorted= new ArrayList();
		for (int i=0;i<n;i++){
			item_v_sorted.add(item_v.get(frac_value.indexOf(frac_value_sorted.get(i))));
			item_w_sorted.add(item_w.get(frac_value.indexOf(frac_value_sorted.get(i))));
		}
		System.out.print(Max_value_of_loot(item_v_sorted, item_w_sorted,W));

	}
	static int Max_value_of_loot(ArrayList<Integer> item_v_sorted, ArrayList<Integer> item_w_sorted, int W){
		if (W<item_w_sorted.get(0)){
			return (int) (item_v_sorted.get(0)*((float)W/item_w_sorted.get(0)));
		}
		int value_extracted=item_v_sorted.get(0);
		int w_extracted=item_w_sorted.get(0);		
				
		item_v_sorted.remove(0);
		item_w_sorted.remove(0);
		
		return value_extracted + Max_value_of_loot(item_v_sorted,item_w_sorted,W-w_extracted); 


	}

}
