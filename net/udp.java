//udp����
import java.net.*;
class  udpSend
{
	public static void main(String[] args) throws Exception
	{
		DatagramSocket ds=new DatagramSocket();                //��������
		byte[] by="udp ����".getBytes();
		DatagramPacket dp=										//�������ݰ�
			new DatagramPacket(by,by.length,InetAddress.getByName("192.168.1.104"),10001);
		ds.send(dp);											//����
		ds.close();												//����Դ
	}
}
class udpRece
{
	public static void main(String[] args)throws Exception
	{
		DatagramSocket ds=new DatagramSocket(10001);           //�������񣬲�����˿�
		byte[] by=new byte[1024];
		DatagramPacket dp=new DatagramPacket(by,by.length);		//�������ݰ����ڽ���
		ds.receive(dp);											//����

		String str=dp.getAddress().getHostAddress();			//������ַ�����ݡ��˿ں�
		String st=new String(dp.getData(),0,dp.getLength());
		int i=dp.getPort();
		System.out.println("ip::"+str+"\r\n"+st+"\r\n"+i);
		ds.close();
	}
}