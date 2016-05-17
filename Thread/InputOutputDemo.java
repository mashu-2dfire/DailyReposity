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
			synchronized(Input.class)//参数传res也可以
			//注意两个问题：1.是否是多线程2.是否用的同一个锁
			//线程0进来，锁锁上，线程1不能输出，因为两块代码用的是同一把锁
			{
				if(flag==0)
				{
					res.name="mike";
					res.gender="male";
					flag=1;
				}
			
				else//if(flag==1)
				{
					res.name="丽丽";
					res.gender="女";
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