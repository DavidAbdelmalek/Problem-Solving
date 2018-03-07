import java.util.Scanner;


public class Books {
	static int n ;
	static int time;
	static int [] books;

	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		n = sc.nextInt();
		time = sc.nextInt();
		books=new int[n];
		
		for(int i = 0 ,sum=0;i  < n ; i++) books[i]=sum+=sc.nextInt();

		long temp=0;
		int max=0;

		for(int i = 0; i < n ; i++){
			max=Math.max(max,BS(i,temp));
			temp=books[i];
		}
		System.out.println(max);
	}
	static int BS(int start,long temp){
		int count=0;
		int mid = 0 ;
		int end=n-1;
		while(start<=end){
			mid=start+(end-start)/2;
			if(books[mid]-temp==time) return count+=(mid-start+1);
			if(books[mid]-temp<time){
				count+=(mid-start+1);
				start=mid+1;
			}
			else end=mid-1;
		}
		return count;
	}
}
