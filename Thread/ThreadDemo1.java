class ticket extends Thread 
{
	private static int tic=100;//�����Ǿ�̬�����ж���ֻ����һ�ݣ������߳���ͬ100��Ʊ��
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
