import java.util.*;
class CollectionsDemo 
{
	public static void main(String[] args) 
	{
		List<String> list=new LinkedList<String>();
		list.add("abss");
		list.add("abcssddddd");
		list.add("avdssss");
		System.out.println("������˳��"+list);
		Collections.sort(list,new StrLenComparator());
		//����������ʽ
		
		System.out.println("������������˳��"+list);
		System.out.println("����ĸ˳������ֵΪ��"+Collections.max(list));
		//��ȡ���ֵ�����ֲ�����ʽ

		int index= Collections.binarySearch(list,"abss",new StrLenComparator());
		//���ֲ��ҷ�����ĳ��Ԫ�أ�����ֵΪ�Ǳ�

		System.out.println("abss��index="+index);

//Collections.fill("pp")
//Collections.replaceAll(list��"abss","pp")
//list.set("","")
//Collction.reverse()

//reverse()����һ���Ƚ�����ǿ����תԭ���ıȽ���
//reverseOrder(Comparator com)���ز����Ƚ�������ת

	}
}
class StrLenComparator implements Comparator<String>//ע��ӷ���
{
	public int compare(String s1,String s2)//�˴��������뷺��һ��
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
