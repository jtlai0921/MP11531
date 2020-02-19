
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
public class UnmodifiableTest
{
	public static void main(String[] args)
	{
		// 建立一個空的、不可改變的List物件
		List unmodifiableList = Collections.emptyList();
		// 建立一個只有一個元素，且不可改變的Set物件
		Set unmodifiableSet = Collections.singleton("瘋狂Java講義");
		// 建立一個普通Map物件
		Map scores = new HashMap();
		scores.put("語文" , 80);
		scores.put("Java" , 82);
		// 返回普通Map物件對應的不可變版本
		Map unmodifiableMap = Collections.unmodifiableMap(scores);
		// 下面任意一行程式碼都將引發UnsupportedOperationException異常
		unmodifiableList.add("測試元素");   //①
		unmodifiableSet.add("測試元素");    //②
		unmodifiableMap.put("語文" , 90);   //③
	}
}

