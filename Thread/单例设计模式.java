class Single //����ʽ
{
	private static Single s=null;//ע���Ǿ�̬�ģ�Ψһһ�����е�
	private Single(){};
	public static Single getInstance()//�Ǿ�̬�ģ���ΪҪͨ������ֱ�ӵ���
	{
		if(s==null)
			synchronized(Single.class)
			{
				if(s==null)//˫���ж�
				{
					s=new Single(); 
					return s;
				}
			}
	}  
}

class Single//����ʽ 
{
	private static Single s=new Single();
	private Single(){};
	public static Single getInsetance()
	{
		return s;
	}
}
		