class CountOperate extends Thread
{
	public CountOperate()
	{
		System.out.println("CountOperate---begin");
		System.out.println("Thread.currentThread().getName()="+Thread.currentThread().getName());
		System.out.println("this.getName()="+this.getName());
		System.out.println("CountOperate---end");

	}
	@Override
	public void run()
	{
		System.out.println("Run---begin");
		System.out.println("Thread.currentThread().getName()="+Thread.currentThread().getName());
		System.out.println("this.getName()="+this.getName());
		System.out.println("Run---end");
	}
}

class  Run
{
	public static void main(String[] args) 
	{
		Thread thread=new CountOperate();
		Thread th=new Thread(thread);
		th.setName("A");
		th.start();
	}
}
//��Ҫע��ĵ㣺this.getName��Thread.currentThread().getName()
//this.getName�������������ƣ������ǵ�ǰ�����̵߳����ƣ����߲�ͬ
//�ڱ����У��������̶߳���A��main��Thread��0����ֻ�������߳������ˣ�A��main