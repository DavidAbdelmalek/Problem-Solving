import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class CalculatingFunc {
	public static void main(String[]args){
		
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		
		if(n%2!=0)System.out.println(-((n/2)+1));
		else System.out.println(n/2);
	}
}
