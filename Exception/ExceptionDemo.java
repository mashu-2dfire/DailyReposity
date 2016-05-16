class Demo 
{
	public double div(int x,int y)//throws Exception
	{
		//if (y==0)
			//throw new Exception();
		return x/y;
	}
}
class ExceptionDemo 
{
	public static void main(String[] args) 
	{
		Demo d=new Demo();
		try
		{
			double x=d.div(4,0);
			System.out.println(x);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(e.toString());
			e.printStackTrace();
		}
		System.out.println("over");
	}
}
