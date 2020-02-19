

/**
 * Description:
 * <br/>網站: <a href="http://www.crazyit.org">瘋狂Java聯盟</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class IdentityHashCodeTest
{
	public static void main(String[] args)
	{
		// 下面程式中s1和s2是兩個不同物件
		String s1 = new String("Hello");
		String s2 = new String("Hello");
		// String覆寫了hashCode()方法――改為根據字元序列運算hashCode值，
		// 因為s1和s2的字元序列相同，所以它們的hashCode方法返回值相同
		System.out.println(s1.hashCode()
			+ "----" + s2.hashCode());
		// s1和s2是不同的字串物件，所以它們的identityHashCode值不同
		System.out.println(System.identityHashCode(s1)
			+ "----" + System.identityHashCode(s2));
		String s3 = "Java";
		String s4 = "Java";
		// s3和s4是相同的字串物件，所以它們的identityHashCode值相同
		System.out.println(System.identityHashCode(s3)
			+ "----" + System.identityHashCode(s4));
	}
}
