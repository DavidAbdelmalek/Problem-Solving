import java.io.*;
import java.util.*;

public class Currency_System_In_Geraldion {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int n  =sc.nextInt();
		for(int i = 0 ; i < n ; i++) {
			if(sc.nextInt()==1) {
				System.out.println(-1);
				return;
			}
		}
		System.out.println(1);
	}
}
