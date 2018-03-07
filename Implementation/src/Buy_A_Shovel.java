import java.util.Scanner;

public class Buy_A_Shovel {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int  k = sc.nextInt();
		int  r = sc.nextInt();

		if(r==k%10) {
			System.out.println(1);
			
			return;
		}
		long i =1 ;
		long temp=k;
		long rem=0;
		while(true) {
			temp=k*i;
			rem = temp%10;
			if(rem==r||rem==0) {
				System.out.println(i);
				return;
			}
			i++;
		}
	}
	
}
