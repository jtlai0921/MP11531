

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
public class ArrayUtils
{
	/**
	 * 定義一個工具方法，工具方法從字串陣列中找到對應的字串元素的位置
	 * @param array 搜尋的陣列
	 * @param target 搜尋的字串
	 * @return 目標字串出現的位置,-1表明找不到
	 */
	public static int search(String[] array, String target)
	{
		for (int i = 0 ; i < array.length ; i++ )
		{
			if (array[i] != null && array[i].equals(target))
			{
				return i;
			}
		}
		return -1;
	}
}
