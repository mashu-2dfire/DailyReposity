class ticket implements Runnable
{
	private int tic=100;
	public void run()
	{
		while (true)
		{
			synchronized(this)
			{
 				if (tic>0)//�ڴ˴�������쳣�����Բ���ͬ�������
				{
					try
					{
						Thread.sleep(10);
					}
					catch (Exception e)
					{
					}
					System.out.println(Thread.currentThread().getName()+"*****"+tic--);
				}
			}
		}
	}
}
class  ThreadDemo2
{
	public static void main(String[] args) 
	{
		ticket t=new ticket();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
	}
}
