
import java.text.*;
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
public class SimpleDateFormatTest
{
	public static void main(String[] args)
		throws ParseException
	{
		Date d = new Date();
		// 建立一個SimpleDateFormat物件
		SimpleDateFormat sdf1 = new SimpleDateFormat("Gyyyy年中第D天");
		// 將d格式化成日期，輸出：西元2014年中第101天
		String dateStr = sdf1.format(d);
		System.out.println(dateStr);
		// 一個非常特殊的日期字串
		String str = "14###三月##21";
		SimpleDateFormat sdf2 = new SimpleDateFormat("y###MMM##d");
		// 將日期字串解析成日期，輸出：Fri Mar 21 00:00:00 CST 2014
		System.out.println(sdf2.parse(str));
	}
}
