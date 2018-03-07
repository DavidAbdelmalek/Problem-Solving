import java.util.*;
import java.io.*;

public class TheatreSquare {
	public static void main(String[]args) throws NumberFormatException, IOException{
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int a = sc.nextInt();
		
		int max  = Math.max(n, m);
		int min  = Math.min(n, m);
		
		long count1=max/a;
		if(max%a!=0)count1++;
		
		long count2=0;
	
		min-=a;
		if(min>0){
		count2=min/a;
		if(min%a!=0)count2++;
		
		count2*=count1;
		}
	System.out.println(count2+count1);
	}
}
