class Single //懒汉式
{
	private static Single s=null;//注意是静态的，唯一一个共有的
	private Single(){};
	public static Single getInstance()//是静态的，因为要通过函数直接调用
	{
		if(s==null)
			synchronized(Single.class)
			{
				if(s==null)//双重判断
				{
					s=new Single(); 
					return s;
				}
			}
	}  
}

class Single//饿汉式 
{
	private static Single s=new Single();
	private Single(){};
	public static Single getInsetance()
	{
		return s;
	}
}
		