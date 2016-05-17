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
			synchronized(res)//两个线程中持有同一把锁,因为要唤醒持同一把锁的对方
			{
				if(res.flag)
					try{res.wait();}catch(Exception e){}
					//wait()方法定义在Object类中，因为wait()方法要定义线程持有的锁
				if(x==0)
				{
					res.name="mike";
					res.gender="male";
					x=1;
				}
			
				else//if(x==1)
				{
					res.name="丽丽";
					res.gender="女";
					x=0;
				}
				//x=(x+1)%2;
				res.flag=true;//资源存在
				res.notify();//先唤醒对方再沉睡
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
