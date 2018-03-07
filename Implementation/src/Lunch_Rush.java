import java.util.Arrays;
import java.util.Scanner;

public class Lunch_Rush {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int n  =sc.nextInt();
		int k = sc.nextInt();
		long count=0;
		
		int [] arr =new int[n];
		
		for(int i = 0,fi,ti; i < n ;i++) {
			fi = sc.nextInt();
			ti = sc.nextInt();
			if(ti>k) 
				arr[i]=fi-(ti-k);
			else
				arr[i]=fi;	
		}
		Arrays.sort(arr);
		System.out.println(arr[n-1]);
	}
	
}
