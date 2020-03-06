package basics;
import java.util.Scanner;
/**		数列排序
 * 时间限制：1.0s   内存限制：512.0MB
 *给定一个长度为n的数列，将这个数列按从小到大的顺序排列。1<=n<=200 
 * 输入格式
　　第一行为一个整数n。
　　第二行包含n个整数，为待排序的数，每个整数的绝对值小于10000。
 *输出格式
　　输出一行，按从小到大的顺序输出排序后的数列。 
 *样例输入
	5
	8 3 6 4 9
样例输出
	3 4 6 8 9 
*时间125ms	（希尔排序）
*内存22.26MB
*时间
*内存
*	
 * */
public class Main13 {

	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int n = sca.nextInt();
		int []arr = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = sca.nextInt();
		int swap = 0;
/**	选择排序
* 原理： 选择排序的原理很简单，就是从需要排序的数据中选择最小的（从小到大排序），
* 然后放在第一个，选择第二小的放在第二个……
* 假如数组的长度是N，则时间复杂度：
    进行比较的次数：(N-1)+(N-2)+……+1 = N(N-1)/2
    进行交换的次数：N
特点：（稳定）
        运行时间与输入无关。因为前一次的扫描并不能为后面的提供信息。
 数据的移动次数是最小的。
* */
//		int min = 0;
//		for(int i=0;i<arr.length;i++) {
//			min = i;
//			for(int j=i+1;j<arr.length;j++) {
//				if(arr[min]>arr[j])
//					min = j;
//			}
//			if(min!=i) {
//				swap = arr[i];
//				arr[i] = arr[min];
//				arr[min] = swap;
//			}	
//		}
/**		插入排序
 * 原理： 如果数组进行循环得到a，若a比a前面的一个数小，
 * 则a就与前面数交换位置（相当于a向前面移动一位），若移
 * 动后a任然比前面一个数小，则再向前移动一位……
 * 若数组的长度是N（不重复 ），则时间复杂度：
     平均：N*N/4 次比较，N*N/4次交换
     最好：N-1次比较，0次交换
     最坏：N*N/2次比较， N*N/2次交换
特点：
        若数据倒置的数量很少时，速度快。
* */
//		for(int i=0;i<arr.length;i++) {
//			for(int j=i;j>0&&arr[j-1]>arr[j];j--) {
//				swap = arr[j-1];
//				arr[j-1] = arr[j];
//				arr[j] = swap;
//			}
//		}
/**  冒泡排序
 *  冒泡排序的原理就是小的数字慢慢的往上浮。
 *  从数组最后面开始循环，如果一个数比它前面数小，
 *  则交换两者位置。
 *  时间复杂度：
平均情况下：冒泡比较的次数约是插入排序的两倍，移动次数一致。
平均情况下：冒泡与选择排序的比较此时是一样的，移动比选择排序多出n次
 * */
//		for(int i=0;i<arr.length-1;i++) {		
//			for(int j =arr.length-1;j>i;j--) {
//			if(arr[j-1]>arr[j]) {
//				swap = arr[j];
//				arr[j] = arr[j-1];
//				arr[j-1] = swap;
//				}
//			}			
//		}
		
/**		梳排序
 * 原理： 梳排序分为两部分，第一部分通过步长stepn进行简单的排序，
                 将大的数据集中到后面。第二部分是使用bubbleSort2()进行排序。
                 通过第一部分step的比较，我们能够有效的消除数组中的乌龟(即在数组
                 尾部的较小的数值)
 *           在梳排序中，原作者用随机数做实验，得到了最有效的递减效率是1.3。
 *           也就是step/=1.3,同样也可以写成step *= 0.8,因为编程
 *           语言乘法比除法快。 
 * */	
//		//第一部分
//		int N = arr.length;
//		int step = N;
//		int k;
//		while((step*=0.8) >1 ) {
//			for(int i=N-1;i>=step;i--) {
//				k = i - step;
//				if(arr[k]>arr[i]) {
//					swap = arr[k];
//					arr[k] = arr[i];
//					arr[i] = swap;
//				}
//			}		
//		}
//		//第二部分 冒泡
//		for(int i=0;i<arr.length-1;i++) {		
//			for(int j =arr.length-1;j>i;j--) {
//			if(arr[j-1]>arr[j]) {
//				swap = arr[j];
//				arr[j] = arr[j-1];
//				arr[j-1] = swap;
//				}
//			}			
//		}
		
/**	希尔排序
 * 希尔排序是基于插入排序进行改进，又称之为递减增量排序。
 * 在前面中我们知道，插入排序是将小的元素往前挪动位置，并
 * 且每次只移动一个位置。那么希尔排序是怎么解决这个问题的呢？

原理：希尔排序的理念和梳排序的理念有点类似。在梳排序中，
         我们比较距离相差为step的两个元素来完成交换。在希尔排序
         中，我们的做法也是类似。我们在数组中每隔h取出数组中的元
         素，然后进行插入排序。当h=1时，则就是前面所写的插入排序了。
 * */
//		int N = arr.length;
//		int h = 1;
//		while(h < N/3)	//增量序列
//			h = h*3 + 1; //h = 1,4,13,40...
//		
//		while(h>=1) {
//			for(int i=0;i<N;i++) {  // 进行插入排序，若arr[j]比arr[j-h]小，则向前挪动h
//				for(int j=i;j>=h&&arr[j-h]>arr[j];j-=h) {
//					swap = arr[j-h];
//					arr[j-h] = arr[j];
//					arr[j] = swap;
//				}
//			}
//			h /= 3;
//		}
//		
//		
		for(int i=0;i<n;i++)			//输出数组
			System.out.print(arr[i]+" ");
	}

