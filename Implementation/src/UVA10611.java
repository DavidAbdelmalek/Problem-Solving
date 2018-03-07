import java.util.*;
import java.io.*;

public class UVA10611 {
	static long ladies[];
	static int n;
	public static void main(String[]args){
		Scanner sc= new Scanner(System.in);

		n = sc.nextInt();
		ladies= new long[n];
		for(int i = 0 ; i < n ; i++)ladies[i]=sc.nextLong();
		int q = sc.nextInt();

		StringBuilder sb = new StringBuilder("");
		long now=0;
		for(int i = 0 ; i < q ; i++){
			now = sc.nextLong();
			int out = BS(now);
			long value = ladies[out];
			int temp = shortest(out,now);
			if(out==n-1)
			if(value==now){
				if(temp==-1)sb.append("X X");
				else sb.append((ladies[temp])+" X");
			}
				else if(value<now)//Tallest lady who is shorter than him.1 2 3 6 if he is 5
					sb.append(value+" X");
				else {//value>=now //same in Tall
					if(temp==-1)sb.append(value+" X");
					else sb.append((ladies[temp])+" "+value);
				}
			else if(out==0){
				if(value==now)sb.append("X X");
				else if(value>now)
					sb.append("X "+value);
				//else sb.append((ladies[out+1])+" "+value+"\n");		
			}else {		
				if(temp==-1)sb.append("X "+value);
				else sb.append((ladies[temp])+" "+value);
			}
			if(i+1!=q)sb.append("\n");
		}
		System.out.println(sb.toString());
		//there are many checks BRUH
	}

	static int BS(long height){
		int start=0;
		int end = n-1;
		int mid = 0 ;
		while(start<end){
			mid = start+(end-start)/2;
			if(ladies[mid]>height)end=mid;
			else start=mid+1;
		}
		return start;
	}

	static int shortest(int mid,long now){

		while(mid-->0){
			if(ladies[mid]<now)return mid;
		}
		return -1;

	}


}
