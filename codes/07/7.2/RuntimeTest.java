

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
public class RuntimeTest
{
	public static void main(String[] args)
	{
		// 獲取Java程式關聯的運行時物件
		Runtime rt = Runtime.getRuntime();
		System.out.println("處理器數量："
			+ rt.availableProcessors());
		System.out.println("空閒記憶體數："
			+ rt.freeMemory());
		System.out.println("總記憶體數："
			+ rt.totalMemory());
		System.out.println("可用最大記憶體數："
			+ rt.maxMemory());
	}
}
