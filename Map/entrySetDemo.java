/*
����ȡMap�����еļ���ֵ
entrySet()��˼���ǣ�
һ��Map���ϵ���entrySet()�����Ի�ô�ӳ���е����й�ϵ��
��ϵ��һ��Map.Entry<,>���ͱ�ʾ
�����й�ϵ������һ������Set<Map.Entry<,>>��
ʹ�õ�������ȡ��ÿһ������ΪMap.Entry�Ķ���
ÿһ������ʹ��getValue(),getKey()�����Ϳɻ�ü���ֵ
*/
import java.util.*;
class entrySetDemo 
{
	public static void main(String[] args) 
	{
		Map<String,String> map=new HashMap<String,String>();
		map.put("zhangsan","01");
		map.put("lisi","02");
		map.put("wangwu","03");
		Set<Map.Entry<String,String>> entrySet=map.entrySet();//����һ�����Ͻ��շ��ص�ӳ�伯
		Iterator<Map.Entry<String,String>> it=entrySet.iterator();//��ô˼��ϵĵ�����
		while (it.hasNext())
		{
			Map.Entry<String,String> entry=it.next();//ʹ�õ������õ�ÿһ��ӳ��
			System.out.println("key:"+entry.getKey()+"value:"+entry.getValue());//ӳ�������÷�����ü���ֵ
		}
	}
}
