import java.util.*;
import java.io.*;

public class EvenOdds {
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		long total = sc.nextLong();
		long num = sc.nextLong();
		long odd;
		if(total%2==0)
			odd=total/2;
		else
			odd=total/2+1;
		if(num<=odd)
			System.out.println((num-1)*2+1);
		else
			System.out.println((num-odd)*2);
		
	}
}