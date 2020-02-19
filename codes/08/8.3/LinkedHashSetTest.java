
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
public class LinkedHashSetTest
{
	public static void main(String[] args)
	{
		LinkedHashSet books = new LinkedHashSet();
		books.add("瘋狂Java講義");
		books.add("輕量級Java EE企業應用實戰");
		System.out.println(books);
		// 刪除 瘋狂Java講義
		books.remove("瘋狂Java講義");
		// 重新添加 瘋狂Java講義
		books.add("瘋狂Java講義");
		System.out.println(books);
	}
}
