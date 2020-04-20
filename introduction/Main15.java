package introduction;
import java.util.Scanner;
public class Main15 {
/**		���мҵ�Ԥ��	(̰��)
 * ʱ�����ƣ�1.0s   �ڴ����ƣ�256.0MB
 * ��������:
����	һ�����м����ʻ���������ٵķ��ô�һ�����е���һ�����У��������ʱ�����ǿյģ���
	������������֮��ľ���D1���������������C������Ϊ��λ����ÿ����������ʻ�ľ���D2��
	������ÿ�����ͼ۸�P����;��վ��N��N����Ϊ�㣩����վi�������ľ���Di��ÿ�����ͼ۸�
	Pi��i=1��2������N��������������������С�������λ������޷�����Ŀ�ĵأ��������No Solution����
 * �����ʽ:
����	��һ��Ϊ4��ʵ��D1��C��D2��P��һ���Ǹ�����N��
����	������N�У�ÿ������ʵ��Di��Pi��
 * �����ʽ:
����	������Ե���Ŀ�ĵأ����һ��ʵ��������������С�������λ������ʾ��С���ã�
	���������No Solution�����������ţ���
 * ��������:
	275.6 11.9 27.4 2.8 2
	102.0 2.9
	220.0 2.2
 * �������:
	26.95
 * �ڴ�	109ms
 * ʱ��	23.70MB
 * ����:	����̰��˼�룬��ʡǮ��ʡǮ ����Ϊ�б��˵����ñ��˵���û�б��˵��;Ͱѵ�ǰ�ı����������ø����
 		�ͱ��磬ÿ������վ�����ͼ����������Ͳ����ںϵ�һ�𣬶������ñ��˵��ͣ�֪����������·�̣������ù����͵ķ��á�
 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		double D1 = in.nextDouble();	//��������֮��ľ���
		double C = in.nextDouble();	//�������������C������Ϊ��λ��
		double D2 = in.nextDouble();	//ÿ����������ʻ�ľ���
		double p = in.nextDouble();	//������ÿ�����ͼ۸�
		
		int N = in.nextInt();	//��;��վ��N
		double []D = new double[N+2];	//�������ľ���
		double []Pi = new double[N+2];	//ÿ��վ����ͼ�
		double MaxDistance = D2*C; //����װ������·��
		//��ʼ��������ͼ�
		D[0] = 0;Pi[0] = p;
		D[N+1] = D1; Pi[N+1] = 0;
		for(int i=1;i<=N;i++)
		{
			D[i] = in.nextDouble();
			Pi[i] = in.nextDouble();
		}
		
		double fee = 0;
		double remain = 0;
		//�ж��Ƿ��޷�����
		for(int i=0;i<=N;i++) {
			if(D[i+1]-D[i]>MaxDistance)
			{
				System.out.println("No Solution");
				return ;
			}
		}
		//���Ե���
		int i=0;
		while(i<=N)
		{
			int j;
			for(j=i+1;j<=N+1;j++)
			{
				if(D[j]-D[i]>MaxDistance)
				{
					j-=1;	//���ɵ�����뵽����jֻ�ܵ�j-1
					break;
				}
				if(Pi[j]<=Pi[i])
					break;	//�ҵ������˵ļ���վ
			}
			
			if(Pi[j]<=Pi[i])	//�Ѿ��ҵ�����һ�������˵ļ���վ
			{
				fee +=((D[j]-D[i])/D2 - remain)*Pi[i]; //���·���
				remain = 0; //���µ���һ������վʣ������
			}
			else //û���ҵ������˵ļ���վ ������
			{
				fee += (C-remain) * Pi[i];
				remain = C-(D[j] - D[i])/D2;
			}
			
			i=j;//ǰ����һ������վ
		}
		System.out.println(String.format("%.2f", fee));
	}

}
