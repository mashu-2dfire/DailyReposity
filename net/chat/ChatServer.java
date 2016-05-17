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
					System.out.println("ip地址"+s.getInetAddress());					
				}
				catch (IOException ei)
				{
					System.out.println("服务端接收失败");
				}
			}
		}
		catch (IOException e)
		{
			System.out.println("端口已经被占用，请关闭相关程序后重新启动");
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
				System.out.println("读取失败（获取服务端读取流失败）");
			}
			try
			{
				dos=new DataOutputStream(s.getOutputStream());
			}
			catch (IOException ei)
			{
				System.out.println("发送失败（获取服务端输出流失败）");
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
				System.out.println("客户端数据发送失败");
			}
			
		}
		public void run()
		{
			try
			{
				while (true)
				{
					String str=di.readUTF();                 //发生异常说明客户端关闭
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
					mul_servers.remove(this);				//当客户端断开时，集合中的“服务”去除
				}
				catch (IOException ei)
				{
					System.out.println("接收端口de关闭失败");
				}	
				System.out.println(s.getInetAddress()+"连接断开");
			}
		}
	}
}