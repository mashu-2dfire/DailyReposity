import java.io.*;
class ReaderDemo2 
{
	public static void main(String[] args) throws IOException
	{
		Reader reader=new FileReader("E:/java/Test.java");
		char[]ch=new char[1024];
		int num=0;
		while((num=reader.read(ch))!=-1)//读取到一个数组中,返回值为最后一位的索引
			System.out.print(new String(ch,0,num));//用String类型的构造函数转换成字符串形式
			//从索引为0，到索引为num，一直循环，知道最后num为-1，不进入循环
	}
}
