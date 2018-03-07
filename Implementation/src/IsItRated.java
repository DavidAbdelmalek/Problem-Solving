import java.util.Scanner;


public class IsItRated {
	static int [][] arr ;
	public static void main(String[]args){
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();

		arr = new int [n][2];

		for(int i = 0,oldPoints,newPoints ; i < n ; i++){
			oldPoints= sc.nextInt();
			newPoints=sc.nextInt();
			arr[i][0]=oldPoints;
			arr[i][1]=newPoints;
		}
		boolean sorted =isDECSorted(); 
		if(isChanged())System.out.println("rated");
		else if(sorted)System.out.println("maybe");
		else System.out.println("unrated");
	}
	static boolean isChanged(){
		for(int i = 0 ;i  < arr.length;i++)
			if(arr[i][0]-arr[i][1]!=0){
				return true;
			}
		return false;
	}
	static boolean isDECSorted(){
		for(int i = 0 ;i  < arr.length-1;i++)
			if(arr[i][0]-arr[i+1][0]<0){
				return false;
			}
		return true;
	}
	static boolean isINCSorted(){
		for(int i = 0 ;i  < arr.length-1;i++)
			if(arr[i][0]-arr[i+1][0]>0){
				return false;
			}
		return true;
	}
}
