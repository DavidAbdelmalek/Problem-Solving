import java.util.Arrays;
import java.util.Scanner;

public class pipeline {
	static long n;
	static int k;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextLong();
		k = sc.nextInt();


		long total = sum(k);
		if(n==1)System.out.println(0);
		else if(total<n)System.out.println(-1);
		else if(n<=k)System.out.println(1);
		else if(total==n)System.out.println(k-1);
		else System.out.println(BS());
		


	}

	static long BS(){
		long count=0;
		int low = 2;
		long target=0;
		int mid = 0;
		int high = k;
		while(low<high){
			mid  = low+(high-low+1)/2;
			target=sum(high)-sum(mid-1)+1;
			if(count+target>=n)low=mid;
			else {
				high=mid-1;
				count+=target;
			}	
		}
		System.out.println(sum(k)-sum(low-2));
		if(sum(k)-sum(low-1)>=n)	return k-low+1;
		else return k-low+2;
	}
	static long sum(long i ){
		return i*(i+1)/2-(i-1);
	}
}
