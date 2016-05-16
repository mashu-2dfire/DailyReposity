import java.util.*;
/*���㶨����౻�㷺ʹ��ʱ��ע�ⶨ��hashCode()+equals()--------->����HashSet���ϵ�Ҫ��
�Լ�ʵ��Coparable<>�ӿ�+compareTo()----------->����TreeSet��Ҫ��
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
	//getName()����
	//getAge()����
	public int compareTo(Student s)
	{
		int num=new Integer(this.age).compareTo(new Integer(s.age));
		if(num==0)
			return this.name.compareTo(s.name);
		else
			return num;
	}
	public int hashCode()//����hashCode����������Ա�����ϣ��ֵַ
	{
		return name.hashCode()+age*34;
	}
	public boolean equals(Object obj)//������equals�������ж϶����Ƿ���ͬ
	{
		if(!(obj instanceof Student))
			throw new ClassCastException("��Ҫ�������Student����");
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
			//��ӡ��ʱ�����ô˶����toString()����
		}
	}
}