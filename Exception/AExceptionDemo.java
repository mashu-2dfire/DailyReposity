class AException extends Exception 
{
	AException(String s)
	{
		super(s);
	}

}
class Demo 
{
	public double div(int x,int y)throws AException
	{
		if (y<0)
			throw new AException("除数小于0了");
		return x/y;
	}
}
class AExceptionDemo 
{
	public static void main(String[] args) 
	{
		Demo d=new Demo();
		try
		{
			double x=d.div(4,-1);
			System.out.println(x);
		}
		catch (AException e)
		{
			System.out.println(e.getMessage());
			System.out.println(e.toString());
			e.printStackTrace();
		}
		System.out.println("over");
	}
}
