/*
FileWriter 的两种构造形式
注意：会发生异常
*/

import java.io.*;
class WriterDemo
{
	public static void main(String[] args) throws IOException//注意：会有IO异常
	{
		method_1();
	}
	public static void method_1()throws IOException
	{
		Writer w= new FileWriter("WriterDemo1.txt");//每次运行都会产生一个新的文件出来
		w.write("ajkfsl");//如果原来有文件夹会将其覆盖
		w.write('c');
		w.flush();
		w.close();
	}
	public static void method_2()throws IOException
	{
		Writer w= new FileWriter("WriterDemo1.txt",true);//会在其后一直续写文件，重载形式
		w.write("ajda");
		w.write('c');
		w.flush();
		w.close();
	}
}
