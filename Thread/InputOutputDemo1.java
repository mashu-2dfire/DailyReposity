class Res
{
	String name;
	String gender;
	boolean flag=false;
}
class Input implements Runnable 
{
	private Res res;
	int x=0;
	Input(Res res)
	{
		this.res=res;
	}		
	public void run()
	{
		while(true)
		{
			synchronized(res)//�����߳��г���ͬһ����,��ΪҪ���ѳ�ͬһ�����ĶԷ�
			{
				if(res.flag)
					try{res.wait();}catch(Exception e){}
					//wait()����������Object���У���Ϊwait()����Ҫ�����̳߳��е���
				if(x==0)
				{
					res.name="mike";
					res.gender="male";
					x=1;
				}
			
				else//if(x==1)
				{
					res.name="����";
					res.gender="Ů";
					x=0;
				}
				//x=(x+1)%2;
				res.flag=true;//��Դ����
				res.notify();//�Ȼ��ѶԷ��ٳ�˯
				try{res.wait();}catch(Exception e){}
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
			synchronized(res)
			{
				if(!res.flag)
					try{res.wait();}catch(Exception e){}
				System.out.println(res.name+"-----"+res.gender);
				res.flag=false;
				res.notify();
				try{res.wait();}catch(Exception e){}
			}
		}
	}
}
class InputOutputDemo1
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
