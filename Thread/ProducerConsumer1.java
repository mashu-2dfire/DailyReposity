class Res
{
	String name;
	String gender;
	boolean flag=false;
	public synchronized void input(String name,String gender)
	{
		while(flag)
		{
			try{this.wait();}catch(Exception e){}
		}
		this.name=name;
		this.gender=gender;
		flag=true;//资源存在
		System.out.println(Thread.currentThread().getName()+this.name+"——————生产者——————"+this.gender);
		notifyAll();//先唤醒对方再沉睡
		try{wait();}catch(Exception e){}
	}
	public synchronized void output()
	{
		while(!flag)
		{
			try{this.wait();}catch(Exception e){}
		}
		System.out.println(Thread.currentThread().getName()+name+"消费者"+gender);
		flag=false;
		notifyAll();
		try{this.wait();}catch(Exception e){}
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
				res.input("mike","male");
			else
				res.input("丽丽","女");
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
class ProducerConsumer1
{
	public static void main(String[] args) 
	{
		Res res=new Res(); 
		new Thread(new Producer(res)).start();
		new Thread(new Producer(res)).start();
		new Thread(new Consumer(res)).start();
		new Thread(new Consumer(res)).start();
	}
}
