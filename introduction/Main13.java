package introduction;
import java.util.Scanner;
public class Main13 {
/**		���ص���	(̰��  ��̬�滮)
 * ʱ�����ƣ�1.0s   �ڴ����ƣ�256.0MB
 * ��������:
����	ĳ��Ϊ�˷����й��ĵ���Ϯ������չ��һ�ֵ�������ϵͳ���������ֵ�������ϵͳ��һ��ȱ�ݣ�
	��Ȼ���ĵ�һ���ڵ��ܹ���������ĸ߶ȣ������Ժ�ÿһ���ڵ������ܸ���ǰһ���ĸ߶ȡ�ĳ�죬
	�״ﲶ׽���й��ĵ�����Ϯ�����ڸ�ϵͳ�������ý׶Σ�����ֻ��һ��ϵͳ������п��ܲ����������еĵ�����
	
����	���뵼�����η����ĸ߶ȣ��״�����ĸ߶������ǲ�����30000��������������������ϵͳ��
	�������ض��ٵ��������Ҫ�������е�������Ҫ�䱸���������ֵ�������ϵͳ��
 * �����ʽ:
����	һ�У�Ϊ�������η����ĸ߶�
 * �����ʽ:
����	���У��ֱ�����������صĵ�������Ҫ�������е�������Ҫ�䱸��ϵͳ��
 * ��������:
	389 207 155 300 299 170 158 65
 * �������:
	6
	2
 * ʱ��	125ms
 * �ڴ�	21.99MB
 * ������
 * 
 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		String[] s = str.split(" "); 
		int num[] = new int[s.length];
		for(int i=0;i<s.length;i++)
			num[i] = Integer.parseInt(s[i]);
		int dp_1[] = new int[s.length];
		int dp_2[] = new int[s.length];
		for(int i=0;i<s.length;i++)
		{dp_1[i] = 1;	dp_2[i] =1;	}
		
		for(int i=0;i<s.length;i++) {
			for(int j=0;j<i;j++)
			{
				if(num[i]<=num[j])
					dp_1[i] = Math.max(dp_1[i], dp_1[j]+1);
				else
					dp_2[i] = Math.max(dp_2[i], dp_2[j]+1);
			}
		}
		int ans_1=-1,ans_2=-1;
		for(int i=0;i<s.length;i++)
		{
			ans_1 = Math.max(ans_1, dp_1[i]);
			ans_2 = Math.max(ans_2, dp_2[i]);
		}
		System.out.println(ans_1);
		System.out.println(ans_2);
	}

}
