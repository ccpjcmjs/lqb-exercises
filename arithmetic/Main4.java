package arithmetic;
import java.util.Scanner;
/**
	Fibonacci����
	ʱ�����ƣ�1.0s   �ڴ����ƣ�256.0MB

   Fibonacci���еĵ��ƹ�ʽΪ��Fn=Fn-1+Fn-2������F1=F2=1��
��n�Ƚϴ�ʱ��FnҲ�ǳ�������������֪����Fn����10007�������Ƕ��١�
	�������һ������n
	���һ�У�����һ����������ʾFn����10007��������
	1 <= n <= 1,000,000
	ʱ��125ms
	�ڴ�22.15MB
*/
public class Main4 {

	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int n = sca.nextInt();
//		if(n>1000000) {
//			System.out.println("please imput 0and1000001 between the two");
//			n = sca.nextInt();
//		}
		long sum=0,result=0;
		long f1=1,f2=1;
		if(n==1||n==2)
			result=1;
		else {
			for(int i=3;i<=n;i++) {
				sum=f1+f2;
				f2=f1;
				f1=sum%10007;
			}
			result=sum%10007;
		}
		System.out.println(result);
	}
}
