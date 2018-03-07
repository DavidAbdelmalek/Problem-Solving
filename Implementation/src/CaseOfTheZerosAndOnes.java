import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CaseOfTheZerosAndOnes {
	public static void main(String[]args) throws NumberFormatException, IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int Zeros = 0,Ones=0;
		String s = bf.readLine();
		for(int i = 0 ; i < n ; i++) 
			if(s.charAt(i)=='0')Zeros++;
			else Ones++;
		System.out.println(Math.abs(Zeros-Ones));
	}
}
