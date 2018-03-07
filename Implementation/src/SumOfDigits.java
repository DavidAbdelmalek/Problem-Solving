import java.util.*;
import java.io.*;

public class SumOfDigits {
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		String n = sc.nextLine();
		int count = 0;
		while(n.length() > 1) {
			int sum = 0;
			for(int i = 0; i < n.length(); i++)
				sum += n.charAt(i)-'0';
			n = sum + "";
			count++;
		}
		System.out.println(count);
	}
}
