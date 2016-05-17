class Res
{
	String name;
	String gender;
}
class Input implements Runnable 
{
	private Res res;
	int flag=0;
	Input(Res res)
	{
		this.res=res;
	}		
	public void run()
	{
		while(true)
		{
			synchronized(Input.class)//������resҲ����
			//ע���������⣺1.�Ƿ��Ƕ��߳�2.�Ƿ��õ�ͬһ����
			//�߳�0�����������ϣ��߳�1�����������Ϊ��������õ���ͬһ����
			{
				if(flag==0)
				{
					res.name="mike";
					res.gender="male";
					flag=1;
				}
			
				else//if(flag==1)
				{
					res.name="����";
					res.gender="Ů";
					flag=0;
				}
				//flag=(flag+1)%2;
			}

		}

	}

}
class Output implements Runnable
{
	private Res res;
	Output(Res res)
	{
		this.res=res;
	}
	public void run()
	{  
		while(true)
		{
			synchronized(Input.class)
			{
				System.out.println(res.name+"-----"+res.gender);
			}
		}
	}
}
class InputOutputDemo
{
	public static void main(String[] args) 
	{
		Res r=new Res();
		Input i=new Input(r);
		Output o=new Output(r);
		new Thread(i).start();
		new Thread(o).start();
	}
}