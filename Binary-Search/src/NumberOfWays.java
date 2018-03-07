import java.util.Scanner;
import java.util.*;
import java.io.*;

public class NumberOfWays {
	static long []arr;
	static int n;
	static long target=0;
	public static void main(String[]args){
		Scanner sc =new Scanner(System.in);
		n = sc.nextInt();
		target = 0 ;
		arr=new long[n];

		for(int i = 0; i < n ; i++)target+=arr[i]=sc.nextLong();

		target/=3;
		if(n==3)System.out.println(1);
		else if(n<3)System.out.println(0);
		else{
			int count =0 ;
			Queue<Long>q = new LinkedList<Long>();
			q.add(arr[0]);

			long sum=0;
			for(int i =1 ; i < n ; i++){
				sum=q.peek()+arr[i];
				q.add(arr[i]);
				System.out.println(q.toString());
				if(sum==target||(sum%target==0&&target!=0)){
					count++;
					q.poll();
					q.poll();
					q.add(sum);
				}
				else if(sum>target)q.poll();
				else {
					q.poll();
					q.poll();
					q.add(sum);
				}
			}
			System.out.println(count-2);
		}
	}
}
