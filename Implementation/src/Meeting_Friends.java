import java.util.Scanner;

public class Meeting_Friends {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int f1 = sc.nextInt();
		int f2 = sc.nextInt();
		int f3 = sc.nextInt();
		
		int st = Math.min(f1, Math.min(f2, f3));
		int end = Math.max(f1, Math.max(f2, f3));
		
		int min=Integer.MAX_VALUE-1;
		for(int i = st ; i<=end ; i++) 
			min = Math.min(Math.abs(f1-i)+Math.abs(f2-i)+Math.abs(f3-i),min);
		
		
		System.out.println(min);
	}
}
