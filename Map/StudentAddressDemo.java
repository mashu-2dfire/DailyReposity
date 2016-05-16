import java.util.*;
/*当你定义的类被广泛使用时，注意定义hashCode()+equals()--------->存入HashSet集合的要求
以及实现Coparable<>接口+compareTo()----------->存入TreeSet的要求
*/
class Student implements Comparable<Student>
{
	String name;
	int age;
	Student(String name,int age)
	{
		this.name=name;
		this.age=age;
	}
	//getName()方法
	//getAge()方法
	public int compareTo(Student s)
	{
		int num=new Integer(this.age).compareTo(new Integer(s.age));
		if(num==0)
			return this.name.compareTo(s.name);
		else
			return num;
	}
	public int hashCode()//覆盖hashCode方法，程序员分配哈希地址值
	{
		return name.hashCode()+age*34;
	}
	public boolean equals(Object obj)//覆盖了equals方法，判断对象是否相同
	{
		if(!(obj instanceof Student))
			throw new ClassCastException("需要传入的是Student类型");
		else
		{
			Student s=(Student)obj;
			return this.name.equals(s.name)&&this.age==s.age;
		}
	}
	public String toString()
	{
		return this.name+":"+age;
	}
}
class  StudentAddressDemo
{
	public static void main(String[] args) 
	{
		Map<Student,String> map=new HashMap<Student,String>();
		map.put(new Student("zhangsan",21),"shanghai");
		map.put(new Student("wangwu",22),"tianjin");
		map.put(new Student("zhaoliu",20),"beijign");
		map.put(new Student("zhangsan",21),"taibei");
		Set<Map.Entry<Student,String>> mes=map.entrySet();
		Iterator<Map.Entry<Student,String>> it=mes.iterator();
		while (it.hasNext())
		{
			Map.Entry me=it.next();
			System.out.println("key:"+me.getKey()+"--------value:"+me.getValue());
			//打印的时候会调用此对象的toString()方法
		}
	}
}