//���ֻ�ȡip����ķ�������ȡ����������ip���󣬸�������������ip��ַ��ȡip����
import java.net.*;
class InetAddressDemo{
	public static void main(String[] args) throws UnknownHostException
	{
		InetAddress ia=InetAddress.getLocalHost();
		System.out.println(ia.getHostAddress());
		System.out.println(ia.getHostName());

		InetAddress i=InetAddress.getByName("www.baidu.com");
		System.out.println(i.getHostAddress());
		System.out.println(i.getHostName());
		//���и��ݵ�ַ��ȡInetAddress����ķ���
	}
}
