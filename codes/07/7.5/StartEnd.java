
import java.util.regex.*;
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
public class StartEnd
{
	public static void main(String[] args)
	{
		// 建立一個Pattern物件，並用它建立一個Matcher物件
		String regStr = "Java is very easy!";
		System.out.println("目標字串是：" + regStr);
		Matcher m = Pattern.compile("\\w+")
			.matcher(regStr);
		while(m.find())
		{
			System.out.println(m.group() + "子串的起始位置："
				+ m.start() + "，其結束位置：" + m.end());
		}
	}
}
