package basics;
import java.util.Scanner;
/**		��ĸͼ��
 * ʱ�����ƣ�1.0s   �ڴ����ƣ�256.0MB
 *������ĸ�������һЩ������ͼ�Σ����������һ�����ӣ� 
ABCDEFG
BABCDEF
CBABCDE
DCBABCD
EDCBABC 
 *����һ��5��7�е�ͼ�Σ����ҳ����ͼ�εĹ��ɣ������һ��n��m�е�ͼ��
 *����һ�У�������������n��m���ֱ��ʾ��Ҫ�����ͼ�ε�������������
 *���n�У�ÿ��m���ַ���Ϊ���ͼ�� 
 *1 <= n, m <= 26 
 *ʱ��93ms		������һ��
 *�ڴ� 21.59MB
 *ʱ��125ms	(������)
 *�ڴ�22.12MB
 * */
public class Main3 {

	public static void main(String[] args) {
//		Scanner sca = new Scanner(System.in);		//  ����һ �˷���Ҫ��m>=n
//		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//		System.out.println("please imput n and m,n need >=1 ,m need <=26");
//		int n = sca.nextInt();
//		int m = sca.nextInt();
//		String str1 = str.substring(0,m);	//��ȡ�ַ����ӵ�0λ����mλ
//		char[] str2 = str1.toCharArray();	//���ַ���str1ת��Ϊ�ַ�����str2
//		for(int i=0;i<n;i++) {
//			for(int k =i;k>0;k--)
//				System.out.print(str2[k]);
//			for(int j =i;j<m;j++) {
//				System.out.print(str2[j-i]);		
//			}
//		System.out.println();
//		
//		}
		Scanner sca = new Scanner(System.in);	//������
		int n = sca.nextInt();
		int m = sca.nextInt();
		char str;
		char[][] str1 = new char[26][26];
//		char[][] str1 = new char[n][m];   ������n>mʱ�ᷢ��Խ��
		for(int i=0;i<n;i++) {		//��ABC...���δ��뵽������
			str = 'A';
			for(int j=i;j<m;j++) {
				str1[i][j] = str++;
				}
			str = 'A';
			for(int j=i-1;j>=0;j--) {	
				str1[i][j] = ++str;
			}			
		}
		for(int i=0;i<n;i++) {				//���ͼ��
			for(int j=0;j<m;j++) {
				System.out.print(str1[i][j]);
			}
			System.out.println();	
		}
	}
}
