import java.util.*;
import java.io.*;

public class ValeraAndX {
	public static void main(String[] args) throws IOException {


		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());

		char[][] arr = new char[n][n];

		for(int i = 0 ; i < n ; i++)arr[i]=bf.readLine().toCharArray();

		char first  = arr[0][0];
		char second = arr[0][1];
		if(first==second){
			System.out.println("NO");
			return;
		}
		double ok = n-1;
		double slope2=0;
		for(int i = 0 ;i  < n ; i++){
			for(int j  = 0; j < n ; j++){
				slope2 =(double)(-j/(ok-i));
				if(i==j||slope2==-1||i==(n-1)&&j==0)
					if(arr[i][j]!=first){
						System.out.println("NO");
						return;
					}else;
				else
					if(arr[i][j]!=second){
						System.out.println("NO");
						return;
					}
			}

		}
		System.out.println("YES");

	}
}
