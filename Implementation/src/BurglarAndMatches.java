import java.util.*;
import java.io.*;

public class BurglarAndMatches {
	static int n ;
	static int m ;
	static int [] [] arr;

	public static void main(String[]args) throws NumberFormatException, IOException{

		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String[]in = bf.readLine().split(" ");
		n  = Integer.parseInt(in[0]);
		m  = Integer.parseInt(in[1]);

		arr =new int[m][2];


		for(int i =0 ; i < m ; i++){
			in=bf.readLine().split(" ");
			arr[i][0]  = Integer.parseInt(in[0]);
			arr[i][1]  = Integer.parseInt(in[1]);
		}
		//Insertation Sort //O(m2) where m is max 20;
		int smallest=0;
		int index=0;
		int temp=0;
		int temp1=0;
		for(int i = 0 ;i  < m ; i++){
			smallest= arr[i][1];
			index=i;
			for(int j = i+1;j<m;j++){
				if(arr[j][1]<smallest){//boxes 22al{
					smallest=arr[j][1];
				index=j;
				}
			}
			temp=arr[i][0];
			temp1=arr[i][1];
			arr[i][0]=arr[index][0];
			arr[i][1]=arr[index][1];
			arr[index][0]=temp;
			arr[index][1]=temp1;
	
		}
		long count=0;
		
		for(int i= m-1,min; n>0&& i>=0;i--){
			min=Math.min(n, arr[i][0]);
			n-=min;
			count+=min*(arr[i][1]);
		}
		System.out.println(count);
	}
}
