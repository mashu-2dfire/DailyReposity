import java.io.*;
/*
����һ��
   ע�⹹�캯����read������flush��close���������׳��쳣���ǵô���
�������
   ע��read�ķ���ֵ����read������������ʽ��
��������
   ע���ļ�����ʽҪд��ȷ
*/
class ReaderDemo1
{
	public static void main(String[] args) throws IOException
	{
		Reader reader=new FileReader("E://java//Test.java");
		
		//int r=reader.read();
		int i=0;
		while ((i=reader.read())!=-1)//���ַ����Ƕ�һ����ӡһ��
		{
			System.out.print((char)i);
		}
		reader.close();
	}
}