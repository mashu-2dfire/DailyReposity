class Wait implements Runnable
{
	private boolean flag=true;
	public synchronized void run()
	{
		while (flag)
		{
			try
			{
				wait();
			}
			catch (InterruptedException e)//中断异常
			{
				flag=false;
			}				
			System.out.println(Thread.currentThread().getName()+"---run");
		}
	}
	public void changeFlag()
	{
		flag=false;
	}
}

class InterruptDemo1
{
	public static void main(String[] args) 
	{
		Wait w1=new Wait();
		Wait w2=new Wait();
		Thread t1=new Thread(w1);
		Thread t2=new Thread(w2);
		t1.start();
		t2.start();
		int num=0;
		while (num<60)
		{
			System.out.println(Thread.currentThread().getName()+num++);
			//w1.changeFlag();
			//w2.changeFlag();
			t1.interrupt();//可以唤醒冻结的的线程
			t2.interrupt();
		}
		System.out.println("over");
	}
}
