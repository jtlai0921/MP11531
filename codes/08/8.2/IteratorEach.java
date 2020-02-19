
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
public class IteratorEach
{
	public static void main(String[] args)
	{
		// 建立集合、添加元素的程式碼與前一個程式相同
		Collection books = new HashSet();
		books.add("輕量級Java EE企業應用實戰");
		books.add("瘋狂Java講義");
		books.add("瘋狂Android講義");
		// 獲取books集合對應的迭代器
		Iterator it = books.iterator();
		// 使用Lambda運算式（目標類型是Comsumer）來遍歷集合元素
		it.forEachRemaining(obj -> System.out.println("迭代集合元素：" + obj));
	}
}
