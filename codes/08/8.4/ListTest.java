
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
public class ListTest
{
	public static void main(String[] args)
	{
		List books = new ArrayList();
		// 向books集合中添加三個元素
		books.add(new String("輕量級Java EE企業應用實戰"));
		books.add(new String("瘋狂Java講義"));
		books.add(new String("瘋狂Android講義"));
		System.out.println(books);
		// 將新字串物件插入在第二個位置
		books.add(1 , new String("瘋狂Ajax講義"));
		for (int i = 0 ; i < books.size() ; i++ )
		{
			System.out.println(books.get(i));
		}
		// 刪除第三個元素
		books.remove(2);
		System.out.println(books);
		// 判斷指定元素在List集合中位置：輸出1，表明位於第二位
		System.out.println(books.indexOf(new String("瘋狂Ajax講義"))); //①
		//將第二個元素替換成新的字串物件
		books.set(1, new String("瘋狂Java講義"));
		System.out.println(books);
		//將books集合的第二個元素（包括）
		//到第三個元素（不包括）截取成子集合
		System.out.println(books.subList(1 , 2));
	}
}