///**	快速排序
// * 原理： 快速排序使用分治法（Divide and conquer）策略来把一个序列分为较小和较大的2个子序列，然后递归地排序两个子序列。
// * 步骤为：
//	1.挑选基准值：从数列中挑出一个元素，称为“基准”（pivot），
//	2.分割：重新排序数列，所有比基准值小的元素摆放在基准前面，所
//	有比基准值大的元素摆在基准后面（与基准值相等的数可以到任何一
//	边）。在这个分割结束之后，对基准值的排序就已经完成，
//	3.递归排序子序列：递归地将小于基准值元素的子序列和大于基准值
//	元素的子序列排序。
//递归到最底部的判断条件是数列的大小是零或一，此时该数列显然已经有序。
// 选取基准值有数种具体方法，此选取方法对排序的时间性能有决定性影响。
// * 快速排序的实现代码：
//	在前面我们知道，选取正确的基准值对排序的性能有着决定性的影响，在这里我们选择序列中间的值作为基准值。
//	代码主要分为两个部分：
//	1.进行切分的代码
//	2.进行递归调用的代码
// * 特点：
//	快速排序在最坏的情况下时间复杂度是O(n**2),平均时间复杂度是O(nlogn)。
//	快速排序基本上被认为是相同数量级的所有排序算法中，平均性能最好的。
// * */
///**
//* 进行切分，并进行交换
//* @param a 数组
//* @param lo 切分开始的位置
//* @param h 切分结束的位置
//* @return 返回分界点的位置
//*/	
//		 public static void exc(int a[],int i,int j){
//		        // 当他们相等的时候就没必要进行交换
//		        if(a[i] != a[j]){
//		            a[i] ^= a[j];
//		            a[j] ^= a[i];
//		            a[i] ^= a[j];
//		        }
//		    }
//		public static int partition(int[] a,int lo,int h){
//		    // 选取中间的值为基准值
//		    int middle = (lo+h+1)/2;
//		    int v = a[middle];
//		    // 将基准值和a[lo]交换位置
//		    exc(a, lo, middle);
//		    
//		    int i = lo;
//		    int j = h+1;
//		    while(true){
//
//		        // 假如左边的小于基准值，则一直进行循环
//		        while(a[++i] < v){
//		            // 防止越界
//		            if(i == h){
//		                break;
//		            }
//		        }
//		        // 假如右边的大于基准值，则一直进行循环
//		        while(a[--j]>v){
//		            if(j == lo){
//		                break;
//		            }
//		        }
//		        
//		        // 一旦i>=j则代表i前面的除第一个外都比基准值小，j后面的都比基准值大，这时候就可以跳出循环了
//		        if(i>=j){
//		            break;
//		        }
//		        
//		        // 进行交换(因为a[lo]>v,a[h]<v，所以将两者进行交换)
//		        exc(a, i,j);   
//		    }
//		    // 将基准放到分界点
//		    exc(a, lo, j);
//		    return j;
//		}
///**
// * 调用quickSort函数
//* @param a 数组
//*/
//		public static void quickSort(int[] a){
//		        quickSort(a,0,a.length-1);
//		}
//
///**
// * 进行递归的快排
//* @param a
//* @param lo
//* @param h
//*/
//		public static void quickSort(int[] a,int lo,int h){
//		    if(h <= lo) {
//		        return ;
//		    }
//		    // j为基准值的位置
//		    int j = partition(a, lo, h);
//		    // 进行递归调用，将j前面的进行快排
//		    quickSort(a,lo,j-1);
//		    // 进行递归调用，将j后面的进行快排
//		    quickSort(a,j+1,h);
//		}		
}