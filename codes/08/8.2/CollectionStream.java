
import java.util.*;
import java.util.function.*;
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
public class CollectionStream
{
	public static void main(String[] args)
	{
		// 建立books集合、為books集合添加元素的程式碼與8.2.5小節的程式相同。
		Collection books = new HashSet();
		books.add(new String("輕量級Java EE企業應用實戰"));
		books.add(new String("瘋狂Java講義"));
		books.add(new String("瘋狂iOS講義"));
		books.add(new String("瘋狂Ajax講義"));
		books.add(new String("瘋狂Android講義"));
		// 統計書名包含「瘋狂」子串的圖書數量
		System.out.println(books.stream()
			.filter(ele->((String)ele).contains("瘋狂"))
			.count()); // 輸出4
		// 統計書名包含「Java」子串的圖書數量
		System.out.println(books.stream()
			.filter(ele->((String)ele).contains("Java") )
			.count()); // 輸出2
		// 統計書名字串長度大於10的圖書數量
		System.out.println(books.stream()
			.filter(ele->((String)ele).length() > 10)
			.count()); // 輸出2
		// 先呼叫Collection物件的stream()方法將集合轉換為Stream,
		// 再呼叫Stream的mapToInt()方法獲取原有的Stream對應的IntStream
		books.stream().mapToInt(ele -> ((String)ele).length())
			// 呼叫forEach()方法遍歷IntStream中每個元素
			.forEach(System.out::println);// 輸出8  11  16  7  8
	}
}
