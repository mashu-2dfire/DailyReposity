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
//需要注意的点：this.getName与Thread.currentThread().getName()
//this.getName是这个对象的名称，后者是当前调用线程的名称，两者不同
//在本例中，有三个线程对象：A、main、Thread—0，但只有两个线程启动了：A、main