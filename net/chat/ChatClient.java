//创建一个有文本区域和字符输入区域的窗口
//每次按回车，输入框里的内容显示在文本区中，输入框清空
import java.awt.event.*;
import java.awt.*;
import java.net.*;
import java.io.*;
class ChatClient extends Frame
{
	private TextArea txa=null;
	private TextField txf=null;
	Socket s=null;
	DataOutputStream os=null;
	DataInputStream is=null;
	public static void main(String[] args)
	{
		ChatClient ch=new ChatClient();
		ch.start();
	}
	public void start()
	{
		connect();
		init();
		new Thread(new RecMess()).start();
	}
	public void init()
	{
		txa=new TextArea();
		txf=new TextField();
		setBounds(200,100,400,400);
		this.add(txa,BorderLayout.NORTH);
		this.add(txf,BorderLayout.SOUTH);
		pack();
		setVisible(true);

		allListener();
	}	
	public void allListener()
	{
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				disconnect();
				System.exit(0);
			}
		});
		txf.addActionListener(new TxaListener());
	}

	class TxaListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String str=txf.getText();
			//txa.setText(str);
			txf.setText("");
			try
			{				
				os.writeUTF(str);
			}
			catch (IOException ei)
			{
				System.out.println("IO异常");
			}
		}
	}
	public void connect()
	{
		try
		{
			s=new Socket("10.173.212.53",9999);
			os=new DataOutputStream(s.getOutputStream());
			is=new DataInputStream(s.getInputStream());
		}
		catch (UnknownHostException eu)
		{
			System.out.println("地址异常");
		}			
		catch (IOException ei)
		{
			throw new RuntimeException("输入流异常");
		}
		System.out.println("client is connecting");
	}
	public void disconnect()
	{
		try
		{
			os.close();
			s.close();
			is.close();
			os=null;
			is=null;
			s=null;

		}
		catch (IOException ei)
		{
			System.out.println("输入流关闭失败");
		}
	}

	class RecMess implements Runnable
	{
		public void run()
		{
			while (true)
			{
				if(is!=null)
				{
					try
					{
						String str=is.readUTF();
						txa.setText(str);
					}
					catch (IOException e)
					{
						System.out.println("接收的消息打印失败");
					}
				}
				else
					break;
			}			
		}
	}
}