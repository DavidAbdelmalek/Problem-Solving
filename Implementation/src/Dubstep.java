import java.io.*;
import java.util.*;

public class Dubstep {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		String arr []  = s.split("");
		int count = 0 ;
		boolean flag= true;
		for(int i =0 ; i  < s.length()-2;i++)
			if(s.substring(i, i+3).equals("WUB")){
				if(count>0){
					if(flag){
						arr[i]=" ";
						arr[i+1]=arr[i+2]="";
						flag=false;
					}else arr[i]=arr[i+1]=arr[i+2]="";
				}else arr[i]=arr[i+1]=arr[i+2]="";
				i+=2;
			}
			else{
				if(!flag) flag=true;
				count++;
			}
		StringBuilder sb = new StringBuilder("");
		for(int i=  0;i<arr.length;i++){
			sb.append(arr[i]);
		}
		System.out.println(sb);
	}
}
