
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
public class ListErr
{
	public static void main(String[] args)
	{
		// 建立一個只想存放字串的List集合
		List strList = new ArrayList();
		strList.add("瘋狂Java講義");
		strList.add("瘋狂Android講義");
		// "不小心"把一個Integer物件"丟進"了集合
		strList.add(5);     // ①
		strList.forEach(str -> System.out.println(((String)str).length())); // ②
	}
}
