package basics;
import java.util.Scanner;
public class Main19 {
/**	�����Ĵ���(̰���㷨)
 * ʱ�����ƣ�1.0s   �ڴ����ƣ�512.0MB
 * ��������
����	���Ĵ�����һ��������ַ��������������Ҷ��ʹ����������һ���ġ�С������Ϊ���Ĵ����������ġ�
	���ڸ���һ����������һ���ǻ��ĵģ�����������ٵĽ�������ʹ�øô����һ�������Ļ��Ĵ���
����	�����Ķ����ǣ������������ڵ��ַ�
����	����mamad
����	��һ�ν��� ad : mamda
����	�ڶ��ν��� md : madma
����	�����ν��� ma : madam (���ģ�������)
 * �����ʽ
����	��һ����һ������N����ʾ���������ַ����ĳ���(N <= 8000)
����	�ڶ�����һ���ַ���������ΪN.ֻ����Сд��ĸ
 * �����ʽ
����	������ܣ�������ٵĽ���������
����	�������Impossible
 * ��������
	5
	mamad
 * �������
	3
 * ʱ��	140ms	
 * �ڴ�	23.38MB	
 * */
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int n = sca.nextInt();
		String s = sca.next();
		String[]str = s.split("");	//���ַ���sת��Ϊ�ַ�������str
		int oddNum = 0; //��������
		int end = n-1;	//�ַ������һ���ַ�
		int cnt = 0;	//��������

		for(int i=0;i<n/2+1;i++) {	//ֻ��Ҫѭ����ߵ����ݾͿ���
			for(int j=end;j>=i;j--) {
				if(i==j) {	//��û���ҵ����ַ�ʱ
					if(n%2==0||oddNum==1) {
						System.out.println("Impossible");
						System.exit(0);		//��ֹ����
					}
					oddNum = 1;		//����������һ
					cnt += n/2 - i;	
				}
				else if(str[i].equals(str[j])) {	//�˴������ַ������鲻��ֱ�ӱȽ������ַ���  ����str[i]==str[j] �����Ǵ����
					String swap;
					for(int k=j;k<end;k++) {
						swap = str[k];		//����
						str[k] = str[k+1];
						str[k+1] = swap;
						cnt++;
					}
					end--;		
					break ;
				}
			}
		}
		System.out.println(cnt);	//���ѭ������
	}
}
