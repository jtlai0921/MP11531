
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
public class RightTest
{
	// 宣告一個泛型方法，該泛型方法中帶一個T形式參數
	static <T> void test(Collection<? extends T> from , Collection<T> to)
	{
		for (T ele : from)
		{
			to.add(ele);
		}
	}
	public static void main(String[] args)
	{
		List<Object> ao = new ArrayList<>();
		List<String> as = new ArrayList<>();
		// 下面程式碼完全正常
		test(as , ao);
	}
}
