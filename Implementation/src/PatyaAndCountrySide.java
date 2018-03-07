import java.util.*;
import java.io.*;

public class PatyaAndCountrySide {
	static int boom[];
	static int n;
	public static void main(String[]args) throws NumberFormatException, IOException{

		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		boom = new int[n];
		String[]arr = bf.readLine().split(" ");

		for(int i = 0 ; i < n ; i++)boom[i]=Integer.parseInt(arr[i]);

		int max=1;
		for(int i = 0,back,front,sum ; i < n ; i++) {
			back=back(i);
			front=front(i);
			sum=1+back+front;
			max=Math.max(max, sum);
		}
		System.out.println(max);
	}
	static int back(int i){//O(n)
		int count=0;
		int back=i;
		i-=1;
		for(;i>=0;i--){
			if(boom[i]<=boom[back]){
				back=i;
				count++;	
			}
			else return count;
		}
		return count;
	}
	static int front(int i){//O(n)
		int front = i;
		int count=0;
		i+=1;
		for(;i<n;i++){
			if(boom[front]>=boom[i]){
				front=i;
				count++;
				}
			else return count;
		}
		return count;
	}

}
