import java.util.*;
class ToArrayDemo 
{
	public static void main(String[] args) 
	{
		List<String> list =new LinkedList<String>();
		list.add("jkaslflfa");
		list.add("kasjhfi");
		list.add("auhie");
		String[] strarr=list.toArray(new String[1]);
		//两种方法：toArray()时，返回值类型为Object[]；参数类型为“T类型的数组”时，返回的是T[]

		//关于要定义多长的数组：
		//当数组长度小于所需要的数组长度时，会重新创建一个数组
		//当数组长度大于时，会使用参数数组，多出来的部分会返回空
		//所以说数组参数长度刚刚好最优
		System.out.println(strarr.toString());//返回的是哈希地址
		System.out.println(Arrays.toString(strarr));//会打印数组
	}
}
