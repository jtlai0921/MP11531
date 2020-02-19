
import java.util.*;
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
public class ErasureTest2
{
	public static void main(String[] args)
	{
		List<Integer> li = new ArrayList<>();
		li.add(6);
		li.add(9);
		List list = li;
		// 下面程式碼引起「未經檢查的轉換」的警告，編譯、運行時完全正常
		List<String> ls = list;     // ①
		// 但只要存取ls裡的元素，如下面程式碼將引起運行時異常。
		System.out.println(ls.get(0));
	}
}
