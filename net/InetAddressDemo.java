//几种获取ip对象的方法，获取本地主机的ip对象，根据主机名或者ip地址获取ip对象
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
		//还有根据地址获取InetAddress对象的方法
	}
}
