import java.io.*;
import java.util.*;

public class Vasya_The_Hipster {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int b = sc.nextInt();
		StringBuilder sb  = new StringBuilder("");
		sb.append(Math.min(r, b) + " ");
		int min = Math.min(r, b);
		r-=min;
		b-=min;
		
		if(r>0)sb.append(r/2);
		else if(b>0)sb.append(b/2);
		else sb.append(0);
		System.out.println(sb);
	}
}
