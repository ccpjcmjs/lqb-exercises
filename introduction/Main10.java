package introduction;
import java.util.Scanner;
import java.util.TreeSet;

public class Main10 {
/**		��������	(���� ����)
 * ʱ�����ƣ�1.0s   �ڴ����ƣ�512.0MB
 * ����������
����	����������������A��B��������ǵĽ����������Լ�B��A�е��༯��
 * �����ʽ��
����	��һ��Ϊһ������n����ʾ����A�е�Ԫ�ظ�����
����	�ڶ�����n��������ͬ���ÿո��������������ʾ����A�е�Ԫ�ء�
����	������Ϊһ������m����ʾ����B�е�Ԫ�ظ�����
����	��������m��������ͬ���ÿո��������������ʾ����B�е�Ԫ�ء�
����	�����е�����Ԫ�ؾ�Ϊint��Χ�ڵ�������n��m<=1000��
 * �����ʽ��
����	��һ�а���С�����˳�����A��B�����е�����Ԫ�ء�
����	�ڶ��а���С�����˳�����A��B�����е�����Ԫ�ء�
����	�����а���С�����˳�����B��A�е��༯�е�����Ԫ�ء�
 * �������룺
	5
	1 2 3 4 5
	5
	2 4 6 8 10
 * ���������
	2 4
	1 2 3 4 5 6 8 10
	1 3 5
 * ʱ�䣺	218ms
 * �ڴ棺	30.19MB
 * ������TreeSet��Ԫ�ؾ���Ψһ�ԣ��Ƚ��ʺ����ּ��ϣ��һ��Ԫ�ؽ�����Ȼ����
 * */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in); 
		
		TreeSet<Integer> test_1 = new TreeSet<Integer>();
		TreeSet<Integer> test_2 = new TreeSet<Integer>();
		TreeSet<Integer> test_3 = new TreeSet<Integer>();
		int n = in.nextInt();
		while(n--!=0) {
			int a = in.nextInt();
			test_1.add(a);	//���
		}
		int m = in.nextInt();
		while(m--!=0) {
			int a = in.nextInt();
			test_2.add(a);
		}
		boolean flag = true;	//���������Ԫ��
		for(Integer temp:test_1)	//�������
		{
			if(test_2.contains(temp))	//���test_2�д���temp����true
			{
				if(flag)
					System.out.print(temp);
				else
					System.out.print(" "+temp);
				flag = false;
			}
		}
		System.out.println();
		flag = true;
		for(Integer temp:test_1) test_3.add(temp);
		for(Integer temp:test_2) test_3.add(temp);
		for(Integer temp:test_3)	//�������
		{
			if(flag)
				System.out.print(temp);
			else
				System.out.print(" "+temp);
			flag = false;
		}
		System.out.println();
		flag = true;
		for(Integer temp : test_1)	//���B��A�е��༯
		{
			if(!test_2.contains(temp))
			{
				if(flag)
					System.out.print(temp);
				else
					System.out.print(" "+temp);
				flag = false;
			}
		}
		System.out.println();
	}

}
