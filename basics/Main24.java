package basics;
import java.util.Scanner;
public class Main24 {
/**		��������Ԥ��	(���� ģ��)
 * ʱ�����ƣ�1.0s   �ڴ����ƣ�512.0MB
 * ��������
����   	 ��˵����������и��ָ��������Ӻ��ڹ꣬�����о����֣����е����Ӻ��ڹ궼��һ����ͬ���ص㡪��ϲ�����ܡ�
            ���������ϸ������䶼�����ڷ������ڹ�����ӵı�����С���Դ˺ܸ���Ȥ�����Ǿ����о���ͬ���Ӻ��ڹ����
            �ܡ������֣�������Ȼ�ܱ��ڹ�죬��������������֪��ë���������������裬���������ڹ�ı����У�һ����һ
            ����������ӷ����Լ�����t�׻����ϣ����Ǿͻ�ͣ������Ϣs�롣���ڲ�ͬ�����ӣ�t��s����ֵ�ǲ�ͬ�ģ���
            �����е��ڹ�ȴ��һ�¡������ǲ����յ����ֹͣ��
����     Ȼ����Щ�����൱������ȫ�̹ۿ���ķѴ���ʱ�䣬��С������ֻҪ��ÿ��������ʼ���¼�����Ӻ��ڹ������
	�������ӵ��ٶ�v1����ʾÿ����������v1�ף����ڹ���ٶ�v2���Լ����Ӷ�Ӧ��t��sֵ���Լ������ĳ���l����
	����Ԥ��������Ľ��������С������������ͨ���ֹ������Ʋ�������Ľ�����������ҵ����㡪���廪��ѧ�����
	ϵ�ĸ߲��������������������дһ�����򣬶��������һ������������v1��v2��t��s��l��Ԥ��ó������Ľ����
 * �����ʽ
����	����ֻ��һ�У������ÿո���������������v1��v2��t��s��l������(v1,v2<=100;t<=300;s<=10;l<=10000��Ϊv1,v2�Ĺ�����)
 * �����ʽ
����	����������У���һ����������������һ����д��ĸ��T����R����D�����ֱ��ʾ�ڹ��ʤ�����ӻ�ʤ����������ͬʱ�����յ㡣
����	�ڶ������һ������������ʾ��ʤ�ߣ�����˫��ͬʱ�������յ����ķѵ�ʱ�䣨��������
 * ��������
	10 5 5 2 20
         �������
	D
	4
 * ��������
	10 5 5 1 20
 * �������
	R
	3
 * ��������
	10 5 5 3 20
         �������
	T
	4
 * ʱ��	109ms
 * �ڴ�	22.04MB
 * 	  ����˼· ������������ѧ˼ά ʹ��forѭ��ѭ������Ϊ�ʱ����ɱ������ڹ������ʱ�䡣
 * 		           ÿ��ѭ���ڹ�����ӵ�·�̼����ٶȣ�Ȼ����������Աȣ������Ƴ�ѭ�����ɡ�
 * */
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int v1 = sca.nextInt();	//�����ٶ�
		int v2 = sca.nextInt(); //�ڹ��ٶ�
		int t = sca.nextInt(); //���ӳ����ڹ�·��t
		int s = sca.nextInt(); //ͣ��ʱ��s
		int l = sca.nextInt();	//��·��
		int RpathLength = 0;	//����·��
		int TpathLength = 0;	//�ڹ�·��
		for(int i = 1;i<=l/v2;i++) {
			RpathLength += v1;	//�ڹ�����·�����
			TpathLength += v2;	
			if(RpathLength - TpathLength >= t ) {		//�ж������Ƿ񳬹��ڹ� t
				if(TpathLength!=l&&RpathLength == l) {	//�˴��ų������Ӹպõ��յ�Ͳ�����ͣ��
					System.out.println("R");
					System.out.println(i);	
					break;
				}
				TpathLength += s * v2;		//����ͣ�� �ڹ���
				i += s;
			}
			if(TpathLength >= l&&RpathLength != l) {	//�˴�TL>=l ��ԭ������Ϊ��������ͣ�µ�ʱ���ڹ�����Ѿ������յ�
				System.out.println("T");	
				System.out.println(l/v2);		//����ʱ�䲻��i �����ڹ��ʵ��ʱ��
				break;
			}
			else if(RpathLength == l&&TpathLength != l) {				
				System.out.println("R");		//���ӻ�ʤ
				System.out.println(i);
				break;	
			}
			else if(RpathLength == l&&TpathLength == l) {
				System.out.println("D");	//ͬʱ���յ�
				System.out.println(i);				
				break;	
			}

		}
	}

}