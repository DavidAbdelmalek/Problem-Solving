import java.util.Scanner;

public class Blackjack {
	public static void main(String[]arg) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int diff = n-10;
		
		if(diff==0)
			System.out.println(0);
		else
			if(diff==10)
				System.out.println(15);
			else
				if(diff>=1&&diff<=9||diff==11)
					System.out.println(4);
				else System.out.println(0);
				
	}
}
