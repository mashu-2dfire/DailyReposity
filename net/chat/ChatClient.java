//����һ�����ı�������ַ���������Ĵ���
//ÿ�ΰ��س�����������������ʾ���ı����У���������
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
				System.out.println("IO�쳣");
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
			System.out.println("��ַ�쳣");
		}			
		catch (IOException ei)
		{
			throw new RuntimeException("�������쳣");
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
			System.out.println("�������ر�ʧ��");
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
						System.out.println("���յ���Ϣ��ӡʧ��");
					}
				}
				else
					break;
			}			
		}
	}
}