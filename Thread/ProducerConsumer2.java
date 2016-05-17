//�����ƻ�������Ʒ
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
			flag=true;//��Դ����
			System.out.println(this.name+"�����������������ߡ�����������"+this.num++);
			notify();//�Ȼ��ѶԷ��ٳ�˯
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
			System.out.println(name+"������"+num);
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
				res.input("ë��");
			else
				res.input("��ˢ");
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
