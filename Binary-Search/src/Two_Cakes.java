import java.io.*;
import java.util.*;

public class Two_Cakes {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(), b=sc.nextInt();
		int n = sc.nextInt();
		
	}
	
	static int BS() {
		int st =1,end = 100, mid =0;
		
		while(st<=end) {
			mid = (st+end)/2;
			if(valid(mid))st=mid+1;
			else end=mid-1;
	
		}
	}
	static int valid(int x) {
		
	}
}
