import java.io.*;
import java.util.*;

public class Anton_And_Digits {
	public static void main(String[]args) {
		Scanner sc= new Scanner(System.in);
		int two =sc.nextInt(),three=sc.nextInt(),five=sc.nextInt(),six=sc.nextInt();
		int min = Math.min(two, Math.min(five, six));
		two-=min;int min2=Math.min(two, three);
		
		System.out.println(min*256+min2*32);
	}
}
