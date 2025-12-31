
package cmo.numbers;

public class numbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=78;
		int r;
		int sum=0;
		System.out.println(a);
		while(a!=0)
		{
			r=a%10;
			sum+=r;
			a=a/10;
		}
		System.out.println(sum);
		
		
		

	}

}