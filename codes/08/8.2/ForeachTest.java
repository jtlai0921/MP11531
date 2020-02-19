
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
public class ForeachTest
{
	public static void main(String[] args)
	{
		// 建立集合、添加元素的程式碼與前一個程式相同
		Collection books = new HashSet();
		books.add(new String("輕量級Java EE企業應用實戰"));
		books.add(new String("瘋狂Java講義"));
		books.add(new String("瘋狂Android講義"));
		for (Object obj : books)
		{
			// 此處的book變數也不是集合元素本身
			String book = (String)obj;
			System.out.println(book);
			if (book.equals("瘋狂Android講義"))
			{
				// 下面程式碼會引發ConcurrentModificationException異常
				books.remove(book);     //①
			}
		}
		System.out.println(books);
	}
}
