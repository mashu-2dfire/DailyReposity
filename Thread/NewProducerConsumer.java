import java.util.concurrent.locks.*;
class Res
{
	String name;
	String gender;
	boolean flag=false;
	Lock lock=new ReentrantLock();//����һ�����������߳��õ���ͬһ����
	//�ֱ����������Ķ���
	Condition condition_pro=lock.newCondition();
	Condition condition_con=lock.newCondition();//ͬһ����������������
	public void input(String name,String gender)
	{
		lock.lock();
		while(flag)
		{
			
			try{condition_pro.await();}catch(InterruptedException e){}
		
		}
		this.name=name;
		this.gender=gender;
		flag=true;//��Դ����
		System.out.println(Thread.currentThread().getName()+this.name+"�����������������ߡ�����������"+this.gender);
		
		condition_con.signal();//�õ���signal,ע�⻽�ѵ��ǶԷ�

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
		System.out.println(Thread.currentThread().getName()+name+"������"+gender);
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
				res.input("����","Ů");
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
