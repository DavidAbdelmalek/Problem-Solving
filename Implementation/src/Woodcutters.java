import java.util.*;
import java.io.*;


public class Woodcutters {
	static int n;  
	static Pairs arr[];
	public static void main(String[]args) throws IOException{
		
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		arr = new Pairs[n+1];
		
		String s [] =new String [2];
		long i1,i2;
		for(int i = 0; i <n;i++){
			s=bf.readLine().split(" ");
			i1=Long.parseLong(s[0]);
			i2=Long.parseLong(s[1]);
			arr[i]=new Pairs(i1,i2);
		}
		
		arr[n]=new Pairs(Long.MAX_VALUE-10,0l);
		System.out.println(dp(0,-1));
	}
	static int dp(int i , int decision){//decision 0 left 1 right
		if(i==n)return 0;
		int left=0;
		int right=0;
		long index = arr[i].index;
		long distance = arr[i].dis;
		if(i==0)left+=1+dp(i+1,0);
		else{
		if(decision!=1&&index-arr[i-1].index>=distance||decision==1&&index-(arr[i-1].index+arr[i-1].dis)>=distance)
			left+=1+dp(i+1,0);
		
		if(i!=n-1&&arr[i+1].index-index>=distance)
			right+=1+dp(i+1,1);
		else right+=dp(i+1,-1);
		
		}
		return Math.max(left,right);
		
	}
}

class Pairs{
	long index=0;
	long dis=0;
	public Pairs(long index, long dis) {
		this.index=index;
		this.dis=dis;
	}
}
