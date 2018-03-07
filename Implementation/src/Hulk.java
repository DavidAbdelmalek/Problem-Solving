import java.io.*;
import java.util.Scanner;
public class Hulk {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int n  =sc.nextInt();
		StringBuilder sb  = new StringBuilder("");
		
		for(int i = 1 ; i<=n ; i++) {
				if((i&1)==0)sb.append("I love ");
				else sb.append("I hate ");
				if(i!=n)sb.append("that ");
		}
		
		sb.append("it");
		System.out.println(sb);
	}
}
