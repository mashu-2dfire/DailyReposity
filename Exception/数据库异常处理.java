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
			//�������ݿ� ���ݲ���
		}
		catch (SQLException e)
		{
			//������ݿ��쳣���д���
			throw new NoException();

		}
		finally
		{
			//�ر����ݿ�
		}
	}
}