package basics;
import java.util.Scanner;
public class Main20 {
/**		���Ķ���	���ж� ������
 * ʱ�����ƣ�1.0s   �ڴ����ƣ�512.0MB
 * ��������
����	Tom�������ڸ��о�������һ�Ź��ڻ���Ŀγ̣���һ������������Ϊͷ�ۣ�һ��Ⱦɫ�����г�ǧ���������ԣ����Ǵ�0��ʼ��ţ��������򣬼�ǧ���������ڡ�
����	����˵���ڶ�ѧ�������1234567009��λ���ϵļ��ʱ���⿴�������Ǻ���׼ȷ��������ġ�
����	���ԣ������е���Ҫһ��ϵͳ��Ȼ��������12 3456 7009ʱ���������Ӧ�����
����	ʮ������ǧ�İ���ʮ������ǧ���
����	�ú���ƴ����ʾΪ
����	shi er yi san qian si bai wu shi liu wan qi qian ling jiu
����	������ֻ��Ҫ������Ϳ����ˡ�
����	��������ǰ����������һ��ϵͳ������һ�����������ִ���������������Ķ�д�Ĺ淶תΪ����ƴ���ִ������ڵ�����������һ���ո���񿪡�
����	ע������ϸ��չ淶������˵��10010��������yi wan ling yi shi������
	�ǡ�yi wan ling shi������100000��������shi wan�������ǡ�yi shi wan������2000��������er qian�������ǡ�liang qian����
 * �����ʽ
����	��һ�����ִ�����ֵ��С������2,000,000,000��
 * �����ʽ
����	��һ����СдӢ����ĸ�����źͿո���ɵ��ַ�������ʾ������Ӣ�Ķ�����
 * ��������
	1234567009
 * �������
	shi er yi san qian si bai wu shi liu wan qi qian ling jiu
 * ʱ��	125ms	
 * �ڴ�	22.01MB
 * */
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		String num[] = {"ling","yi","er","san","si","wu","liu","qi","ba","jiu"};
		String wei[] = {"shi","bai","qian","wan","yi"};	
		String str[] = new String[20];	//�洢���
		int n = sca.nextInt();	//������ֵn
		boolean l[] = new boolean[2] ;
		int i=0,j=0,k;
		while(n>0) {
			k = n % 10;
			n = n / 10;
			if(k>0){
				if(i>=4&&!l[i/4-1]) {	//Ĭ��l[]Ϊfalse  ��iΪ4��8��ʱ�����Ϊ wan��yi
					l[i/4-1] = true;  //��һ��ʹl[0]Ϊtrue �ڶ���ʹl[1]Ϊtrue
					str[j++] = wei[i/4+2];
				}
				if(i%4!=0) {
					str[j++] = wei[i%4-1];		//������λ
				}
				str[j++] = num[k];	//������ֵ
			}
			else if(j>0&&str[j-1]!=num[0]) // k=0ʱ �����һλ����0ʱ��ling����ֱ������ i++
				str[j++] = num[0];
			i++;
		}
		if(!(str[j-1]=="yi"&&j>1&&str[j-2]=="shi"))	//�� 12���������shi er������ yi shi er������Ҫʱ�����������ʱ
			System.out.print(str[j-1]+" ");	//������� ���һ��j++Ϊ�� ���Դ�j-1��ʼ
		for(int m=j-2;m>=0;m--)			
			System.out.print(str[m]+" ");
	}
}
