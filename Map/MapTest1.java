/*����
һ���ַ������磺jdakshljkdaf
Ҫ�������a<1>d<2>...����ʽ
������
��Ϊ��˳������ѡ����TreeMap��Ϊ���ϣ�TreeMap���Ը��ݼ�����
1.�Ƚ��ַ���ת��Ϊ�ַ�����
2.���弯�Ͻ���
3.���������ӳ��
4.��Ҫ�����
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
			//ע��it.next()����һ�Σ��������ͻ����һλ������key��������
		}
	}
	public static void main(String[] arg) 
	{
		String s="aabdjdkbvas";
		letterNumber(s);
	}
}
