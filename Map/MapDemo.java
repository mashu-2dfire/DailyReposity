//����Map�ӿڵ�һЩ��������
import java.util.*;
class MapDemo
{
	public static void main(String[] args) 
	{
		Map<String,String> map=new HashMap<String,String>();
		map.put("zhangsan","01");
		map.put("lisi","02");
		map.put("wangwu","03");
		System.out.println(map.remove("lisi"));//remove����ֵ����Ϊ��ɾ������value
		System.out.println(map.put("zhangsan","06"));//put����֮ǰ��ͼ�У��˽�����Ӧ��ֵ���������ͬʱ��ֵ�����
		System.out.println(map.get("zhangsan"));
		System.out.println(map.containsKey("lisi"));
		System.out.println(map);
	}
}
