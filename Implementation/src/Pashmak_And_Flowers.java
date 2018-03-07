import java.io.*;
import java.util.*;

public class Pashmak_And_Flowers {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] arr = new int[n];


		for(int i = 0 ; i < n ; i ++)arr[i]=sc.nextInt();
		Arrays.sort(arr);

		HashMap<Integer,Integer>map = new HashMap<Integer,Integer>();



		for(int i =0 ; i < n ; i ++)
			if(map.containsKey(arr[i]))
				map.put(arr[i], map.get(arr[i])+1);
			else
				map.put(arr[i],1);

		int fir= map.get(arr[0]);
		int sec = map.get(arr[n-1]);

		if(arr[0]==arr[n-1]) 
			System.out.println(0 + " "+((n*(n-1))/2));
		else
			System.out.println(arr[n-1]-arr[0] + " "+(fir*sec));

	}
}
