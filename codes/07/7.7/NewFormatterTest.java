
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
public class NewFormatterTest
{
	public static void main(String[] args)
	{
		DateTimeFormatter[] formatters = new DateTimeFormatter[]{
			// 直接使用常數建立DateTimeFormatter格式器
			DateTimeFormatter.ISO_LOCAL_DATE,
			DateTimeFormatter.ISO_LOCAL_TIME,
			DateTimeFormatter.ISO_LOCAL_DATE_TIME,
			// 使用本地化的不同風格來建立DateTimeFormatter格式器
			DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM),
			DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG),
			// 根據模式字串來建立DateTimeFormatter格式器
			DateTimeFormatter.ofPattern("Gyyyy%%MMM%%dd HH:mm:ss")
		};
		LocalDateTime date = LocalDateTime.now();
		// 依次使用不同的格式器對LocalDateTime進行格式化
		for(int i = 0 ; i < formatters.length ; i++)
		{
			// 下面兩行程式碼的作用相同
			System.out.println(date.format(formatters[i]));
			System.out.println(formatters[i].format(date));
		}
	}
}
