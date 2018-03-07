import java.util.Scanner;

public class Gravity_Flip {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c[]= new int[n];
		
		for(int i = 0 ; i < n ; i++)c[i]=sc.nextInt();

		int trans =-1;
		
		while(trans!=0) {
			trans=0;
			for(int i = 0 ,diff; i < n-1 ; i++) {
				if(c[i]>c[i+1]) {
					diff=c[i]-c[i+1];
					c[i+1]+=diff;
					c[i]-=diff;
					trans++;
				}
			}
		}
		
		for(int i = 0 ; i < n ; i++)System.out.print(c[i]+" ");
	}
}
