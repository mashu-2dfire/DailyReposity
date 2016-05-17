//将名称换成了商品
class Res
{
	String name;
	int num=0;
	boolean flag=false;
	public synchronized void input(String name)
	{
		if(flag)
		{
			try{this.wait();}catch(Exception e){}
		}
		else
		{
			this.name=name;
			flag=true;//资源存在
			System.out.println(this.name+"——————生产者——————"+this.num++);
			notify();//先唤醒对方再沉睡
			try{wait();}catch(Exception e){}
		}
	}
	public synchronized void output()
	{
		if(!flag)
		{
			try{this.wait();}catch(Exception e){}
		}
		else
		{
			System.out.println(name+"消费者"+num);
			flag=false;
			notify();
			try{this.wait();}catch(Exception e){}
		}
	}
}
class Producer implements Runnable 
{
	int x=0;
	private Res res;
	Producer(Res res)
	{
		this.res=res;
	}
	public void run()
	{
		while(true)
		{
			if(x==0)
				res.input("毛巾");
			else
				res.input("牙刷");
			x=(x+1)%2;
		}

	}

}
class Consumer implements Runnable
{
	private Res res;
	Consumer(Res res)
	{
		this.res=res;
	}
	public void run()
	{  
		while(true)
		{
			res.output();
		}
	}
}
class ProducerConsumer2
{
	public static void main(String[] args) 
	{
		Res res=new Res(); 
		new Thread(new Producer(res)).start();
		new Thread(new Consumer(res)).start();
	}
}
