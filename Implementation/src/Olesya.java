import java.util.Scanner;


public class Olesya {
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String t =""+ sc.nextInt();

		if(n<t.length())System.out.println(-1);
		else if(n==t.length())System.out.println(t);
		else {
			n-=t.length();
			for(int i = 0 ;i< n ;i++)t+=0;
			System.out.println(t);
		}
	}
}
