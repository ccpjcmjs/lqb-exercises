package basics;
/**		������
 *ʱ�����ƣ�1.0s   �ڴ����ƣ�512.0MB 
 *1221��һ���ǳ����������������߶��ʹ��ұ߶���һ���ģ������������������λʮ�������� 
 *����С�����˳�����������������λʮ�������� 
 *ʱ��46ms	
 *�ڴ�20.24MB
 * */
public class Main8 {

	public static void main(String[] args) {
		int a=0,b=0,c=0,d=0,test=0;
		for(int i=1000;i<=9999;i++) {
			a=i/1000;		//��λ
			b=i/100%10;		//ʮλ
			c=i%100/10;		//��λ
			d=i%10;			//ǧλ
			if(a==d&&b==c)
				System.out.println(i);
		}

	}

}
