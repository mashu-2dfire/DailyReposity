import java.io.*;
/*
问题一；
   注意构造函数、read方法、flush、close方法都会抛出异常，记得处理
问题二：
   注意read的返回值，（read方法的重载形式）
问题三：
   注意文件名格式要写正确
*/
class ReaderDemo1
{
	public static void main(String[] args) throws IOException
	{
		Reader reader=new FileReader("E://java//Test.java");
		
		//int r=reader.read();
		int i=0;
		while ((i=reader.read())!=-1)//这种方法是读一个打印一个
		{
			System.out.print((char)i);
		}
		reader.close();
	}
}