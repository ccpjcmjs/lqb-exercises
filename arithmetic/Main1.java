package arithmetic;
import java.util.Scanner;
/**
 * 	A+B����
 * ʱ�����ƣ�1.0s   �ڴ����ƣ�256.0MB
 *����A��B�����A+B 
 *����ĵ�һ�а��������������ɿո�ָ����ֱ��ʾA��B 
 *���һ�У�����һ����������ʾA+B��ֵ
 *  -10000 <= A, B <= 10000 
 *ʱ��156ms	
 *�ڴ� 22.01MB 
 * */
public class Main1 {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int A = sca.nextInt();
		int B = sca.nextInt();
		if(A<-10000||B>10000) {
			System.out.println("please imput -10000 <= A, B <= 10000 ");
			A = sca.nextInt();
			B = sca.nextInt();			
		}
		int sum = A+B;
		System.out.println(sum);
	}

}
