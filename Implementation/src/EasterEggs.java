import java.util.Scanner;


public class EasterEggs {
	public static void main(String[]args){
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();

		char[] s = new char[n];
		String c = "ROYGBIV";
		
		for(int i = 0, k = 0; i < n; ++i, k = (k + 1)%7)
		{
			if(n - i <= 3 && k < 3) k = 3;
			s[i] = c.charAt(k);
		}
		for(int i = 0; i < n ;i++)System.out.print(s[i]+"");
	}
}
