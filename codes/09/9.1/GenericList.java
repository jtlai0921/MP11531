
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
public class GenericList
{
	public static void main(String[] args)
	{
		// 建立一個只想存放字串的List集合
		List<String> strList = new ArrayList<String>();  // ①
		strList.add("瘋狂Java講義");
		strList.add("瘋狂Android講義");
		// 下面程式碼將引起編譯錯誤
		strList.add(5);    // ②
		strList.forEach(str -> System.out.println(str.length())); // ③
	}
}

