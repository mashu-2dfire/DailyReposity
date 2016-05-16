/*需求：
一串字符串例如：jdakshljkdaf
要求其输出a<1>d<2>...的形式
分析：
因为有顺序，所以选择用TreeMap作为集合（TreeMap可以根据键排序）
1.先将字符串转化为字符数组
2.定义集合接收
3.遍历并添加映射
4.按要求输出
*/
import java.util.*;
class MapTest1
{
	public static void letterNumber(String s)
	{
		char[] array=s.toCharArray();
		TreeMap<Character,Integer> map=new TreeMap<Character,Integer>();
		for(int x=0;x<array.length;x++)
		{
			if(!map.containsKey(array[x]))
				map.put(array[x],1);
			else
			{
				int num=map.get(array[x]);
				num++;
				map.put(array[x],num);
			}
		}
		Set<Character> keySet=map.keySet();
		Iterator<Character>it=keySet.iterator();
		while(it.hasNext())
		{
			char key=it.next();
			System.out.println(key+"<"+map.get(key)+">");
			//注意it.next()调用一次，迭代器就会后移一位，设置key变量接收
		}
	}
	public static void main(String[] arg) 
	{
		String s="aabdjdkbvas";
		letterNumber(s);
	}
}
