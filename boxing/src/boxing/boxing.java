package boxing;

public class boxing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=30;
		Integer b =Integer.valueOf(a); 
		System.out.println(b); 
		Integer b1=a; 
		System.out.println(b1);
		Integer v = 50; 
		int ve=v.intValue();
        System.out.println(ve);
        int aa=v;
        System.out.println(aa);
		Integer d=40;
		String str = Integer.toString(d);
		System.out.println(str);
		int a1=40;
		float b2=a1;
		System.out.println(b2);
		float vi=40.44f;
		int as = (int)vi;
		System.out.println(as);
		String str1="200";
		int p=Integer.parseInt(str1);
		System.out.println(p);
		String str2="aditya";
		Char a3=Character.parseChar(str2);
		System.out.println(a3);
		Integer s=Integer.valueof(50);
		Integer s1=Integer.valueOf(40);
		int r=s.compareTo(s1);
		if(r<0)
			System.out.println("<");
		else if(r==0)
			System.out.println("=");
		else
			System.out.println(">");
		String str = "Aditya";
		Character ch = str.charAt(03333);  // still works

		
		
		
		
		
		
		
		

	}

}
