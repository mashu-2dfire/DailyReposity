import java.io.*;
class ReaderDemo2 
{
	public static void main(String[] args) throws IOException
	{
		Reader reader=new FileReader("E:/java/Test.java");
		char[]ch=new char[1024];
		int num=0;
		while((num=reader.read(ch))!=-1)//��ȡ��һ��������,����ֵΪ���һλ������
			System.out.print(new String(ch,0,num));//��String���͵Ĺ��캯��ת�����ַ�����ʽ
			//������Ϊ0��������Ϊnum��һֱѭ����֪�����numΪ-1��������ѭ��
	}
}
