package pkg1;

public class DecBin {
	public String convertDecimal(int d)
	{
		String b=new String();
		String x=new String();
		int i;
		//System.out.println(d);
		while(d!=0)
		{
			if(d%2==0)
			{
				b=b+'0';
				
			}
			else
				b=b+'1';
			d=d/2;
			//System.out.println(b);
			//System.out.println(b.length());
		}
		System.out.println(b);
		for(i=b.length()-1;i>=0;i--)
		{
			x=x+b.charAt(i);
		}
			//System.out.println(x);
		return x;
	}
}
