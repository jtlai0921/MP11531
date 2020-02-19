
import java.util.*;
import java.text.*;
import static java.text.DateFormat.*;
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
public class DateFormatTest
{
	public static void main(String[] args)
		throws ParseException
	{
		// 需要被格式化的時間
		Date dt = new Date();
		// 建立兩個Locale，分別代表中國、美國
		Locale[] locales = {Locale.CHINA, Locale.US};
		DateFormat[] df = new DateFormat[16];
		// 為上面兩個Locale建立16個DateFormat物件
		for (int i = 0 ; i < locales.length ; i++)
		{
			df[i * 8] = DateFormat.getDateInstance(SHORT, locales[i]);
			df[i * 8 + 1] = DateFormat.getDateInstance(MEDIUM, locales[i]);
			df[i * 8 + 2] = DateFormat.getDateInstance(LONG, locales[i]);
			df[i * 8 + 3] = DateFormat.getDateInstance(FULL, locales[i]);
			df[i * 8 + 4] = DateFormat.getTimeInstance(SHORT, locales[i]);
			df[i * 8 + 5] = DateFormat.getTimeInstance(MEDIUM , locales[i]);
			df[i * 8 + 6] = DateFormat.getTimeInstance(LONG , locales[i]);
			df[i * 8 + 7] = DateFormat.getTimeInstance(FULL , locales[i]);
		}
		for (int i = 0 ; i < locales.length ; i++)
		{
			String tip = i == 0 ? "----中國日期格式----":"----美國日期格式----";
			System.out.println(tip);
			System.out.println("SHORT格式的日期格式："
				+ df[i * 8].format(dt));
			System.out.println("MEDIUM格式的日期格式："
				+ df[i * 8 + 1].format(dt));
			System.out.println("LONG格式的日期格式："
				+ df[i * 8 + 2].format(dt));
			System.out.println("FULL格式的日期格式："
				+ df[i * 8 + 3].format(dt));
			System.out.println("SHORT格式的時間格式："
				+ df[i * 8 + 4].format(dt));
			System.out.println("MEDIUM格式的時間格式："
				+ df[i * 8 + 5].format(dt));
			System.out.println("LONG格式的時間格式："
				+ df[i * 8 + 6].format(dt));
			System.out.println("FULL格式的時間格式："
				+ df[i * 8 + 7].format(dt));
		}


		String str1 = "2014-12-12";
		String str2 = "2014年12月10日";
		// 下面輸出 Fri Dec 12 00:00:00 CST 2014
		System.out.println(DateFormat.getDateInstance().parse(str1));
		// 下面輸出 Wed Dec 10 00:00:00 CST 2014
		System.out.println(DateFormat.getDateInstance(LONG).parse(str2));
		// 下面拋出 ParseException異常
//		System.out.println(DateFormat.getDateInstance().parse(str2));
	}
}
