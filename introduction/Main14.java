package introduction;
import java.util.Scanner;
public class Main14 {
/**		������	(ģ�� �߾��ȼ���)
 * ʱ�����ƣ�1.0s   �ڴ����ƣ�256.0MB
 * ��������:
����	��һ��������λ��Ϊ�㣩�������Ҷ�������������һ�������Ǿͽ����֮Ϊ��������
����	���磺����һ��10������56����56��65������56��������������õ�121��һ����������
����	���磺����10������87��
����	STEP1��87+78 = 165 STEP2��165+561 = 726
����	STEP3��726+627 = 1353 STEP4��1353+3531 = 4884
����	�������һ����ָ������һ��N���Ƶļӷ���������������4���õ�������4884��
����	дһ�����򣬸���һ��N��2<=N<=10��N=16��������M������16��������Ϊ0-9��A-F����
		�����پ����������Եõ���������
����	�����30�����ڣ�����30���������ܵõ����������������Impossible!��
 * �����ʽ:
����	���У�N��M
 * �����ʽ:
����	�������30�����ڵõ��������������STEP=xx�����������ţ�������xx�ǲ�����
	�������һ�С�Impossible!�����������ţ�
 * ��������:
	9
	87
 * �������:
	STEP=6
 * ʱ��	78ms
 * �ڴ�	22.12MB
 * ����:	ʹ��Long�����е�parseLong���Բ�ͬ���Ƶ���ת��Ȼ�����
 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		String M = in.next();
		int index = 0;
		while(!palnum(M))
		{
			index++;
			if(index > 30)
				break;
			long tempa = Long.parseLong(M, N);	//��N����Mת��Ϊ�����ŵ�ʮ����long 
			String st = ""; //��ŵ��������M
			for(int i=M.length()-1;i>=0;i--)
			{
				String str = String.valueOf(M.charAt(i));
				st+=str;
			}
			long tempb = Long.parseLong(st, N);  //��M�Ļ���ת��Ϊlong
			long sum = tempa + tempb;		//���
			M = Long.toString(sum,N);		//��sumת��ΪN���Ƶ��ַ�������
		}
		if(index>30)
			System.out.println("Impossible!");
		else
			System.out.println("STEP="+index);
	}
	public static boolean palnum(String s) {
		boolean bo = true;
		for(int i=0;i<s.length()/2;i++)
		{
			if(s.charAt(i) != s.charAt(s.length()-1-i))	//���ַ�������β�ַ����жԱ�
			{
				bo = false;
				break;
			}
		}
		return bo;
	}
}
