/*
���̵߳���Ʒ����������
1.��if��������while��notify������notifyAll���������߳�ȫ�����ѣ�Ȼ������ж�
  �������߳�ȫ����˯�Լ������������һ�κ����Ѷ������һ�Σ���Ϊ��if�����ѵ��Ǳ����̣߳�
2.ע�⣬wait������notify������notifyAll����������������ģ������Բ���ͬһ������������ĳһ�������̣߳�notify�Է���
3.�Ȼ����ٳ�˯
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
			flag=true;//��Դ����
			System.out.println(this.name+"�����������������ߡ�����������"+this.gender);
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
			System.out.println(name+"������"+gender);
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
class ProducerConsumer
{
	public static void main(String[] args) 
	{
		Res res=new Res(); 
		new Thread(new Producer(res)).start();
		new Thread(new Consumer(res)).start();
	}
}
