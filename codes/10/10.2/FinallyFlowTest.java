

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
public class FinallyFlowTest
{
	public static void main(String[] args)
		throws Exception
	{
		boolean a = test();
		System.out.println(a);
	}
	public static boolean test()
	{
		try
		{
			// 因為finally區塊中包含了return語句
			// 所以下面的return語句失去作用
			return true;
		}
		finally
		{
			return false;
		}
	}
}

