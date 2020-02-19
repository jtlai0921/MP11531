
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
public class ListIteratorTest
{
	public static void main(String[] args)
	{
		String[] books = {
			"瘋狂Java講義", "瘋狂iOS講義",
			"輕量級Java EE企業應用實戰"
		};
		List bookList = new ArrayList();
		for (int i = 0; i < books.length ; i++ )
		{
			bookList.add(books[i]);
		}
		ListIterator lit = bookList.listIterator();
		while (lit.hasNext())
		{
			System.out.println(lit.next());
			lit.add("-------分隔符-------");
		}
		System.out.println("=======下面開始反向迭代=======");
		while(lit.hasPrevious())
		{
			System.out.println(lit.previous());
		}
	}
}
