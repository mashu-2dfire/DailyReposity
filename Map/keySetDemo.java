/*����ȡMap���ϵļ���ֵ
keySet()��˼���ǣ�
map�����еķ������õ�����key����һ�����ϣ�
���ü��ϵĵ�����ȡ����ÿһ��key��
Ȼ��ʹ��get��k�����������value
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
