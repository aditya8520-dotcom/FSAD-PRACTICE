package primenumber;

import java.util.Scanner;

public class primenumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner Sc=new Scanner(System.in);
		int a= Sc.nextInt();
		int i;
		int c=0;
		for(i=1;i<=a;i++)
		{
			if(a%i==0)
			{
				c++;
			}
			if(a/10==a)
				c++;
		}
		if(c==2)
			System.out.println("prime");
		else
			System.out.println("composite");
			

	}

}
