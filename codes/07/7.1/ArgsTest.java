

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
public class ArgsTest
{
	public static void main(String[] args)
	{
		// 輸出args陣列的長度
		System.out.println(args.length);
		// 遍歷args陣列的每個元素
		for (String arg : args)
		{
			System.out.println(arg);
		}
	}
}

