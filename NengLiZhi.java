/*
С�׾���������������Ϸ.��һ��,������һ�������������Ϸ,���Ľ�ɫ�ĳ�ʼ����ֵΪ a.
�ڽ�������һ��ʱ����,��������������n������,ÿ������ķ�����Ϊb1,b2,b3...bn. 
��������Ĺ��������biС�ڵ���С�׵ĵ�ǰ����ֵc,��ô���������ɴ�ܹ���
,����ʹ���Լ�������ֵ����bi;���bi����c,����Ҳ�ܴ�ܹ���,����������ֵֻ������bi 
��c�����Լ��.��ô��������,��һϵ�еĶ�����,С�׵���������ֵΪ����?
*/
import java.util.Scanner;
public class NengLiZhi {
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNextLine())
        {
            int num=scanner.nextInt();
            int init=scanner.nextInt();
//            List list=new ArrayList<Integer>();
            int[] arr=new int[num];
            for(int i=0;i<num;i++)
            {
                arr[i]=scanner.nextInt();
                if(init>=arr[i])
                {
                    init+=arr[i];
                }
                else
                {
                    init=init+method(init,arr[i]);
                }
            }
            System.out.println(init);
        }
    }
    public static int method(int a,int b)
    {
        int temp=1;
        for(int i=1;i<=a&&i<=b;i++)
        {
            if(a%i==0&&b%i==0)
            temp=i;
        }
        return temp;
    }
}