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
		//���ַ�����toArray()ʱ������ֵ����ΪObject[]����������Ϊ��T���͵����顱ʱ�����ص���T[]

		//����Ҫ����೤�����飺
		//�����鳤��С������Ҫ�����鳤��ʱ�������´���һ������
		//�����鳤�ȴ���ʱ����ʹ�ò������飬������Ĳ��ֻ᷵�ؿ�
		//����˵����������ȸոպ�����
		System.out.println(strarr.toString());//���ص��ǹ�ϣ��ַ
		System.out.println(Arrays.toString(strarr));//���ӡ����
	}
}
