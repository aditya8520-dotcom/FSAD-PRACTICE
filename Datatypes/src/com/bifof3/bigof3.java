package com.bifof3;

import java.util.Scanner;

public class bigof3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner Sc=new Scanner(System.in);
		int a=Sc.nextInt();
		int b=Sc.nextInt();
		int c=Sc.nextInt();
		if(a>b && a>c)
		{
			System.out.println("a is greater");
		}
		else if(b>c)
			System.out.println("b is greater");
		else
			System.out.println("c is greater");

	}

}
