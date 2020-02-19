
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
public class CollectionEach
{
	public static void main(String[] args)
	{
		// 建立一個集合
		Collection books = new HashSet();
		books.add("輕量級Java EE企業應用實戰");
		books.add("瘋狂Java講義");
		books.add("瘋狂Android講義");
		// 呼叫forEach()方法遍歷集合
		books.forEach(obj -> System.out.println("迭代集合元素：" + obj));
	}
}
