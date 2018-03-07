import java.util.*;
import java.io.*;

public class Arpa {
	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int arr [] = {6,8,4,2};
		int n =Integer.parseInt(bf.readLine());
		if(n==0)System.out.println(1);
		else System.out.println(arr[n%4])	;
	}
}
