import java.util.*;
class CollectionsDemo 
{
	public static void main(String[] args) 
	{
		List<String> list=new LinkedList<String>();
		list.add("abss");
		list.add("abcssddddd");
		list.add("avdssss");
		System.out.println("本来的顺序："+list);
		Collections.sort(list,new StrLenComparator());
		//排序，两种形式
		
		System.out.println("按长度排序后的顺序："+list);
		System.out.println("按字母顺序的最大值为："+Collections.max(list));
		//获取最大值，两种参数形式

		int index= Collections.binarySearch(list,"abss",new StrLenComparator());
		//二分查找法查找某个元素，返回值为角标

		System.out.println("abss：index="+index);

//Collections.fill("pp")
//Collections.replaceAll(list，"abss","pp")
//list.set("","")
//Collction.reverse()

//reverse()返回一个比较器，强行逆转原来的比较器
//reverseOrder(Comparator com)返回参数比较器的逆转

	}
}
class StrLenComparator implements Comparator<String>//注意加泛型
{
	public int compare(String s1,String s2)//此处的类型与泛型一致
	{
		if (s1.length()>s2.length())
		{
			return 1;
		}
		if (s1.length()<s2.length())
		{
			return -1;
		}
		else
			return s1.compareTo(s2);
	}
}
