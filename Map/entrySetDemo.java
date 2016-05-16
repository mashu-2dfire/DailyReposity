/*
用于取Map集合中的键和值
entrySet()的思想是：
一个Map集合调用entrySet()，可以获得此映射中的所有关系，
关系用一个Map.Entry<,>类型表示
将所有关系都存在一个集合Set<Map.Entry<,>>中
使用迭代器，取出每一个类型为Map.Entry的对象
每一个对象使用getValue(),getKey()方法就可获得键和值
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
		Set<Map.Entry<String,String>> entrySet=map.entrySet();//定义一个集合接收返回的映射集
		Iterator<Map.Entry<String,String>> it=entrySet.iterator();//获得此集合的迭代器
		while (it.hasNext())
		{
			Map.Entry<String,String> entry=it.next();//使用迭代器得到每一个映射
			System.out.println("key:"+entry.getKey()+"value:"+entry.getValue());//映射对象调用方法获得键和值
		}
	}
}
