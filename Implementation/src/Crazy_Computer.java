import java.io.*;
import java.util.*;


public class Crazy_Computer {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), c = sc.nextInt(), out=0, prev=sc.nextInt();
		out++;
		for(int i = 1,num;i<n;i++) {
			num=sc.nextInt();
			if(num-prev<=c)out++;
			else out=1;
			prev=num;
		}
		System.out.println(out);
	}
}
