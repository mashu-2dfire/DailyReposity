/*
FileWriter �����ֹ�����ʽ
ע�⣺�ᷢ���쳣
*/

import java.io.*;
class WriterDemo
{
	public static void main(String[] args) throws IOException//ע�⣺����IO�쳣
	{
		method_1();
	}
	public static void method_1()throws IOException
	{
		Writer w= new FileWriter("WriterDemo1.txt");//ÿ�����ж������һ���µ��ļ�����
		w.write("ajkfsl");//���ԭ�����ļ��лὫ�串��
		w.write('c');
		w.flush();
		w.close();
	}
	public static void method_2()throws IOException
	{
		Writer w= new FileWriter("WriterDemo1.txt",true);//�������һֱ��д�ļ���������ʽ
		w.write("ajda");
		w.write('c');
		w.flush();
		w.close();
	}
}
