/*用于取Map集合的键和值
keySet()的思想是：
map集合中的方法，拿到所有key存入一个集合，
利用集合的迭代器取出其每一个key，
然后使用get（k）方法，获得value
*/
import java.util.*;
class keySetDemo
{
	public static void main(String[] args) 
	{
		Map<String,String> map=new HashMap<String,String>();
		map.put("zhangsan","01");
		map.put("lisi","02");
		map.put("wangwu","03");
		Set<String> keyset= map.keySet();
		Iterator<String> it=keyset.iterator();
		while(it.hasNext())
		{
			System.out.println(map.get(it.next()));
		}
	}
}
