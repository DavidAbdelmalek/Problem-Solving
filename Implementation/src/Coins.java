import java.io.*;
import java.util.*;

public class Coins {
	static int []A;
	static int []B;
	static int []C;
	static final char ZERO ='A';
	static final char ONE	='B';
	static final char TWO 	='C';

	public static void main(String[]args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		A=new int[9];

		int tempA,tempB;
		for(int i = 0 ;i<3;i++){
			String []temp=bf.readLine().split("");
			tempA=get(temp[0]);
			tempB=get(temp[2]);
			put(tempA,temp[1],tempB);
		}
		if(getBruh(0,3)!='F'&& getBruh(1,2)!='F'){
		String out=getBruh(0,3)+"@"+getBruh(1, 2);
		if(out.contains("A"))
			if(out.contains("B"))
				System.out.println(out.charAt(0)+"C"+out.charAt(2));
			else
				System.out.println(out.charAt(0)+"B"+out.charAt(2));
		else
			System.out.println(out.charAt(0)+"A"+out.charAt(2));
		}
		else System.out.println("Impossible");
		
				
	}
	static int get(String s){
		if(s.equals("A"))return 0;
		else if(s.equals("B"))return 1;
		else return 2;
	}
	static void put(int val1 , String comp , int val2){
		//System.out.println(val1 + " ");
		if(comp.equals(">")) A[(val1*3)+val2]=1;
		else A[(val2*3)+val1]=1;
	}

	static char getBruh(int Search,int count){
		int counts=0;
		for(int i = 0,key ; i < 3 ;i++){
			key=i*3;
			for(int k = 0 ; k< 3; k++)
				if(A[key+k]==Search)counts++;

			if(counts==count){
				if(i==0)return ZERO;
				else if(i==1)return ONE;
				else return TWO;
			
			}
			counts=0;
			
		}
		return 'F';
	}
}
