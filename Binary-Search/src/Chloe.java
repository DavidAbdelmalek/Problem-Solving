import java.io.*;
import java.util.*;
import javafx.scene.media.Track;

public class Chloe {
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		k--;
		long value=1;
		long tracker [] = new long[51];
		tracker[1]=1;
		for(int i= 2 ; i <= n ; i++) tracker[i]=value=(value*2)+1;
		
	//	for(int i= 1 ;i <= 50 ; i++)System.out.print(tracker[i]+ " ");
		System.out.println(Arrays.toString(tracker));
		System.out.println(value);
	}
}
