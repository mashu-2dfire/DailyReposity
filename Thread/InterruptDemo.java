class Wait implements Runnable
{
	private boolean flag=true;
	public void run()
	{
		while (flag)
		{
			System.out.println(Thread.currentThread().getName()+"---run");
		}
	}
	public void changeFlag()
	{
		flag=false;
	}
}



class InterruptDemo 
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
		while (num<=60)
		{
			System.out.println(Thread.currentThread().getName()+num++);
			w1.changeFlag();
			w2.changeFlag();
		}
		System.out.println("over");
	}
}
