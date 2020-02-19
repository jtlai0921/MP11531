
import java.time.*;
import java.time.format.*;
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
public class NewFormatterParse
{
	public static void main(String[] args)
	{
		// 定義一個任意格式的日期時間字串
		String str1 = "2014==04==12 01時06分09秒";
		// 根據需要解析的日期、時間字串定義解析所用的格式器
		DateTimeFormatter fomatter1 = DateTimeFormatter
			.ofPattern("yyyy==MM==dd HH時mm分ss秒");
		// 執行解析
		LocalDateTime dt1 = LocalDateTime.parse(str1, fomatter1);
		System.out.println(dt1); // 輸出 2014-04-12T01:06:09
		// ---下面程式碼再次解析另一個字串---
		String str2 = "2014$$$四月$$$13 20小時";
		DateTimeFormatter fomatter2 = DateTimeFormatter
			.ofPattern("yyy$$$MMM$$$dd HH小時");
		LocalDateTime dt2 = LocalDateTime.parse(str2, fomatter2);
		System.out.println(dt2); // 輸出 2014-04-13T20:00
	}
}
