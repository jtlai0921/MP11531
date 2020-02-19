
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
public class MyUtils
{
	// 下面dest集合元素類型必須與src集合元素類型相同，或是其父類別
	public static <T> T copy(Collection<? super T> dest
		, Collection<T> src)
	{
		T last = null;
		for (T ele  : src)
		{
			last = ele;
			dest.add(ele);
		}
		return last;
	}
	public static void main(String[] args)
	{
		List<Number> ln = new ArrayList<>();
		List<Integer> li = new ArrayList<>();
		li.add(5);
		// 此處可準確的知道最後一個被複製的元素是Integer類型
		// 與src集合元素的類型相同
		Integer last = copy(ln , li);    // ①
		System.out.println(ln);
	}
}