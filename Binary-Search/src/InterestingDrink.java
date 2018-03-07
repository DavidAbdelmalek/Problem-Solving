import java.io.*;
import java.util.*;

public class InterestingDrink {
	static int [] shops;
	static int n ;
	static int n2;
	static int days[];
	public static void main(String[]args) throws NumberFormatException, IOException{

		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		n =Integer.parseInt(bf.readLine());
		shops = new int [n];	
		String st[] =bf.readLine().split(" ");
		for(int i = 0 ; i < n ; i++)shops[i]=Integer.parseInt(st[i]);
		Arrays.sort(shops);
		
		n2 =Integer.parseInt(bf.readLine());
		days = new int [n2];	
	
		for(int i = 0 ; i < n2 ; i++)days[i]=Integer.parseInt(bf.readLine());
	
		for(int i = 0; i  <n2 ; i++)System.out.println(BS(days[i]));
		
	}
	static int BS(int target){
		int start=0,count=0,mid=0,end=n-1;
		while(start<=end){
			mid = start+(end-start)/2;
			if(shops[mid]>target)end=mid-1;
			else if(shops[mid]<=target){
				count+=(mid-start)+1;
				start=mid+1;
			}
		}
		return count;
	}
}
