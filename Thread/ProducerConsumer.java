/*
多线程的商品生产与卖出
1.把if，换成了while，notify换成了notifyAll，将所有线程全部唤醒，然后进行判断
  避免了线程全部沉睡以及生产多次消费一次和消费多次生产一次（因为用if，唤醒的是本方线程）
2.注意，wait（），notify（），notifyAll（）都是用在锁里的，“所以采用同一个锁”，唤醒某一个锁的线程（notify对方）
3.先唤醒再沉睡
*/
class Res
{
	String name;
	String gender;
	boolean flag=false;
	public synchronized void input(String name,String gender)
	{
		if(flag)
		{
			try{this.wait();}catch(Exception e){}
		}
		else
		{
			this.name=name;
			this.gender=gender;
			flag=true;//资源存在
			System.out.println(this.name+"——————生产者——————"+this.gender);
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
			System.out.println(name+"消费者"+gender);
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
class ProducerConsumer
{
	public static void main(String[] args) 
	{
		Res res=new Res(); 
		new Thread(new Producer(res)).start();
		new Thread(new Consumer(res)).start();
	}
}
