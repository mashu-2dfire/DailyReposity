class ticket extends Thread 
{
	private static int tic=100;//必须是静态，所有对象只存在一份（几个线程卖同100张票）
	public void run()
	{
		while (true)
		{
			if (tic>0)
			{
				System.out.println(Thread.currentThread().getName()+"------"+tic--);
			}
		}
	}

}
class ThreadDemo1
{
	public static void main(String[] args) 
	{
		ticket t1=new ticket();
		ticket t2=new ticket();
		t1.start();
		t2.start();
	}
}
