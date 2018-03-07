import java.util.Scanner;

public class Vanya_And_Fence {
	public static void main(String[]args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int h = sc.nextInt();
		long out=0;
		for(int i = 0;i<n;i++) {
			if(sc.nextInt()>h)out+=2;
			else out++;
		}
		System.out.println(out);
	}
}
