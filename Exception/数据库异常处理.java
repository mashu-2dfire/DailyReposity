class  
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}
class A
{
	void method()
	{
		try
		{
			//链接数据库 数据操作
		}
		catch (SQLException e)
		{
			//会对数据库异常进行处理
			throw new NoException();

		}
		finally
		{
			//关闭数据库
		}
	}
}