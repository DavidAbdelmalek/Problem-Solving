import java.io.*;
import java.awt.*;
public class BrainsPhoto {
	public static void main(String[]args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String temp []= bf.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		String [][] arr= new String[n][m];
		for(int i =0 ; i < n ; i++) arr[i]=bf.readLine().split(" ");
		
		boolean colored=false;
		for(int i = 0 ; !colored&&i < n ; i++)
			for(int j = 0 ; !colored&&j < m ;j++)
	if(arr[i][j].equals("C")||arr[i][j].equals("Y")||arr[i][j].equals("M"))
					colored=true;
		System.out.println(colored?"#Color":"#Black&White");
		
	}
}
