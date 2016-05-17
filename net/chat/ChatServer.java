import java.net.*;
import java.io.*;
import java.util.*;
class ChatServer 
{
	private static ServerSocket ss;
	List<MulServer> mul_servers=new ArrayList<MulServer>();
	public static void main(String[] args)
	{
		new ChatServer().manage();
	}
	public void manage()
	{
		try
		{
			ss=new ServerSocket(9999);		
			while (true)
			{
				try
				{
					Socket s=ss.accept();
					MulServer ser=new MulServer(s);
					new Thread(ser).start();
					mul_servers.add(ser);
					System.out.println("ip��ַ"+s.getInetAddress());					
				}
				catch (IOException ei)
				{
					System.out.println("����˽���ʧ��");
				}
			}
		}
		catch (IOException e)
		{
			System.out.println("�˿��Ѿ���ռ�ã���ر���س������������");
			System.exit(0);
		}
	}
	class MulServer implements Runnable
	{
		Socket s;
		DataInputStream di;
		DataOutputStream dos;
		MulServer(Socket s)
		{
			this.s=s;
			try
			{
				di=new DataInputStream(s.getInputStream());
			}
			catch (IOException ei)
			{
				System.out.println("��ȡʧ�ܣ���ȡ����˶�ȡ��ʧ�ܣ�");
			}
			try
			{
				dos=new DataOutputStream(s.getOutputStream());
			}
			catch (IOException ei)
			{
				System.out.println("����ʧ�ܣ���ȡ����������ʧ�ܣ�");
			}				
		}
		public void send(String str)
		{
			try
			{
				dos.writeUTF(str);		
			}
			catch (IOException e)
			{
				System.out.println("�ͻ������ݷ���ʧ��");
			}
			
		}
		public void run()
		{
			try
			{
				while (true)
				{
					String str=di.readUTF();                 //�����쳣˵���ͻ��˹ر�
					//System.out.println(str);
					Iterator<MulServer> it=mul_servers.iterator();
					while (it.hasNext())
					{
						MulServer ser=it.next();
						ser.send(str);
					}
				}
			}
			catch (IOException e)
			{
				try
				{
					di.close();
					dos.close();
					s.close();	
					mul_servers.remove(this);				//���ͻ��˶Ͽ�ʱ�������еġ�����ȥ��
				}
				catch (IOException ei)
				{
					System.out.println("���ն˿�de�ر�ʧ��");
				}	
				System.out.println(s.getInetAddress()+"���ӶϿ�");
			}
		}
	}
}