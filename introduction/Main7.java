package introduction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;

public class Main7 {
/**		�����	(ƽ�������)
 *	��������:
 *	Alice��һ�����˷ǳ���Ծ����!������ȥѧϰһЩ�����������⣬Ȼ����������ϡ��Źֵ���Ŀ��
 *	�⼸�죬Alice�ֳ���������ԵĿ��ֵ��У����ѽ�ѧ�������������Զ�������̬ά������Զ����ȵ���Ŀ��
 *	����Ϊ����Щ����������ֱ��̫û׷���ˣ����ǣ�����һ���˼�������ƣ�Alice�����ó���һ������Ϊ������Ŀ��
 *	��һ��2n-1���ڵ�Ķ�����������ǡ��n��Ҷ�ӽڵ㣬ÿ���ڵ���д��һ��������
 *	����������������Ҷ�ӽڵ��ϵ���������д��������õ�һ������a[1]��a[n]������������������е�������������٣�
 *	��Ψһ�Ĳ�������ѡ����һ����Ҷ�ӽڵ㣬������������������������������������������������������ŷ����£������е�������������ж��١�
 *	Alice�Լ��ѽ��������Ŀ�����⣬�������������������Ҫ��������̵�ʱ������ɡ� 
 * 	�����ʽ:
 *	��һ��һ������n��
 *	����ÿ�У�һ����x��
 *	���x=0����ʾ����ڵ��Ҷ�ӽڵ㣬�ݹ�����¶��������Ӻ��Һ��ӵ���Ϣ�����x��0����ʾ����ڵ���Ҷ�ӽڵ㣬ȨֵΪx��
 * 	�����ʽ:
 *	���һ����������ʾ�����ж�������ԡ�
 * 	��������:
 *	 3
 *	 0
 *	 0
 *	 3
 *	 1
 *	 2
 * 	�������
 *	 1
 * 	���ݹ�ģ��Լ��
 * 	����20%�����ݣ�n <= 5000��
 * 	����100%�����ݣ�1 <= n <= 200000��0 <= a[i]<2^31��
 * 	ʱ��
 * 	�ڴ�
 * 	����	���� �Ժ�����
 * */
	private static int leafNum;
	private static int[] weightArr;
	private static Point tree;
	private static int i=0;
    public static void main(String[] args)throws IOException {
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        init();
        int minRev = f(tree);
        out.println(minRev);
        out.flush();
    }
    
    private static int f(Point root) {
    	if(root.weight!=0)
    		return 0;
    	else
    	{
    		ArrayList<Integer> listLeft = new ArrayList<Integer>();
    		ArrayList<Integer> listRight = new ArrayList<Integer>();
    		list(root.left,listLeft);
    		list(root.right,listRight);
    		return f(root.left) + f(root.right) + Math.min(revPair(listLeft,listRight), revPair(listRight,listLeft));
    	}
    }
    
    private static int revPair(ArrayList<Integer> list1,ArrayList<Integer> list2) {
    	list1.addAll(list2);
    	int count = 0;
    	for(int i=0;i<list1.size();i++) {
    		for(int j=i+1;j<list1.size();j++) {
    			if(list1.get(i)>list1.get(j))
    				count++;
    		}
    	}
    	return count;
    }
    
    private static void list(Point p,ArrayList<Integer> li) {
    	if(p.weight!=0)
    		li.add(p.weight);
    	else
    	{
    		list(p.left,li);
    		list(p.right,li);
    	}
    }
    
    private static void init()throws IOException {
    	StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    	in.nextToken();leafNum = (int) in.nval;
    	weightArr = new int[2*leafNum-1];
    	for(int i=0;i<2*leafNum-1;i++)
    	{in.nextToken();weightArr[i] = (int)in.nval;}	
    	tree = new Point();
    	tree.weight = weightArr[i++];
    	getTree(tree);
    }
    
    private static void getTree(Point p) {
    	if(weightArr[i]==0)
    	{
    		p.left=new Point();
    		p.right=new Point();
    		p.weight=weightArr[i++];
    		getTree(p.left);
    		getTree(p.right);
    	}
    	else 
    	{
    		p.weight=weightArr[i++];
    		p.left=null;
    		p.right=null;
    	}
    }
}
class Point{
	Point left;
	Point right;
	int weight;
}