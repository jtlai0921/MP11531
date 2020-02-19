
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
public class ListTest3
{
	public static void main(String[] args)
	{
		List books = new ArrayList();
		// 向books集合中添加4個元素
		books.add(new String("輕量級Java EE企業應用實戰"));
		books.add(new String("瘋狂Java講義"));
		books.add(new String("瘋狂Android講義"));
		books.add(new String("瘋狂iOS講義"));
		// 使用目標類型為Comparator的Lambda運算式對List集合排序
		books.sort((o1, o2)->((String)o1).length() - ((String)o2).length());
		System.out.println(books);
		// 使用目標類型為UnaryOperator的Lambda運算式來替換集合中所有元素
		// 該Lambda運算式控制使用每個字串的長度作為新的集合元素
		books.replaceAll(ele->((String)ele).length());
		System.out.println(books); // 輸出[7, 8, 11, 16]

	}
}