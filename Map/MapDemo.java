//关于Map接口的一些基本方法
import java.util.*;
class MapDemo
{
	public static void main(String[] args) 
	{
		Map<String,String> map=new HashMap<String,String>();
		map.put("zhangsan","01");
		map.put("lisi","02");
		map.put("wangwu","03");
		System.out.println(map.remove("lisi"));//remove返回值类型为所删除键的value
		System.out.println(map.put("zhangsan","06"));//put返回之前地图中，此建所对应的值，存入键相同时，值会更新
		System.out.println(map.get("zhangsan"));
		System.out.println(map.containsKey("lisi"));
		System.out.println(map);
	}
}
