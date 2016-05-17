import java.util.concurrent.locks.*;
class Res
{
	String name;
	String gender;
	boolean flag=false;
	Lock lock=new ReentrantLock();//定义一个锁，两个线程用的是同一个锁
	//分别定义两个锁的对象
	Condition condition_pro=lock.newCondition();
	Condition condition_con=lock.newCondition();//同一个锁里获得两个对象
	public void input(String name,String gender)
	{
		lock.lock();
		while(flag)
		{
			
			try{condition_pro.await();}catch(InterruptedException e){}
		
		}
		this.name=name;
		this.gender=gender;
		flag=true;//资源存在
		System.out.println(Thread.currentThread().getName()+this.name+"——————生产者——————"+this.gender);
		
		condition_con.signal();//用的是signal,注意唤醒的是对方

		try{condition_pro.await();}catch(Exception e){}
		finally
		{
			lock.unlock();
		}
		
	}
	public synchronized void output()
	{
		lock.lock();
		
		while(!flag)
		{
			try{condition_con.await();}catch(Exception e){}
		}
		System.out.println(Thread.currentThread().getName()+name+"消费者"+gender);
		flag=false;
		condition_pro.signal();
		try{condition_con.await();}catch(Exception e){}
		
		finally
		{
			lock.unlock();
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
class NewProducerConsumer
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
