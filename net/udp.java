//udp传输
import java.net.*;
class  udpSend
{
	public static void main(String[] args) throws Exception
	{
		DatagramSocket ds=new DatagramSocket();                //建立服务
		byte[] by="udp 传输".getBytes();
		DatagramPacket dp=										//定义数据包
			new DatagramPacket(by,by.length,InetAddress.getByName("192.168.1.104"),10001);
		ds.send(dp);											//发送
		ds.close();												//关资源
	}
}
class udpRece
{
	public static void main(String[] args)throws Exception
	{
		DatagramSocket ds=new DatagramSocket(10001);           //建立服务，并定义端口
		byte[] by=new byte[1024];
		DatagramPacket dp=new DatagramPacket(by,by.length);		//定义数据包用于接收
		ds.receive(dp);											//接收

		String str=dp.getAddress().getHostAddress();			//解析地址、数据、端口号
		String st=new String(dp.getData(),0,dp.getLength());
		int i=dp.getPort();
		System.out.println("ip::"+str+"\r\n"+st+"\r\n"+i);
		ds.close();
	}
}