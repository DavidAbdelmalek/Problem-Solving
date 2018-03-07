import java.*;
import java.util.*;

public class CaisaAndPylons {
	public static void main(String[]args){
		Scanner sc= new Scanner(System.in);

		int n = sc.nextInt();
		int [] arr = new int[n];
		for(int i = 0; i < n ; i++)arr[i]=sc.nextInt();

		int count1=arr[0];
		int energy=0;
		for(int i = 0,diff;i<n-1;i++){
			diff=arr[i+1]-arr[i];
			if(diff>0){
				if(energy>=diff)energy-=diff;
				else {
					count1+=(diff-energy);
					energy=0;
				}
			}
			else energy+=Math.abs(diff);
		}
		System.out.println(count1);
	}
}
