import java.util.*;
class ArraysDemo 
{
	public static void main(String[] args) 
	{
		Character[]arr={'a','d','g','v'};//如果要用集合返回注意定义的类型
		List<Character> list=Arrays.asList(arr);//工具类方法，注意泛型的使用
		System.out.println(list);
	}
}
